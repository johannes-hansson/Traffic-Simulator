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
        MockNode ch1 = new MockNode(new double[]{30, 50}, 50);

        // lägg till i nodes lista
        nodes.add(ch1);

        // -----

        // här gör vi traffic lights? och lägger till i infrastructures
        //infrastructures.add(node1.getTrafficLight());

        // ------


        // gör roadrenders -> riktningarna

        RoadRender rcr12 = new RoadRender(10, new BreakPoint[]{
            new BreakPoint(30, 550, 0),
            new BreakPoint(300, 550, 280),
        });


        // gör vägarna
        Road cr12 = new Road(ch1, 280, 1, rcr12, "cr1");

        // lägg till vägarna i listan roads
       
        roads.add(cr12);

        // lägg till rikningen till vägen
        cr12.setRoadRender(rcr12);


        // koppla roads i intersection (mocknode)
        ch1.addOutgoingRoad(cr12, CardinalDirection.SOUTH);
       
        //ch1.addIncomingRoad(cr12, CardinalDirection.SOUTH);

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