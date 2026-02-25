import java.util.ArrayList;

public class VehicleMovement {

    public void process(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetailsVehicle();
        }
    }

}
