import java.util.ArrayList;

public class VehicleMovement {

    public ArrayList<Vehicle> move(ArrayList<Vehicle> vehicles, LocationalMap locationMap) {
        for (Vehicle vehicle : vehicles) {
        ///for loop for all vehicles here
        /// 
        //1. Acceleration
        int velocity = VehicleBehaviour.accelerate(vehicle);

        //2. Deacceleration
            RoadPosition position = vehicle.getPosition();
            Road road = position.road();
            int roadLength = road.getLength();

            RoadPosition newPosition = new RoadPosition(
                position.road(), 
                position.cell() + velocity, 
                position.lane()
            );
        //3. Randomization

        //4. Movement
        locationMap.moveVehicle(position, newPosition);
        vehicle.setPosition(newPosition);
    }
    //Lane switching
    /*
    void PerformLaneSwitching(LaneSwitchDecision allLaneSwitches[], LocationalMap locationalMap){
        
    }
    */
}
