import java.util.List;

public class VehicleBehaviour {
    
    public List<LaneSwitchDecision> computeLaneSwitches() {
        return null;
    }

    public void computeVelocities(List<Vehicle> vehicles) {
        for (Vehicle vehicle: vehicles) {

            VehicleProperties properties = vehicle.getProperties();
            int newVelocity = vehicle.getVelocity() + properties.acceleration(); 
            if(newVelocity < properties.maxVelocity()){
                vehicle.setVelocity(newVelocity);}
        }
    }
            /*Every car agent i follows the rules: 
        1. Acceleration: vi <- min (vi+1,vmax), 
        2. Deceleration to avoid accidents: vi <- min (vi,gap), 
        3. Randomisation: with a certain probability p do  
         vi <- max (vi-1,0) 
        4. Movement: xi <- xi+vi   */

    

    public void computeLaneSwitches(Vehicle[] vehicles, LocationalMap locationalMap, 
                LaneSwitchDecision[] laneSwitchDecisions){
                    
                
                }
    

}
