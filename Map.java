import java.util.ArrayList;

/** Represents the road network used by the simulation.
 * Owns the collection of Node's (intersections/endpoints) and Road's and
 * is responsible for assembling a connected topology. */
public class Map {

    private ArrayList<Node> nodes;
    private ArrayList<Road> roads;

    public Map() {
        MockNode node1 = new MockNode();
        MockNode node2 = new MockNode();

        RoadRender render1 = new RoadRender(20, new BreakPoint[] {
            new BreakPoint(50, 250, 0),
            new BreakPoint(50, 50, 200),
            new BreakPoint(500, 50, 650),
            new BreakPoint(500, 250, 850)
        });
        RoadRender render2 = new RoadRender(20, new BreakPoint[] {
                new BreakPoint(500, 300, 0),
                new BreakPoint(500, 500, 200),
                new BreakPoint(50, 500, 650),
                new BreakPoint(50, 300, 850)
        });


        Road road1 = new Road(node2, 850, 2, render1, "Road 1");
        Road road2 = new Road(node1, 850, 2, render2, "Road 2");


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