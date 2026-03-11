import java.util.ArrayList;

/** Represents the road network used by the simulation.
 * Owns the collection of Node's (intersections/endpoints) and Road's and
 * is responsible for assembling a connected topology. */
public class Map {

    private ArrayList<Node> nodes;
    private ArrayList<Road> roads;
    private ArrayList<Infrastructure> infrastructures;

    public Map() {

        // skapa listor
        nodes = new ArrayList<>();
        roads = new ArrayList<>();
        infrastructures = new ArrayList<>();


        // lägg till intersections (hörn)
        MockNode node1 = new MockNode(new double[]{100, 100}, 50);

        // lägg till i nodes lista
        nodes.add(node1);

        // -----

        // här gör vi traffic lights? och lägger till i infrastructures
        infrastructures.add(node1.getTrafficLight());

        // ------


        // gör roadrenders -> riktningarna
        RoadRender render1 = new RoadRender(10, new BreakPoint[] {
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


        // gör vägarna
        Road road1 = new Road(node1, 3200, 1, render1, "väg1");

        // lägg till vägarna i listan roads
        roads.add(road1);

        // lägg till rikningen till vägen
        road1.setRoadRender(render1);



        // koppla roads i intersection (mocknode)
        node1.addIncomingRoad(road1, CardinalDirection.NORTH);
        node1.addOutgoingRoad(road1, CardinalDirection.SOUTH);


    }

    public ArrayList<Node> getNodes() {
        return this.nodes;
    }

    public ArrayList<Road> getRoads() {
        return this.roads;
    }

    public ArrayList<Infrastructure> getInfrastructures() {
        return this.infrastructures;
    }
}