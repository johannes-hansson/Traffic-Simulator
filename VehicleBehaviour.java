public class VehicleBehaviour {
    
    
    private boolean IsBehindVehicle;

    public int getVehicleAmount(){
        int n_vehicles = 10;
        return n_vehicles;
    }

    public boolean setIsBehindVehicle(){
        return IsBehindVehicle = true;
    }

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

}
