import java.util.ArrayList;

public class VehicleBehaviour {
    
    
    private boolean IsBehindVehicle;

    public boolean setIsBehindVehicle(){
        return IsBehindVehicle = true;
    }

    public ArrayList<LaneSwithDecision> computeLaneSwitches() {
        return null;
    }

    public void computeVelocities(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle: vehicles) {
            VehicleProperties properties = vehicle.getProperties();
            int newVelocity = vehicle.getVelocity() + properties.acceleration();
            vehicle.setVelocity(newVelocity);
        }
    }

    

    public void computeLaneSwitches(Vehicle[] vehicles, LocationalMap locationalMap, 
                LaneSwitchDecision[] laneSwitchDecisions){
                    
                
                }
    

}
