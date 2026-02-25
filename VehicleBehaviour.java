import java.util.ArrayList;

public class VehicleBehaviour {
    
    private void processVehicle(Vehicle vehicle) {
        RoadPosition position = vehicle.getPosition();
        VehicleProperties properties = vehicle.getProperties();
        int currentVelocity = vehicle.getVelocity();
        int acceleration = properties.acceleration();
        Road currentRoad = position.road();
        int currentLane = position.lane();
        int currentCell = position.cell();

        int desiredVelocity = currentVelocity + acceleration;
        int newVelocity = 0;
        int currentGap = currentRoad.getGap(currentLane, currentCell);
        newVelocity = Math.min(currentGap, desiredVelocity);
        vehicle.setVelocity(newVelocity);
    }

    public void process(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            this.processVehicle(vehicle);
        }
    }

    // public void computeVelocities(ArrayList<Vehicle> vehicles) {
    //     for (Vehicle vehicle: vehicles) {
    //         VehicleProperties properties = vehicle.getProperties();
    //         int newVelocity = vehicle.getVelocity() + properties.acceleration();
    //         vehicle.setVelocity(newVelocity);
    //     }
    // }
}
