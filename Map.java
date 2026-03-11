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

        MockNode ch1 = new MockNode(new double[]{30, 400}, 50);
        MockNode ch2 = new MockNode(new double[]{30, 450}, 50);
        MockNode ch3 = new MockNode(new double[]{460, 400}, 50);
        MockNode ch4 = new MockNode(new double[]{460, 450}, 50);
        MockNode ch5 = new MockNode(new double[]{170, 450}, 50);
        MockNode ch6 = new MockNode(new double[]{30, 550}, 50);
        MockNode ch7 = new MockNode(new double[]{170, 550}, 50);
        MockNode ch8 = new MockNode(new double[]{170, 500}, 50);
        MockNode ch9 = new MockNode(new double[]{460, 500}, 50);
        MockNode ch10 = new MockNode(new double[]{30, 600}, 50);
        MockNode ch11 = new MockNode(new double[]{170, 600}, 50);
        MockNode ch12 = new MockNode(new double[]{30, 650}, 50);
        MockNode ch13 = new MockNode(new double[]{30, 700}, 50);
        MockNode ch14 = new MockNode(new double[]{170, 650}, 50);
        MockNode ch15 = new MockNode(new double[]{170, 700}, 50);
        MockNode ch17 = new MockNode(new double[]{300, 650}, 50);
        MockNode ch18 = new MockNode(new double[]{300, 700}, 50);
        MockNode ch19 = new MockNode(new double[]{300, 600}, 50);
        MockNode ch20 = new MockNode(new double[]{460, 600}, 50);
        MockNode ch21 = new MockNode(new double[]{460, 700}, 50);
        MockNode ch22 = new MockNode(new double[]{530, 400}, 50);
        
        


        // lägg till i nodes lista
        nodes.add(ah1);
        nodes.add(ah2);
        nodes.add(ah3);
        nodes.add(ah4);

        nodes.add(ch1);
        nodes.add(ch2);
        nodes.add(ch3);
        nodes.add(ch4);

        nodes.add(ch6);
        nodes.add(ch7);

        nodes.add(ch5);
        nodes.add(ch8);
        nodes.add(ch9);
        nodes.add(ch10);
        nodes.add(ch11);
        nodes.add(ch12);
        nodes.add(ch13);
        nodes.add(ch20);
        nodes.add(ch21);
        nodes.add(ch22);

        // -----

        // här gör vi traffic lights? och lägger till i infrastructures
        infrastructures.add(ah1.getTrafficLight());
        infrastructures.add(ah2.getTrafficLight());
        infrastructures.add(ah3.getTrafficLight());
        infrastructures.add(ah4.getTrafficLight());

        infrastructures.add(ch1.getTrafficLight());
        infrastructures.add(ch2.getTrafficLight());
        infrastructures.add(ch3.getTrafficLight());
        infrastructures.add(ch4.getTrafficLight());

        infrastructures.add(ch5.getTrafficLight());
        infrastructures.add(ch6.getTrafficLight());
        infrastructures.add(ch7.getTrafficLight());

        infrastructures.add(ch8.getTrafficLight());
        infrastructures.add(ch9.getTrafficLight());
        infrastructures.add(ch10.getTrafficLight());
        infrastructures.add(ch11.getTrafficLight());
        infrastructures.add(ch12.getTrafficLight());
        infrastructures.add(ch13.getTrafficLight());
        infrastructures.add(ch14.getTrafficLight());
        infrastructures.add(ch15.getTrafficLight());
        infrastructures.add(ch17.getTrafficLight());

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
        

        // ZONE C START
        createRoad(ch1, ch3, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(30, 400,0),
                new BreakPoint(460,400,430),
                }, "cr13"
        );

        createRoad(ch2, ch1, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30,450,0),
                new BreakPoint(30,400,50),
                }, "cr12"
        );

        createRoad(ch4, ch3, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(460,450,0),
                new BreakPoint(460,400, 50),
                }, "cr34"
        );

        createRoad(ch4, ch5, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(460,450,0),
                new BreakPoint(170, 450,290),
                }, "cr45"
        );

        createRoad(ch5, ch2, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(170, 450,0),
                new BreakPoint(30, 450,140),
                }, "cr25"
        );

        createRoad(ch5, ch8, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(170, 450,0),
                new BreakPoint(170, 500,50),
                }, "cr58"
        );

        createRoad(ch8, ch9, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(170, 500,0),
                new BreakPoint(460, 500,290),
                }, "cr89"
        );

        createRoad(ch9, ch4, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(460, 500,0),
                new BreakPoint(460, 450,50),
                }, "cr49"
        );

        createRoad(ch7, ch6, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(170, 550,0),
                new BreakPoint(30, 550,140),
                }, "cr67"
        );

        createRoad(ch7, ch8, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(170, 500,0),
                new BreakPoint(170, 550,50),
                }, "cr78"
        );

        createRoad(ch6, ch2, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30, 550,0),
                new BreakPoint(30, 450,100),
                }, "cr26"
        );

        createRoad(ch10, ch6, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30, 600,0),
                new BreakPoint(30, 550,50),
                }, "cr106"
        );

        createRoad(ch12, ch10, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30, 650,0),
                new BreakPoint(30, 600,50),
                }, "cr1210"
        );

        createRoad(ch13, ch12, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30, 700,0),
                new BreakPoint(30, 650,50),
                }, "cr1312"
        );

        createRoad(ch14, ch15, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30, 650,0),
                new BreakPoint(30, 700,50),
                }, "cr1415"
        );

        createRoad(ch18, ch17, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(300, 700,0),
                new BreakPoint(300, 650,50),
                }, "cr1415"
        );

        createRoad(ch17, ch19, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(300, 650,0),
                new BreakPoint(300, 600,50),
                }, "cr1719"
        );

        createRoad(ch14, ch17, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(300, 650,0),
                new BreakPoint(170, 650,130),
                }, "cr1417"
        );

        createRoad(ch18, ch15, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(170, 700,0),
                new BreakPoint(300, 700,130),
                }, "cr1815"
        );

        createRoad(ch15, ch13, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(170, 700,0),
                new BreakPoint(30, 700,140),
                }, "cr1513"
        );

        createRoad(ch14,ch15, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(170, 650,0),
                new BreakPoint(170, 700,50),
                }, "cr1415"
        );

        createRoad(ch14,ch12, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(170, 650,0),
                new BreakPoint(30, 650,130),
                }, "cr1412"
        );
        
        createRoad(ch10,ch11, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(30, 600,0),
                new BreakPoint(170, 600,140),
                }, "cr10110"
        );

        createRoad(ch11,ch14, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(170, 600,0),
                new BreakPoint(170, 650,140),
                }, "cr1114"
        );

        createRoad(ch21, ch18, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(450, 700,0),
                new BreakPoint(300, 700,150),
                }, "2118"
        );

        createRoad(ch21, ch20, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(450, 700,0),
                new BreakPoint(450, 600,100),
                }, "2118"
        );


       
         
        



       

       


       
        //ZONE C END
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