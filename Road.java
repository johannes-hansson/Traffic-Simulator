import java.util.ArrayDeque;

public class Road {

    public record ScanResult(int distance, boolean wasBlocked, boolean endOfRoadReached) {}

    private ArrayDeque<Vehicle> vehicleRegistry; // Registry for all vehicles currently on the road
    private Vehicle[][] lanes; // Cell map used for spacial lookups. First layer is each lane, second is the cells
    private Node endNode; // The node that the road leads into
    private RoadRender render;

    public String name; // Temporary field to distinguish roads

    public Road(Node endNode, int length, int laneCount, RoadRender render, String name) {
        this.vehicleRegistry = new ArrayDeque<>();
        this.lanes = new Vehicle[laneCount][length];
        this.endNode = endNode;
        this.render = render;
        this.name = name;
    }

    public RoadRender getRoadRender() {
        return this.render;
    }

    public Node getEndNode() {
        return this.endNode;
    }

    public int getLength() {
        return this.lanes[0].length;
    };

    public int getLanes() {
        return this.lanes.length;
    };

    // Adds the given vehicle to the vehicle registry and the cell array at the given position
    // Does not check if there is another vehicle at the position or if the given
    // vehicle already exists on the road
    public void enterVehicle(Vehicle vehicle, int lane, int cell) {
        this.vehicleRegistry.add(vehicle);
        this.lanes[lane][cell] = vehicle;
    }

    // Moves the vehicle at the given position to the new position in the cell array
    // Does not check that the given position has a vehicle, or that the new position is empty
    public void moveVehicle(int fromLane, int fromCell, int toLane, int toCell) {
        if (fromLane == toLane && fromCell == toCell) {
            return;
        }
        this.lanes[toLane][toCell] = this.lanes[fromLane][fromCell];
        this.lanes[fromLane][fromCell] = null;
    }

    // Removes the vehicle at the given position
    // Does not remove potential duplicates of the same vehicle
    // If duplicates exists, a duplicate on a different position
    // might be removed instead of the one at the given position
    public void removeVehicleAt(int lane, int cell) {
        Vehicle vehicle = this.lanes[lane][cell];
        if (vehicle == null) {
            System.err.println("Attempted to remove vehicle from an empty cell");
            return;
        }
        this.lanes[lane][cell] = null;
        this.vehicleRegistry.remove(vehicle);
    }

    // Returns true if the given lane and cell has a vehicle in it
    public boolean isOccupied(int lane, int cell) {
        return this.lanes[lane][cell] != null;
    }

    public ScanResult scanCells(int lane, int start, int distance, boolean includeStart) {
        final int roadLength = this.getLength();

        if (start < 0 || start >= roadLength) {
            System.err.println("Invalid start cell given for scan");
            return null;
        }

        if (lane < 0 || lane >= this.getLanes()) {
            System.err.println("Lane provided for scan is out of range");
            return null;
        }

        // Status variables that will be used to construct the scan result
        int distanceTravelled = 0;
        boolean wasBlocked = false;
        boolean endOfRoadReached = false;

        int startingCell = start;
        if (includeStart == false) {
            startingCell += 1;
        }

        for (int currentCell = startingCell; currentCell < startingCell + distance; currentCell++) {

            // Check if the end of the road has been reached
            if (currentCell >= roadLength) {
                endOfRoadReached = true;
                break;
            }

            // Check if the current cell is occupied
            if (this.isOccupied(lane, currentCell)) {
                wasBlocked = true;
                break;
            }

            distanceTravelled++;
        }

        ScanResult result = new ScanResult(distanceTravelled, wasBlocked, endOfRoadReached);
        return result;
    }

    // Returns the first vehicle found on lane from the inclusive range start to end
    // Requires that the provided end point is within range of the road
    public Vehicle _scanCells(int lane, int start, int end) {
        if (start < 0 || start > end || end >= this.getLength()) {
            System.err.println("Invalid range provided for scan");
            return null;
        }

        if (lane < 0 || lane >= this.getLanes()) {
            System.err.println("Lane provided for scan is out of range");
            return null;
        }

        for (int currentCell = start; currentCell <= end; currentCell++) {
            if (this.lanes[lane][currentCell] != null) {
                return this.lanes[lane][currentCell];
            }
        }

        return null;
    }

    // Returns the amount of free cells ahead of start
    public int getGap(int lane, int cell) {
        int gap = 0;
        int start = cell + 1;
        int roadLength = this.getLength();
        while (start + gap < roadLength) {
            if (this.lanes[lane][start + gap] == null) {
                gap++;
            } else {
                break;
            }
        }
        return gap; 
    }
}
