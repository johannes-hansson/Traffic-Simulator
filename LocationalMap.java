import java.util.ArrayList;

public class LocationalMap { 
    
    public boolean isOccupied(ArrayList<Vehicle> vehicles, RoadPosition position) {
        for (Vehicle vehicle: vehicles){

            RoadPosition vehiclePosition = vehicle.getPosition(); 

            Road vehicleRoad = vehiclePosition.road();
            int vehicleCell = vehiclePosition.cell();
            int vehicleLane = vehiclePosition.lane();

            if((vehicleRoad == position.road())&&   //check for any vehicle that exists on specific position 
                (vehicleCell == position.cell())&&
                (vehicleLane == position.lane())){
                return true;
            }
        }
        return false;
    }

    public void loadRoads(Road[] roads) {};
    public void addVehicle(Vehicle newVehicle, RoadPosition startPosition) {

    };
    public void moveVehicle(RoadPosition from, RoadPosition to) {};

    public int scanAheadOf(RoadPosition position, int velocity){
        List<Vehicle> vehicles = Simulation.getVehicles(); //<-different implmementation needed here

        int cellsBeforeVehicle = 0; //amount of empty cells before next vehicle
        int cellsAhead = velocity;  //is not longer than existing road (defined in VehicleMovement)
       
        for(int currentCell=1; currentCell<cellsAhead; currentCell++){
                
            RoadPosition lookPosition = new RoadPosition(
            position.road(), 
            position.cell() + currentCell, 
            position.lane()
            );

            if(isOccupied(vehicles, lookPosition) == false){
                cellsBeforeVehicle++;
            }
            lookPosition = null; 
        }

        return cellsBeforeVehicle;
    };

    public int scanBackOf(RoadPosition position, int velocity){
        int cellsBehindVehicle; //amount of empty cells behind vehicle
        return cellsBehindVehicle;
    };
    
    
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
