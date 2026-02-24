public class Map {

    private Node[] nodes;
    private Road[] roads;

    public Map() {
        MockNode node1 = new MockNode();
        MockNode node2 = new MockNode();

        Road road1 = new Road(node2, 100, 2);
        Road road2 = new Road(node1, 100, 2);

        node1.addOutgoingRoad(road1, MockNode.Direction.NORTH);
        node2.addIncomingRoad(road1, MockNode.Direction.NORTH);

        node2.addOutgoingRoad(road2, MockNode.Direction.SOUTH);
        node1.addIncomingRoad(road2, MockNode.Direction.SOUTH);

        this.nodes = new Node[] {node1, node2};
        this.roads = new Road[] {road1, road2};
    }

    public Node[] getNodes() {
        return this.nodes;
    }

    public Road[] getRoads() {
        return this.roads;
    }
    
}