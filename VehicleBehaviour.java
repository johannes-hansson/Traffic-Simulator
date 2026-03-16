import java.util.Random;
import java.util.List;
import java.util.ArrayList;

//import Road.ScanResult;

public class VehicleBehaviour {

    private Random numberGenerator;
    private final double breakingProbability = 0.5; // 50% chance for vehicle to slow down by one unit
    private final int preferredDistance = 3; // # of cells that vehicles want to keep between themselves
    private final int laneSwitchSafeDistance = 20; // # required gap to cars behind when changing lanes

    // The distance away from an intersection where vehicles will start prioritizing getting
    // int the correct lane
    private final int turnLanePriorityDistance = 100;

    // Whether to reroute if a vehicle reaches an intersection in the wrong lane
    private final boolean forceRerouteOnWrongLane = true;

    public VehicleBehaviour() {
        this.numberGenerator = new Random(1);
    }

    public void process(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            // Reset the last LaneChangeDecision
            vehicle.setLaneChangeDecision(LaneChangeDecision.STRAIGHT);
            this.processVehicle(vehicle);
        }
    }

    public void processVehicle(Vehicle vehicle){

        int velocity = vehicle.getVelocity();
        RoadPosition position = vehicle.getPosition();
        int lane = position.lane();
        int cell = position.cell();

        // This flag will be set to false when a lane change decision is made
        // so that it cannot change later
        boolean canPerformLaneSwitch = true;

        /// Nagel-schreckenberg-model
        //1. Acceleration
        velocity = accelerate(vehicle, velocity);

        // Check if the vehicle needs to change lane or remain it its current lane for an upcoming turn
        LaneChangeDecision laneChange = this.getLaneChangeForTurn(vehicle, cell, lane);
        if (laneChange != null) {
            canPerformLaneSwitch = false;
            lane += laneChange.getDirection();
            vehicle.setLaneChangeDecision(laneChange);
        }

        //2. Deacceleration
        velocity = decelerate(vehicle, velocity, lane, canPerformLaneSwitch);

        //3. Randomization
        velocity = applyRandomBreaking(velocity, this.breakingProbability);

        vehicle.setVelocity(velocity);
    }

    private boolean canPerformLaneChange(Road road, int cell, int lane, LaneChangeDecision laneChange) {
        int toLane = lane + laneChange.getDirection();
        if (toLane < 0 || toLane >= road.getLanes()) {
            return false;
        }

        if (cell < Math.min(this.laneSwitchSafeDistance, road.getLength() - 5)) {
            return false;
        }

        // Check that the lane is safe to switch to
        // Add 1 to the scan distance to include the cell adjacent to the current cell
        int scanDistance = this.laneSwitchSafeDistance + 1;
        int scanStart = Math.max(cell - this.laneSwitchSafeDistance, 0);
        Road.ScanResult scan = road.scanCells(toLane, scanStart, scanDistance, true);

        // If the scan completed without detecting a vehicle, the lane switch is safe to perform
        return !scan.wasBlocked();
    }

    // Takes a node that the vehicle has reached and computes the amount
    // of cells the vehicle can travel after the node.
    // Returns 0 if the vehicle can not enter the node.
    // If the vehicle cannot make its planned turn from its current lane,
    // it will be forced to reroute based on the available roads from
    // its current lane if forceReroute is true
    private int getFreeDistanceAfterTurn(
        Road road,
        int lane,
        Vehicle vehicle,
        int maxDistance,
        boolean forceReroute
    ) {

        Node node = road.getEndNode();
        ArrayList<Road> availableTurns;
        if (forceReroute) {
            availableTurns = node.getAvailableTurnsFromLane(road, lane);
        } else {
            availableTurns = node.getAvailableTurns(road);
        }
        Road roadToEnter = vehicle.chooseRoad(road, availableTurns);

        if (roadToEnter == null) {
            return 0;
        }

        boolean canTurn = node.requestTurn(road, roadToEnter);
        if (!canTurn) {
            return 0;
        }

        // If the lane to enter is not reassigned from -1, 
        // the turn cannot be made from the current lane
        int laneToEnter = 0;
        boolean lanePairFound = false;

        int[][] laneMap = node.getLaneMap(road, roadToEnter);
        for (int i = 0; i < laneMap.length; i++) {
            if (laneMap[i][0] == lane) {
                laneToEnter = laneMap[i][1];
                lanePairFound = true;
                break;
            }
        }
        if (!lanePairFound) {
            return 0;
        }

        // If the vehicle is able to make the turn, scan the following road
        Road.ScanResult scanResult = roadToEnter.scanCells(laneToEnter, 0, maxDistance, true, preferredDistance);
        
        // If the scan reached the end of the road, call the method recursively
        // to get the free distance on the next road
        if (scanResult.endOfRoadReached()) {
            return scanResult.bufferDistance() + this.getFreeDistanceAfterTurn(
                    roadToEnter,
                    laneToEnter,
                    vehicle,
                    maxDistance - scanResult.bufferDistance(),
                    false
            );
        }

        return scanResult.bufferDistance();
    }

    // Returns an accelerated velocity based on the properties of a vehicle
    // Velocity = min(currentVelocity + acceleration, maxVelocity)
    private int accelerate(Vehicle vehicle, int currentVelocity) {
        VehicleProperties properties = vehicle.getProperties();
        int newVelocity = currentVelocity + properties.acceleration();
    
        return Math.min(newVelocity, properties.maxVelocity());
    }

    private LaneChangeDecision getLaneChangeForTurn(Vehicle vehicle, int cell, int currentLane) {
        Road currentRoad = vehicle.getPosition().road();
        if (cell + this.turnLanePriorityDistance < currentRoad.getLength()) return null;

        // Get the turn that the vehicle wants to make
        Node node = currentRoad.getEndNode();
        Road requestedTurn = vehicle.chooseRoad(currentRoad, node.getAvailableTurns(currentRoad));
        if (requestedTurn == null) return null;

        // Check if the vehicle is already in a correct lane
        int[][] laneMap = node.getLaneMap(currentRoad, requestedTurn);

        if (laneMap.length == 0) {
            System.out.println("Vehicle requested a turn to a road that did not have a lane map to the current road");
            return null;
        }

        for (int lanePairIndex=0; lanePairIndex < laneMap.length; lanePairIndex++) {
            if (laneMap[lanePairIndex][0] == currentLane) {
                return LaneChangeDecision.STRAIGHT;
            }
        }

        // If the vehicle is not in a correct lane, check which direction it has to change it
        int laneChangeDirection = laneMap[0][0] - currentLane;
        LaneChangeDecision laneChange;
        if (laneChangeDirection > 0) {
            laneChange = LaneChangeDecision.LEFT;
        } else {
            laneChange = LaneChangeDecision.RIGHT;
        }

        // Check if the needed lane change is possible.
        // If it is, return it. If it is not, remain in the current lane
        if (this.canPerformLaneChange(currentRoad, cell, currentLane, laneChange)) {
            return laneChange;
        }

        return LaneChangeDecision.STRAIGHT;
    }

    // Returns a decelerated velocity based on the available gap in the given lane
    // The new velocity accounts for possible turns, where it includes the gap
    // on roads ahead if the turn is possible
    private int decelerate(Vehicle vehicle, int currentVelocity, int currentLane, boolean canChangeLane) {
        RoadPosition position = vehicle.getPosition();
        Road road = position.road();
        int cell = position.cell();

        // scan the road (get the free gap between in front of vehicle/intersection)
        Road.ScanResult scanResult = road.scanCells(currentLane, cell, currentVelocity, false, preferredDistance);

        // If the current velocity is blocked by another vehicle, attempt to change lane
        // The velocity is considered block either if another vehicle is in its path
        // or if another vehicle is within the buffer distance
        boolean withinBufferDistanceOfVehicle = scanResult.bufferDistance() < scanResult.distance();
        boolean laneChangeWanted = withinBufferDistanceOfVehicle || scanResult.wasBlocked();
        if (laneChangeWanted && canChangeLane) {
            LaneChangeDecision laneChange = LaneChangeDecision.LEFT;
            if (this.canPerformLaneChange(road, cell, currentLane, laneChange)) {
                currentLane += laneChange.getDirection();
                vehicle.setLaneChangeDecision(laneChange);

                // Reperform the initial scan on the new lane
                scanResult = road.scanCells(currentLane, cell, currentVelocity, false, preferredDistance);
            }
        }

        // If the conditions for overtaking do not apply, check if the vehicle can
        // change lanes to the right
        if (!laneChangeWanted && canChangeLane && currentLane > 0) {
            Road.ScanResult prospectiveScan = road.scanCells(currentLane-1, cell, currentVelocity, false, preferredDistance);
            if (!prospectiveScan.wasBlocked() && (prospectiveScan.distance() == prospectiveScan.bufferDistance())) {
                LaneChangeDecision laneChange = LaneChangeDecision.RIGHT;
                if (this.canPerformLaneChange(road, cell, currentLane, laneChange)) {
                    currentLane += laneChange.getDirection();
                    vehicle.setLaneChangeDecision(laneChange);
                }
            }
        }

        int deceleratedVelocity = scanResult.bufferDistance();

        // Add the gap on following roads if the vehicle can turn
        if (scanResult.endOfRoadReached()) {
            // If the scan reached the end of the road, but the available gap
            // is 0, then the vehicle is next to an intersection.
            // This flag will be used with forceRerouteOnWrongLane to determine
            // if the vehicle should be forced to reroute if it is in the
            // wrong lane
            boolean atIntersection = deceleratedVelocity <= 0;

            int remainingDistance = currentVelocity - deceleratedVelocity;
            deceleratedVelocity += this.getFreeDistanceAfterTurn(
                    road,
                    currentLane,
                    vehicle,
                    remainingDistance,
                    atIntersection && this.forceRerouteOnWrongLane
            );
        }

        return deceleratedVelocity;
    }

    // Applies a deceleration to the given velocity of one unit based on the probability p
    private int applyRandomBreaking(int velocity, double p){
        double randomDouble = this.numberGenerator.nextDouble();  //generates a random double between 0.0 and 1.0

        if (randomDouble <= p) {
            velocity = Math.max(velocity-1, 0);
        }

        return velocity;
    }
        
    /* Nagel-schreckenberg-model
            Every car agent i follows the rules: 
        1. Acceleration: vi <- min (vi+1,vmax), 
        2. Deceleration to avoid accidents: vi <- min (vi,gap), 
        3. Randomisation: with a certain probability p do  
         vi <- max (vi-1,0) 
        4. Movement: xi <- xi+vi  */
}
