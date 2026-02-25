class Car extends Vehicle { //subclass to vehicle

    //Constructor
    public Car(RoadPosition startPosition, int initialVelocity, VehicleColor color) {
        super(
                new VehicleProperties(
                        5,
                        1,
                        1,
                        color
                ),
                startPosition,
                initialVelocity
        );
    }

        @Override
        public void displayDetailsVehicle () {
            super.displayDetailsVehicle();
            System.out.println("Max velocity: " + getProperties().maxVelocity());
            System.out.println("Size (cells): " + getProperties().size());
            System.out.println("Color: " + getProperties().color());
        }
    }
