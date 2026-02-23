public class Vehicle {
    
    //assigning variables
    protected double x;                                   //position coordinates on map
    protected double y;

    protected VehicleColor color;
    protected double velocity;
    private double acceleration;
    private double direction; 
    
    protected RoadPosition currentRoadPosition;
    //protected Lane currentLane;
    

    //constructor
    Vehicle(double velocity, VehicleColor color, double x, double y,
                 double acceleration, double direction, RoadPosition position){
        this.velocity = velocity;                   //start velocity
        this.color = color;
        this.x = x;
        this.y = y;
        this.acceleration = acceleration;
        this.direction = direction; 
        this.currentRoadPosition = position;
    }

    public RoadPosition getVehiclePositionRoad(){
        return currentRoadPosition;
    }

    public void setPositionCoordinates(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void displayDetailsVehicle(){
        System.out.println("Vehicle details: ");
        System.out.println("Velocity: " + velocity);
        System.out.println("Position: " + x + ", " + y);
        System.out.println("Color: " + color);
        System.out.println("Acceleration: " + acceleration);
        System.out.println("Current direction (degrees): " + direction);
    }

    

}
