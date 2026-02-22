public class Vehicle {
    
    //assigning variables
    private double x;                                   //position coordinates on map
    private double y;
    private VehicleColor color;
    private double velocity;
    private double acceleration;
    private double direction; 
    
    protected Road currentRoad;
    //protected Lane currentLane;
    

    //constructor
    Vehicle(double velocity, VehicleColor color, double x, double y,
                 double acceleration, double direction){
        this.velocity = velocity;                   //start velocity
        this.color = color;
        this.x = x;
        this.y = y;
        this.acceleration = acceleration;
        this.direction = direction; 
    }

    public void setPosition(double x, double y){
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
