import java.util.ArrayList;

public class LocationalMap { //changed name for more clarity
    
    public boolean isOccupied(RoadPosition position) {
        return false;
    }

    public void loadRoads(Road[] roads) {};
    public void addVehicle(Vehicle newVehicle, RoadPosition startPosition) {
        //create randomized spot for the spawn of the new vehicle on map
    };
    public void moveVehicle(RoadPosition from, RoadPosition to) {};

    
    
    public Vehicle[] getVehiclesOnRoad(Road road){  //get all vehicles that are on same road
        
        int n_vehicles = Simulation.getVehicleAmount();
        int j=0;

        ArrayList<Vehicle> allVehicles = new ArrayList<>(); //then set to = getAllVehicles function

        ArrayList<Vehicle> vehiclesOnRoad = new ArrayList<>();

        for(int i=0; i<n_vehicles; i++){
            Vehicle currVehicle = allVehicles[i];
            RoadPosition currPosition = currVehicle.getVehiclePositionRoad();
            Road currRoad = currPosition.getRoad();
            
            if(currRoad == road){
                j++;
                vehiclesOnRoad[j] = allVehicles[i];    
        }
        
        //---
        return vehiclesOnRoad[];
    }
}
