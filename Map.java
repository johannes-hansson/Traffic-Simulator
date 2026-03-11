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
        MockNode ah1 = new MockNode(new double[]{30, 100}, 50);
        MockNode ah2 = new MockNode(new double[]{30, 150}, 50);

        // lägg till i nodes lista
        nodes.add(ah1);
        nodes.add(ah2);

        // -----

        // här gör vi traffic lights? och lägger till i infrastructures
        //infrastructures.add(node1.getTrafficLight());

        // ------


        // gör roadrenders -> riktningarna
        RoadRender rar13 = new RoadRender(10, new BreakPoint[] {
            new BreakPoint(30,100,0), // start vänster hörn
            new BreakPoint(170,100,140),
        });
        RoadRender rar12 = new RoadRender(10, new BreakPoint[] {
        new BreakPoint(30,150,0 ), 
        new BreakPoint(30,100,50),
    });


        // gör vägarna
        Road ar13 = new Road(ah1, 140, 1, rar13, "ah1");
        Road ar12 = new Road(ah1, 140, 1, rar13, "ah1");

        // lägg till vägarna i listan roads
        roads.add(ar13);
        roads.add(ar12);
        
        // lägg till rikningen till vägen
        ar13.setRoadRender(rar13);
        ar12.setRoadRender(rar12);


        // koppla roads i intersection (mocknode)
        ah1.addOutgoingRoad(ar13, CardinalDirection.EAST);
       
        ah1.addIncomingRoad(ar12, CardinalDirection.SOUTH);

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