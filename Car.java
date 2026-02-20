class Car extends Vehicle { //subclass to vehicle
      
    private double maxVelocity;

    Car(double velocity, VehicleColor color, double x, double y, double maxVelocity){
        super(velocity, color, x, y);   //Calls for the super class Vehicle
        this.maxVelocity = maxVelocity;
    }

    public void setMaxVelocity(double maxVelocity){
        this.maxVelocity = maxVelocity;
    }

    @Override
    public void displayDetailsVehicle(){
        super.displayDetailsVehicle();
        System.out.println("Max velocity: " + maxVelocity);
    }
}
