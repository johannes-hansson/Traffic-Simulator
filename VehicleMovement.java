import java.util.List;
import java.util.ArrayList;

/** Applies vehicle movement for a tick by updating each vehicle's RoadPosition
 * This class is responsible for the "state mutation" step: positions are updated and
 * the spatial/locational map is informed about moves.
 * In the planned architecture, movement is applied after behaviour has determined
 * desired velocities and lane decisions. */
public class VehicleMovement {

    // public ArrayList<Vehicle> move(ArrayList<Vehicle> vehicles, LocationalMap locationMap, Simulation sim) {

    /* 
    Moves a vehicle from its current position to the given position
    and sends an update to the affected roads about the position change,
    so that the roads can update their internal lookup tables.
    */
    private void moveVehicle(Vehicle vehicle, RoadPosition position) {
        if (position.road().isOccupied(position.lane(), position.cell())) {
            System.err.println("Attempted to move a vehicle to an occupied cell");
            return;
        }

        RoadPosition currentPosition = vehicle.getPosition();

        Road currentRoad = currentPosition.road();
        Road newRoad = position.road();

        // Edge case for when the vehicle was not on a previous road
        // and did not enter a new road
        // This edge case should never occur
        if (currentRoad == null && newRoad == null) {
            vehicle.setPosition(position);
            return;
        }

        boolean changedRoads = currentRoad != newRoad;

        // If the current road is not null, and the current road is different
        // from the new road, then the vehicle must have left the current road
        boolean exitedCurrentRoad = (currentRoad != null) && (changedRoads == true);

        // If the new road is not null, and the new road is different
        // from the current road, then the vehicle must have entered the new road
        boolean enteredNewRoad = (newRoad != null) && (changedRoads == true);

        if (exitedCurrentRoad) {
            currentRoad.removeVehicleAt(currentPosition.lane(), currentPosition.cell());
        }

        if (enteredNewRoad) {
            newRoad.enterVehicle(vehicle, position.lane(), position.cell());
        }

        // By this point, it has been confirmed that the current road and the new road
        // are not both null
        // If they are the same, then neither of them can be null and the vehicle must have moved
        // within the same road 
        if (changedRoads == false) {
            newRoad.moveVehicle(
                currentPosition.lane(), 
                currentPosition.cell(),
                position.lane(),
                position.cell()
            );
        }

        vehicle.setPosition(position);
    }

    private void processVehicle(Vehicle vehicle) {
        int velocity = vehicle.getVelocity();

        RoadPosition position = vehicle.getPosition();

        // State variables that will be continuously updated and have their final values applied
        Road currentRoad = position.road();
        int currentLane = position.lane();
        int currentCell = position.cell();

        // Lane changes
        LaneChangeDecision laneChange = vehicle.getLaneChangeDecision();
        int newLane = currentLane + laneChange.getDirection();

        if (newLane != currentLane) {
            // Check the bounds of the lanes
            if (newLane < 0 || newLane >= currentRoad.getLanes()) {
                System.err.println("Vehicle wanted to change to an out of bounds lane");
            } else {
                if (!currentRoad.isOccupied(newLane, currentCell)) {
                    currentLane = newLane;
                } else {
                    //System.out.println("Warning: Vehicle attempted to make a lane change that would have caused a collision");
                }
            }
        }


        Road.ScanResult scanResult = currentRoad.scanCells(currentLane, currentCell, velocity, false);
        int distanceTravelled = scanResult.distance();
        currentCell += scanResult.distance();

        // If the scan reaches the end of the current road, find a
        // road to turn to and, if possible, make the turn and rerun the scan
        while (scanResult.endOfRoadReached()) {
            Node node = currentRoad.getEndNode();
            Road roadToEnter = vehicle.chooseRoad(currentRoad, node.getAvailableTurns(currentRoad));

            // Check that the turn to the new road can be made
            boolean canTurn = node.requestTurn(currentRoad, roadToEnter);
            if (canTurn == false) {
                System.out.println("Vehicle requested a turn that it cannot currently make");
                break;
            }

            // Check that the turn can be made from the current lane
            // and check what lane on the new road that the current lane leads to
            int laneToEnter = -1;
            int[][] laneMap = node.getLaneMap(currentRoad, roadToEnter);
            for (int i = 0; i < laneMap.length; i++) {
                if (laneMap[i][0] == currentLane) {
                    laneToEnter = laneMap[i][1];
                    break;
                }
            }
            if (laneToEnter == -1) {
                System.out.println("Vehicle requested a turn that it could not make from its current lane");
                break;
            }

            // Make the turn
            scanResult = roadToEnter.scanCells(laneToEnter, 0, velocity - distanceTravelled, true);
            if (scanResult.distance() <= 0) {
                break;
            }

            vehicle.onTurnedFromRoad(currentRoad);

            currentRoad = roadToEnter;
            currentLane = laneToEnter;
            currentCell = scanResult.distance() - 1;
            distanceTravelled += scanResult.distance();
        }

        if (scanResult.wasBlocked()) {
            //System.out.println("Warning: Vehicle had a velocity that would have caused a collision");
        }

        if (distanceTravelled == 0) return;

        RoadPosition newPosition = new RoadPosition(
            currentRoad,
            currentLane,
            currentCell
        );

        this.moveVehicle(vehicle, newPosition);
    }

    public void process(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            this.processVehicle(vehicle);
        }
    }

    //Lane switching
    /*
    void PerformLaneSwitching(LaneSwitchDecision allLaneSwitches[], LocationalMap locationalMap){
      */  
    
    
}
