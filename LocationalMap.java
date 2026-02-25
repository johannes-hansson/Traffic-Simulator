import java.util.ArrayList;
import java.util.List;

public class LocationalMap { 
    
    public boolean isOccupied(RoadPosition position) {
        List<Vehicle> vehicles = Simulation.getVehicles(); //<-different implmementation needed here
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
        int cellsBeforeVehicle = 0; //amount of empty cells before next vehicle
        int cellsAhead = velocity;  //is not longer than existing road (defined in VehicleMovement)
       
        for(int currentCell=1; currentCell<cellsAhead; currentCell++){   
            RoadPosition lookPosition = new RoadPosition(
            position.road(), 
            position.cell() + currentCell, 
            position.lane()
            );

            if(isOccupied(lookPosition) == false){
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
    
    
    public List<Vehicle> getVehiclesOnRoad(Road road){  //get all vehicles that are on same road
        int n_vehicles = Simulation.getVehicleAmount();
        List<Vehicle> vehicles = Simulation.getVehicles(); //<-different implmementation needed here

        List<Vehicle> allVehicles = new ArrayList<>(); // set to = getAllVehicles function
        List<Vehicle> vehiclesOnRoad = new ArrayList<>();

        for(Vehicle vehicle: allVehicles){                  //for all vehicles
            RoadPosition currPosition = vehicle.getPosition();
            Road currRoad = currPosition.road();
            
            if(currRoad == road){       // check if the vehicle is on the road from input
                vehiclesOnRoad.add(vehicle); } //add vehicle on the specified road to list of participants on road 
            }
        return vehiclesOnRoad;
    }
}
