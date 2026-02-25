import java.util.ArrayList;

public class VehicleMovement {

    public ArrayList<Vehicle> move(ArrayList<Vehicle> vehicles, LocationalMap locationMap) {
        for (Vehicle vehicle : vehicles) {
        ///for loop for all vehicles here
            RoadPosition position = vehicle.getPosition();
            Road road = position.road();
            int roadLength = road.getLength();
        /// 
        //1. Acceleration
            int velocity = VehicleBehaviour.accelerate(vehicle); //call from vehicleBehavior
            vehicle.setVelocity(velocity);

        //2. Deacceleration
            int velocity = VehicleBehaviour.deaccelerate(vehicle, locationMap)
            vehicle.setVelocity(velocity);

        //3. Randomization
            
        //4. Movement
        RoadPosition newPosition = new RoadPosition(
                position.road(), 
                position.cell() + velocity, 
                position.lane()
            );
        locationMap.moveVehicle(position, newPosition);
        vehicle.setPosition(newPosition);
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
        
    }
    */
}
