public class Vehicle {
    
    private VehicleProperties properties;
    private RoadPosition position;
    private int velocity;

    // Lane switch direction values:
    //  0: Straight
    //  1: Left
    // -1: Right
    private int laneSwitchDirection;

    //constructor
    Vehicle(VehicleProperties properties, RoadPosition position){
        this.properties = properties;
        this.position = position;
        this.velocity = 0;
        this.laneSwitchDirection = 0;
    }

    public int getVelocity() {
        return this.velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getLaneSwitchDirection() {
        return this.laneSwitchDirection;
    }

    public void setLaneSwitchDirection(int laneSwitchDirection) {
        this.laneSwitchDirection = laneSwitchDirection;
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
