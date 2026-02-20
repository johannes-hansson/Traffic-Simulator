public class Vehicle {
    
    //assigning variables
    private double velocity;
    private VehicleColor color;
    private double x;                                   //position coordinates
    private double y;
    //vehicle properties

    //constructor
    Vehicle(double velocity, VehicleColor color, double x, double y){
        this.velocity = velocity;                   //start velocity
        this.color = color;
        this.x = x;
        this.y = y;
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
    }

    

}
