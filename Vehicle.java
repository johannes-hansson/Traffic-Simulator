import java.util.ArrayList;

public class Vehicle {
    
    private VehicleProperties properties;
    private RoadPosition position;
    private int velocity;


    //constructor
    public Vehicle(VehicleProperties properties, RoadPosition position, int velocity){
        this.properties = properties;
        this.position = position;
        this.velocity = velocity;
    }

    public Road chooseRoad(ArrayList<Road> roads) {
        if (roads.size() == 0) {
            return null;
        }
        return roads.get(0);
    }

    public int getVelocity() {
        return this.velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public VehicleProperties getProperties() {
        return this.properties;
    }

    public void setPosition(RoadPosition position) {
        this.position = position;
    }

    public RoadPosition getPosition() {
        return this.position;
    }

    public void displayDetailsVehicle(){
        System.out.println("Vehicle details: ");
        System.out.println("Velocity: " + velocity);
        System.out.println("Road: " + this.position.road());
    }
}
