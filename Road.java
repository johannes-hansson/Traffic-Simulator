public class Road {

    private Vehicle[][] lanes;
    private Node endNode;

    public Road(Node endNode, int length, int laneCount) {
        this.lanes = new Vehicle[laneCount][length];
        this.endNode = endNode;
    }

    // Returns the first vehicle found on lane from the inclusive range start to end
    // Requires that the provided end point is within range of the road
    public Vehicle scanCells(int lane, int start, int end) {
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
    public int getGap(int lane, int start) {
        int gap = 0;
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

    public Node getEndNode() {
        return this.endNode;
    }

    public int getLength() {
        return this.lanes[0].length;
    };

    public int getLanes() {
        return this.lanes.length;
    };
}
