import java.util.ArrayList;

public class VehicleMovement {

    public ArrayList<Vehicle> move(ArrayList<Vehicle> vehicles, LocationalMap locationMap, Simulation sim) {
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
        return vehicles;
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
