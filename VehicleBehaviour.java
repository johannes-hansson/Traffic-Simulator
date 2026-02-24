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

    /*
    public void computeLaneSwitches(Vehicle[] vehicles, LocationalMap locationalMap, 
                LaneSwitchDecision[] laneSwitchDecisions){
                    
                    int n_vehicles = getVehicleAmount();
                    
                    //all vehicles with vehicles in front -> store in vehiclesWithObstacles

            for(int i=0; i < n_vehicles; i++){
                
                double velocityThisVehicle = vehicles[i].velocity;

                        RoadPosition positionVehicle = vehicles[i].getVehiclePositionRoad();
                        Road road = positionVehicle.getRoad();
                        int roadLength = road.getLength();
                        
                        //check if vehicle is in front
                        
                        
                        if (){
                            boolean behindVehicle = setIsBehindVehicle();
                        }
                    }
                }
        */

    public void computeLaneSwitches(Vehicle[] vehicles, LocationalMap locationalMap, 
                LaneSwitchDecision[] laneSwitchDecisions){
                    
                
                }
        */

}
