public class TrafficLight implements Infrastructure {

    // Attributes
    private final int trafficCheckDistance = 20; // Number of cells that are checked for incoming traffic

    // Transition values
    private int minGreenTime = 5;
    private int maxGreenTime = 50;

    // State attributes
    private int activeGreen;
    private int currentGreenTime;

    // Properties
    private Road[] inRoads;
    private int numberOfRoads;

    public TrafficLight(int numberOfRoads) {
        this.numberOfRoads = numberOfRoads;
        this.inRoads = new Road[numberOfRoads];
        this.activeGreen = 0;
        this.currentGreenTime = 0;
    }

    public void addRoad(Road road, int index) {
        if (index >= this.numberOfRoads) {
            System.err.println("Out of bounds index given when adding road to traffic light");
            return;
        }

        this.inRoads[index] = road;
    }

    private boolean hasIncomingTraffic(Road road) {
        int roadLength = road.getLength();
        int scanStart = Math.max(roadLength - this.trafficCheckDistance, 0);
        boolean includeStartInScan = true;
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
            Road road = this.inRoads[wrappedIndex];
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

        Road greenRoad = this.inRoads[this.activeGreen];
        boolean currentRoadHasTraffic = greenRoad != null && this.hasIncomingTraffic(greenRoad);
        if (!currentRoadHasTraffic || this.currentGreenTime > this.maxGreenTime) {
            this.transition();
        }
    }

    public boolean hasGreen(Road road) {
        return this.inRoads[this.activeGreen] == road;
    }

    // Hjälpmetoder för test/debug
    public int getActiveGreenIndex() {
        return activeGreen;
    }

    public int getCurrentGreenTime() {
        return currentGreenTime;
    }
}
