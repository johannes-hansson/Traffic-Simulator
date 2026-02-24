public class VehicleBehaviour {
    
    
    private boolean IsBehindVehicle;


    public boolean setIsBehindVehicle(){
        return IsBehindVehicle = true;
    }

    public LaneSwitchDecision[] LaneSwitchDecision(Vehicle[] allVehicles){   //store all vehicles tp do lane switch 
        int n_vehicles = Simulation.getVehicleAmount();
            
            //all vehicles with vehicles in front -> store in vehiclesWithObstacles

            for(int i=0; i < n_vehicles; i++){
                
                double velocityThisVehicle = vehicles[i].velocity;

                RoadPosition positionVehicle = vehicles[i].getVehiclePositionRoad();
                Road road = positionVehicle.getRoad();
                int roadLength = road.getLength();
                
                //check if there is vehicle is in front
                //call location function to get "scan" of 

                if (){
                    boolean behindVehicle = setIsBehindVehicle();
                }
            }
    }

    public void computeLaneSwitches(Vehicle[] vehicles, LocationalMap locationalMap, 
                LaneSwitchDecision[] laneSwitchDecisions){
                    
                
                }

}
