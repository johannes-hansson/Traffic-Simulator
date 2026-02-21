class Car extends Vehicle { //subclass to vehicle
      
    private double maxVelocity; 
    private int size;

    //Constructor
    Car(double velocity, VehicleColor color, double x, double y, 
            double acceleration, double direction, double maxVelocity, int size){
       
        super(velocity, color, x, y, acceleration, direction);   //Calls for the super class Vehicle
        this.maxVelocity = maxVelocity;
        this.size = size;
    }

    public void setMaxVelocity(double maxVelocity){
        this.maxVelocity = maxVelocity;
    }

    @Override
    public void displayDetailsVehicle(){
        super.displayDetailsVehicle();
        System.out.println("Max velocity: " + maxVelocity);
        System.out.println("Size of vehicle (in cell): " + size);
    }
}
