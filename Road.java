public class Road {

    private int laneCount;
    private int length;
    private Node endNode;

    public Road(Node endNode, int length, int laneCount) {
        this.endNode = endNode;
        this.length = length;
        this.laneCount = laneCount;
    }

    public Node getEndNode() {
        return this.endNode;
    }

    public int getLength() {
        return this.length;
    };

    public int getLanes() {
        return this.laneCount;
    };
}
