public class Road {

    private int laneCount;
    private int length;
    private Node endNode;
    private RoadRender render;

    public Road(Node endNode, int length, int laneCount, RoadRender render) {
        this.endNode = endNode;
        this.length = length;
        this.laneCount = laneCount;
        this.render = render;
    }

    public RoadRender getRoadRender() {
        return this.render;
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
