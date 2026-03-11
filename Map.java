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
        MockNode ah3 = new MockNode(new double[]{170, 100}, 50);
        MockNode ah4 = new MockNode(new double[]{170, 150}, 50);

        // lägg till i nodes lista
        nodes.add(ah1);
        nodes.add(ah2);
        nodes.add(ah3);
        nodes.add(ah4);

        // -----

        // här gör vi traffic lights? och lägger till i infrastructures
        infrastructures.add(ah1.getTrafficLight());
        infrastructures.add(ah2.getTrafficLight());
        infrastructures.add(ah3.getTrafficLight());
        infrastructures.add(ah4.getTrafficLight());


        // ------

        // gör roads genom funktion
        createRoad(ah1, ah3, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(30,100,0), // start vänster hörn
                new BreakPoint(170,100,140),
        }, "ar13"
        );
        createRoad(ah3, ah4, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(170,100,0 ),
                new BreakPoint(170,150,50),
                }, "ar34"
        );
        createRoad(ah2, ah1, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30,150,0 ),
                new BreakPoint(30,100,50),
                }, "ar12"
        );
        createRoad(ah4, ah2, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(170,150,0),
                new BreakPoint(30,150,140 ),
                }, "ar24"
        );


    }

    private Road createRoad(
            MockNode from,
            MockNode to,
            CardinalDirection outDir,
            CardinalDirection inDir,
            BreakPoint[] points,
            String name
    ) {

        RoadRender render = new RoadRender(10, points);

        int length = points[points.length - 1].cell();

        Road road = new Road(to, length, 1, render, name);

        from.addOutgoingRoad(road, outDir); // utgående
        to.addIncomingRoad(road, inDir); // ingående

        roads.add(road); // lägg till väg

        return road;
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