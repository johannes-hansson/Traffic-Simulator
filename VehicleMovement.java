import java.util.ArrayList;

public class VehicleMovement {

    public void move(ArrayList<Vehicle> vehicles, LocationalMap locationMap) {
        for (Vehicle vehicle : vehicles) {
            int velocity = vehicle.getVelocity();
            RoadPosition position = vehicle.getPosition();

            Road road = position.road();
            int roadLength = road.getLength();
            int roadDistanceLeft = roadLength - position.cell();
            if (velocity > roadDistanceLeft) {
                velocity = roadDistanceLeft;
            }

            velocity = locationMap.scanAheadOf(position, velocity);
            vehicle.setVelocity(velocity);

            RoadPosition newPosition = new RoadPosition(
                position.road(), 
                position.cell() + velocity, 
                position.lane()
            );

            locationMap.moveVehicle(position, newPosition);
            vehicle.setPosition(newPosition);
        }
    }
    //Lane switching
    /*
    void PerformLaneSwitching(LaneSwitchDecision allLaneSwitches[], LocationalMap locationalMap){
        
    }
    */
}
