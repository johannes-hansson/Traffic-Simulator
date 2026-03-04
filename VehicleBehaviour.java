import java.util.Random;
import java.util.List;

public class VehicleBehaviour {

    static final double brakeProbability = 0.5;

    public void processVehicle(Vehicle vehicle) {
        RoadPosition currentPosition = vehicle.getPosition();

        int desiredVelocity = this.accelerate(vehicle);
        int safeVelocity = this.deaccelerate(vehicle, currentPosition.lane(), desiredVelocity);
        int finalVelocity = this.applyRandomizedBrake(safeVelocity, VehicleBehaviour.brakeProbability);
        vehicle.setVelocity(finalVelocity);
    }

    public void process(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            this.processVehicle(vehicle);
        }
    }

    // Takes a node that the vehicle has reached and computes
    // amount of cells the vehicle can travel after the node
    // Returns 0 if the vehicle can not enter the node
    public int getFreeDistanceAfterTurn(
            Road road,
            int lane,
            Vehicle vehicle,
            int maxDistance
    ) {

        Node node = road.getEndNode();
        Road roadToEnter = vehicle.chooseRoad(node.getAvailableTurns(road));

        boolean canTurn = node.requestTurn(road, roadToEnter);
        if (canTurn == false) {
            return 0;
        }

        // If the lane to enter is not reassigned from -1,
        // the turn cannot be made from the current lane
        int laneToEnter = -1;

        int[][] laneMap = node.getLaneMap(road, roadToEnter);
        for (int i = 0; i < laneMap.length; i++) {
            if (laneMap[i][0] == lane) {
                laneToEnter = laneMap[i][1];
                break;
            }
        }
        if (laneToEnter == -1) {
            return 0;
        }

        // If the vehicle is able to make the turn, scan the following road
        Road.ScanResult scanResult = roadToEnter.scanCells(laneToEnter, 0, maxDistance, true);

        // If the scan reached the end of the road, call the method recursively
        // to get the free distance on the next road
        if (scanResult.endOfRoadReached()) {
            return scanResult.distance() + this.getFreeDistanceAfterTurn(
                    roadToEnter,
                    laneToEnter,
                    vehicle,
                    maxDistance - scanResult.distance()
            );
        }

        return scanResult.distance();
    }

    public int accelerate(Vehicle vehicle) { //Acceleration: vi <- min (vi+1,vmax)
        VehicleProperties properties = vehicle.getProperties();
        int prevVelocity = vehicle.getVelocity();
        int newVelocity = prevVelocity + properties.acceleration();

        if(newVelocity < properties.maxVelocity()) { //acceleration cant pass over max speed of vehicle
            return newVelocity;
        } else {
            return properties.maxVelocity();
        }
    }

    public int deaccelerate(Vehicle vehicle, int currentLane, int velocity) { //deaccelerate when vehicles in front
        RoadPosition position = vehicle.getPosition();
        Road road = position.road();

        Road.ScanResult scanResult = road.scanCells(currentLane, position.cell(), velocity, false);
        int gap = scanResult.distance();
        if (scanResult.endOfRoadReached()) {
            int remainingDistance = velocity - gap;
            gap += this.getFreeDistanceAfterTurn(
                    road,
                    currentLane,
                    vehicle,
                    remainingDistance
            );
        }

        return gap;
    }

    public int applyRandomizedBrake(int velocity, double probability) {
        Random random = new Random();
        double randomDouble = random.nextDouble();  //generates a double between 0.0 and 1.0

        if((velocity > 1)&&(0<=probability)&&(probability<=1)){
            if(randomDouble <= probability){              //Bernoulli
                velocity--; //velocity gets less by one unit
            }
        }
        return velocity;
    }
}