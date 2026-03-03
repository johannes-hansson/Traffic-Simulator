import java.util.ArrayList;

public class Map {

    private ArrayList<Node> nodes;
    private ArrayList<Road> roads;

    public Map() {
        MockNode node1 = new MockNode();
        MockNode node2 = new MockNode();

        RoadRender render1 = new RoadRender(10, new BreakPoint[] {
            new BreakPoint(0, 0, 0),
            new BreakPoint(50, 0, 50),
            new BreakPoint(50, 50, 100),
            new BreakPoint(100, 50, 150),
            new BreakPoint(100, 0, 200),
            new BreakPoint(200, 0, 300)
        });
        RoadRender render2 = new RoadRender(10, new BreakPoint[] {
            new BreakPoint(0, 100, 0),
            new BreakPoint(99, 100, 99)
        });

        Road road1 = new Road(node2, 300, 2, render1, "Road 1");
        Road road2 = new Road(node1, 100, 2, render2, "Road 2");

        node1.addOutgoingRoad(road1, MockNode.Direction.NORTH);
        node2.addIncomingRoad(road1, MockNode.Direction.NORTH);

        node2.addOutgoingRoad(road2, MockNode.Direction.SOUTH);
        node1.addIncomingRoad(road2, MockNode.Direction.SOUTH);

        this.nodes = new ArrayList<>();
        this.roads = new ArrayList<>();

        this.nodes.add(node1);
        this.nodes.add(node2);

        this.roads.add(road1);
        this.roads.add(road2);
    }

    public ArrayList<Node> getNodes() {
        return this.nodes;
    }

    public ArrayList<Road> getRoads() {
        return this.roads;
    }
    
}