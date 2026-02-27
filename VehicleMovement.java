import java.util.List;

public class VehicleMovement {

    /* 
    Moves a vehicle from its current position to the given position
    and sends an update to the affected roads about the position change,
    so that the roads can update their internal lookup tables.

    Does not check for collisions and will cause any vehicle it collides with
    to be overwritten in the roads lookup table. This would cause that
    vehicle to disapear from the lookup table which would lead to significant 
    state corruption. The availability/vacancy of the given position thus always needs
    to be confirmed before calling the method.

    NOTE: For testing purposes, the method does check that the given position
    is available before moving. This check will be removed for performance.
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
        if (velocity == 0) {
            return;
        }

        RoadPosition position = vehicle.getPosition();

        // State variables that will be continuously updated and have their final value applied
        Road currentRoad = position.road();
        int currentLane = position.lane();
        int currentCell = position.cell();

        Road.ScanResult scanResult = currentRoad.scanCells(currentLane, currentCell, velocity);
        int distanceTravelled = scanResult.distance();
        currentCell += scanResult.distance();

        // If the scan reaches the end of the current road, find a
        // road to turn to and, if possible, make the turn and rerun the scan
        while (scanResult.endOfRoadReached()) {
            Node node = currentRoad.getEndNode();
            Road roadToEnter = vehicle.getDesiredTurn(node, currentRoad);

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
            System.out.println("Vehicle turned from road " + currentRoad.name + " to road " + roadToEnter.name);
            currentRoad = roadToEnter;
            currentLane = laneToEnter;
            scanResult = currentRoad.scanCells(currentLane, 0, velocity - distanceTravelled);
            currentCell = scanResult.distance();
            distanceTravelled += scanResult.distance();
        }

        if (scanResult.wasBlocked()) {
            System.out.println("Warning: Vehicle had a velocity that would have caused a collision");
        }

        if (distanceTravelled == 0) return;

        RoadPosition newPosition = new RoadPosition(
            currentRoad,
            currentLane,
            currentCell
        );

        System.out.println("Vehicle moved to cell " + Integer.toString(currentCell));

        this.moveVehicle(vehicle, newPosition);
    }

    public void process(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            this.processVehicle(vehicle);
        }
    }

    public void move(List<Vehicle> vehicles, LocationalMap locationMap, Simulation sim) {
        VehicleBehaviour vehicleBehaviour = new VehicleBehaviour();

        for (Vehicle vehicle : vehicles) {
        ///for loop for all vehicles here
            RoadPosition position = vehicle.getPosition();
        /// 
        //1. Acceleration
            int velocity = vehicleBehaviour.accelerate(vehicle); //call from vehicleBehavior
            vehicle.setVelocity(velocity);

        //2. Deacceleration
            velocity = vehicleBehaviour.deaccelerate(vehicle, locationMap, sim); //sim to get vehicle list in a built-in func (isOccupied)
            vehicle.setVelocity(velocity);

        //3. Randomization
            double p = 0.5;    //50% chance for vehicle to slow down by one unit
            velocity = vehicleBehaviour.randomisation(vehicle, p);
            
        //4. Movement
        RoadPosition newPosition = new RoadPosition(
                position.road(), 
                position.cell() + velocity, 
                position.lane()
            );
        locationMap.moveVehicle(position, newPosition);
        vehicle.setPosition(newPosition);
        }
    }    

     /* Nagel-schreckenberg-model
            Every car agent i follows the rules: 
        1. Acceleration: vi <- min (vi+1,vmax), 
        2. Deceleration to avoid accidents: vi <- min (vi,gap), 
        3. Randomisation: with a certain probability p do  
         vi <- max (vi-1,0) 
        4. Movement: xi <- xi+vi  */

    //Lane switching
    /*
    void PerformLaneSwitching(LaneSwitchDecision allLaneSwitches[], LocationalMap locationalMap){
      */  
    
    
}
