import java.util.ArrayList;

/** Represents the road network used by the simulation.
 * Owns the collection of Node's (intersections/endpoints) and Road's and
 * is responsible for assembling a connected topology. */
public class Map {

    private ArrayList<Node> nodes;
    private ArrayList<Road> roads;

    public Map() {
        MockNode node1 = new MockNode(new double[]{100, 100}, 50);

        RoadRender render1 = new RoadRender(10, new BreakPoint[] {
           /*
            new BreakPoint(0, 0, 0),
            new BreakPoint(50, 0, 50),
            new BreakPoint(50, 50, 100),
            new BreakPoint(100, 50, 150),
            new BreakPoint(100, 0, 200),
            new BreakPoint(200, 0, 300) */

            new BreakPoint(100,100,0), // start vänster hörn
            new BreakPoint(100,250,150),
            new BreakPoint(700,250,750),
            new BreakPoint(700,100,900),
            new BreakPoint(500,100,1100),
            new BreakPoint(500,500,1500),
            new BreakPoint(700,500,1700),
            new BreakPoint(700,350,1850),
            new BreakPoint(100,350,2450),
            new BreakPoint(100,500,2600),
            new BreakPoint(300,500,2800),
            new BreakPoint(300,100,3000),
            new BreakPoint(100,100,3200),


        });
        /* RoadRender render2 = new RoadRender(10, new BreakPoint[] {
            new BreakPoint(0, 100, 0),
            new BreakPoint(99, 100, 99)
        }); */


        Road road1 = new Road(node1, 3200, 1, render1, "väg1");
        road1.setRoadRender(render1);
        /* Road road2 = new Road(node1, 100, 2);
        road2.setRoadRender(render2);*/

        node1.addIncomingRoad(road1, MockNode.Direction.NORTH);
        node1.addOutgoingRoad(road1, MockNode.Direction.SOUTH);

        /*
        node1.addOutgoingRoad(road1, MockNode.Direction.NORTH);
        node2.addIncomingRoad(road1, MockNode.Direction.NORTH);

        node2.addOutgoingRoad(road2, MockNode.Direction.SOUTH);
        node1.addIncomingRoad(road2, MockNode.Direction.SOUTH);
        */

        this.nodes = new ArrayList<>();
        this.roads = new ArrayList<>();

        this.nodes.add(node1);

        this.roads.add(road1);
        //this.roads.add(road2);*/
    }

    public ArrayList<Node> getNodes() {
        return this.nodes;
    }

    public ArrayList<Road> getRoads() {
        return this.roads;
    }
    
}