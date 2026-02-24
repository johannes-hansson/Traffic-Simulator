public class Vehicle {
    
    //assigning variables
    private VehicleProperties properties;
    private RoadPosition position; 
    private int velocity;
    
    //constructor
    Vehicle(VehicleProperties properties, RoadPosition position){
        this.properties = properties;
        this.position = position;
        this.velocity = 0; 
    }

    public RoadPosition getPosition() {
        return this.position;
    }

    public VehicleProperties getProperties() {
        return this.properties;
    }

    public void displayDetailsVehicle(){
        System.out.println("Vehicle details: ");
        System.out.println("Velocity: " + velocity);
        System.out.println("Road: " + this.position.getRoad());
        System.out.println("Acceleration: " + this.properties.acceleration());
    }
}
