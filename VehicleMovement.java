import java.util.List;

public class VehicleMovement {

    private void moveVehicle(Vehicle vehicle, RoadPosition position) {
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
        boolean exitedCurrentRoad = (currentRoad != null) && (changedRoads == false);

        // If the new road is not null, and the new road is different
        // from the current road, then the vehicle must have entered the new road
        boolean enteredNewRoad = (newRoad != null) && (changedRoads == false);

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

    public void process(List<Vehicle> vehicles) {

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
