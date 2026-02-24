public class Vehicle {
    
    private VehicleProperties properties;
    private RoadPosition position;
    private int velocity;
    private Color color;

    //constructor
    Vehicle(VehicleProperties properties, RoadPosition position, int velocity){
        this.properties = properties;
        this.position = position;
        this.velocity = velocity;
    }

    public VehicleProperties getProperties(){
        return this.properties;
    }

    public RoadPosition getPosition() {
        return this.position;
    }

    public void displayDetailsVehicle(){
        System.out.println("Vehicle details: ");
        System.out.println("Velocity: " + velocity);
        System.out.println("Road: " + this.position.getRoad());
        System.out.println("Acceleration: " + this.properties.acceleration());
    }
}
