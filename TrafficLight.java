import javafx.scene.shape.Circle;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class TrafficLight implements Infrastructure {

    public class TrafficLightConnection {
        private Road road;
        private Circle light;

        public TrafficLightConnection(Road road) {
            this.road = road;
        }

        public Road getRoad() {
            return this.road;
        }

        public Circle getLight() {
            return this.light;
        }

        public void setLight(Circle circle) {
            this.light = circle;
        }
    }

    // Attributes
    private final int trafficCheckDistance = 40; // Number of cells that are checked for incoming traffic

    // Transition values
    private int minGreenTime = 20;
    private int maxGreenTime = 200;

    // State attributes
    public int activeGreen;
    private int currentGreenTime;

    // Properties
    private TrafficLightConnection[] connections;
    private Circle[] lights;
    private int numberOfRoads;

    public TrafficLight(int numberOfRoads) {
        this.numberOfRoads = numberOfRoads;
        this.connections = new TrafficLightConnection[numberOfRoads];
        this.lights = new Circle[numberOfRoads];
        this.activeGreen = 0;
        this.currentGreenTime = 0;
    }

    public void addRoad(Road road, int index) {
        if (index >= this.numberOfRoads) {
            System.err.println("Out of bounds index given when adding road to traffic light");
            return;
        }

        this.connections[index] = new TrafficLightConnection(road);
    }

    public ArrayList<TrafficLightConnection> getConnections() {
        ArrayList<TrafficLightConnection> connections = new ArrayList<>();
        for (int i=0; i<this.numberOfRoads; i++) {
            if (this.connections[i] != null) {
                connections.add(this.connections[i]);
            }
        }
        return connections;
    }

    private boolean hasIncomingTraffic(Road road) {
        int roadLength = road.getLength();
        int scanStart = Math.max(roadLength - this.trafficCheckDistance, 0);
        boolean includeStartInScan = false;
        boolean hasTraffic = false;

        for (int lane = 0; lane < road.getLanes(); lane++) {
            Road.ScanResult scan = road.scanCells(0, scanStart, roadLength, includeStartInScan);
            if (!scan.endOfRoadReached()) {
                hasTraffic = true;
                break;
            }
        }

        return hasTraffic;
    }

    private void transition() {
        // Iterate over all road indexes until a road with incoming traffic is found
        // If no road with incoming traffic is found, choose the road that comes after
        // the current active green road
        int startIndex = this.activeGreen + 1;
        // -1 indicates that the value has not been assigned
        int nextRoad = -1;
        int nextBusyRoad = -1;
        for (int currentIndex = startIndex; currentIndex < startIndex + this.numberOfRoads; currentIndex++) {
            int wrappedIndex = currentIndex % this.numberOfRoads;
            TrafficLightConnection connection = this.connections[wrappedIndex];
            if (connection == null) {
                continue;
            }

            Road road = connection.getRoad();
            if (road == null) {
                continue;
            }

            if (this.hasIncomingTraffic(road)) {
                nextBusyRoad = wrappedIndex;
                break;
            }

            if (nextRoad == -1) {
                nextRoad = wrappedIndex;
            }
        }

        int nextGreen = this.activeGreen;
        if (nextBusyRoad != -1) {
            nextGreen = nextBusyRoad;
        } else if (nextRoad != -1) {
            nextGreen = nextRoad;
        }

        this.activeGreen = nextGreen;
        this.currentGreenTime = 0;
    }

    public void update() {
        this.currentGreenTime += 1;

        if (this.currentGreenTime < this.minGreenTime) {
            return;
        }

        TrafficLightConnection greenConnection = this.connections[this.activeGreen];
        boolean currentRoadHasTraffic =
                greenConnection != null
                        && greenConnection.getRoad() != null
                        && this.hasIncomingTraffic(greenConnection.getRoad());
        if (!currentRoadHasTraffic || this.currentGreenTime > this.maxGreenTime) {
            this.transition();
        }
    }

    public boolean hasGreen(Road road) {
        TrafficLightConnection connection = this.connections[this.activeGreen];
        return (connection != null && connection.getRoad() == road);
    }
}
