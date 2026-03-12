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

        // zon a
        MockNode ah1 = new MockNode(new double[]{30, 50}, 50, false);
        MockNode ah2 = new MockNode(new double[]{30, 100}, 50, true);
        MockNode ah3 = new MockNode(new double[]{170, 50}, 50, false);
        MockNode ah4 = new MockNode(new double[]{170, 100}, 50, false);
        MockNode ah5 = new MockNode(new double[]{30, 150}, 50, false);
        MockNode ah6 = new MockNode(new double[]{170, 150}, 50, false);
        MockNode ah7 = new MockNode(new double[]{30, 200}, 50, false);
        MockNode ah8 = new MockNode(new double[]{300, 200}, 50, false);
        MockNode ah9 = new MockNode(new double[]{300, 150}, 50, false);
        MockNode ah10 = new MockNode(new double[]{30, 300}, 50, true);
        MockNode ah11 = new MockNode(new double[]{300, 250}, 50, false);
        MockNode ah12 = new MockNode(new double[]{300, 300}, 50, true);
        MockNode ah13 = new MockNode(new double[]{170, 300}, 50, false);
        MockNode ah14 = new MockNode(new double[]{550, 300}, 50, true);
        MockNode ah15 = new MockNode(new double[]{300, 50}, 50, false);
        MockNode ah16 = new MockNode(new double[]{450, 50}, 50, false);
        MockNode ah17 = new MockNode(new double[]{450, 150}, 50, true);
        MockNode ah18 = new MockNode(new double[]{450, 300}, 50, false);

        // zon b
        MockNode bh1 = new MockNode(new double[]{600, 50}, 50, true);
        MockNode bh2 = new MockNode(new double[]{600, 150}, 50, true);
        MockNode bh3 = new MockNode(new double[]{900, 50}, 50, false);
        MockNode bh4 = new MockNode(new double[]{900, 100}, 50, true);
        MockNode bh5 = new MockNode(new double[]{750, 100}, 50, false);
        MockNode bh6 = new MockNode(new double[]{600, 200}, 50, false);
        MockNode bh8 = new MockNode(new double[]{750, 150}, 50, true);
        MockNode bh9 = new MockNode(new double[]{900, 150}, 50, false);
        MockNode bh10 = new MockNode(new double[]{900, 200}, 50, true);
        MockNode bh11 = new MockNode(new double[]{750, 200}, 50, false);
        MockNode bh12 = new MockNode(new double[]{600, 300}, 50, true);
        MockNode bh16 = new MockNode(new double[]{750, 300}, 50, false);
        MockNode bh20 = new MockNode(new double[]{900, 300}, 50, true);
        MockNode bh22 = new MockNode(new double[]{600, 250}, 50, true);
        MockNode bh23 = new MockNode(new double[]{1050, 300}, 50, false);
        MockNode bh24 = new MockNode(new double[]{1050, 200}, 50, true);
        MockNode bh25 = new MockNode(new double[]{1170, 50}, 50, false);
        MockNode bh26 = new MockNode(new double[]{1170, 100}, 50, false);
        MockNode bh27 = new MockNode(new double[]{1170, 150}, 50, true);
        MockNode bh28 = new MockNode(new double[]{1170, 200}, 50, true);
        MockNode bh29 = new MockNode(new double[]{1170, 300}, 50, true);



        // lägg till i nodes lista

        // zon a
        nodes.add(ah1);
        nodes.add(ah2);
        nodes.add(ah3);
        nodes.add(ah4);
        nodes.add(ah5);
        nodes.add(ah6);
        nodes.add(ah7);
        nodes.add(ah8);
        nodes.add(ah9);
        nodes.add(ah10);
        nodes.add(ah11);
        nodes.add(ah12);
        nodes.add(ah13);
        nodes.add(ah14);
        nodes.add(ah15);
        nodes.add(ah16);
        nodes.add(ah17);
        nodes.add(ah18);

        // zon b
        nodes.add(bh1);
        nodes.add(bh2);
        nodes.add(bh3);
        nodes.add(bh4);
        nodes.add(bh5);
        nodes.add(bh6);
        nodes.add(bh8);
        nodes.add(bh9);
        nodes.add(bh10);
        nodes.add(bh11);
        nodes.add(bh12);
        nodes.add(bh16);
        nodes.add(bh20);
        nodes.add(bh22);
        nodes.add(bh23);
        nodes.add(bh24);
        nodes.add(bh25);
        nodes.add(bh26);
        nodes.add(bh27);
        nodes.add(bh28);
        nodes.add(bh29);

        // -----


        // här gör vi traffic lights? och lägger till i infrastructures

        // zon a
       // infrastructures.add(ah1.getTrafficLight());
        infrastructures.add(ah2.getTrafficLight());
        // infrastructures.add(ah3.getTrafficLight());
        // infrastructures.add(ah4.getTrafficLight());
        // infrastructures.add(ah5.getTrafficLight());
        //infrastructures.add(ah6.getTrafficLight());
        //infrastructures.add(ah7.getTrafficLight());
        // infrastructures.add(ah8.getTrafficLight());
        //infrastructures.add(ah9.getTrafficLight());
        infrastructures.add(ah10.getTrafficLight());
        //infrastructures.add(ah11.getTrafficLight());
        infrastructures.add(ah12.getTrafficLight());
        //infrastructures.add(ah13.getTrafficLight());
        infrastructures.add(ah14.getTrafficLight());
        //infrastructures.add(ah15.getTrafficLight());
        //infrastructures.add(ah16.getTrafficLight());
        infrastructures.add(ah17.getTrafficLight());
        //infrastructures.add(ah18.getTrafficLight());

        // zon b
        infrastructures.add(bh1.getTrafficLight());
        infrastructures.add(bh2.getTrafficLight());
        //infrastructures.add(bh3.getTrafficLight());
        infrastructures.add(bh4.getTrafficLight());
        //infrastructures.add(bh5.getTrafficLight());
        //infrastructures.add(bh6.getTrafficLight());
        infrastructures.add(bh8.getTrafficLight());
       // infrastructures.add(bh9.getTrafficLight());
        infrastructures.add(bh10.getTrafficLight());
       // infrastructures.add(bh11.getTrafficLight());
        infrastructures.add(bh12.getTrafficLight());
       // infrastructures.add(bh16.getTrafficLight());
        infrastructures.add(bh20.getTrafficLight());
        infrastructures.add(bh22.getTrafficLight());
       // infrastructures.add(bh23.getTrafficLight());
        infrastructures.add(bh24.getTrafficLight());
        //infrastructures.add(bh25.getTrafficLight());
        //infrastructures.add(bh26.getTrafficLight());
        infrastructures.add(bh27.getTrafficLight());
        infrastructures.add(bh28.getTrafficLight());
        infrastructures.add(bh29.getTrafficLight());

        // gör roads genom funktion

        // zon a
        createRoad(ah1, ah3, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(30,50,0), // start vänster hörn
                new BreakPoint(170,50,100),
        }, "ar13"
        );
        createRoad(ah3, ah4, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(170,50,0 ),
                new BreakPoint(170,100,50),
                }, "ar34"
        );
        createRoad(ah2, ah1, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30,100,0 ),
                new BreakPoint(30,50,50),
                }, "ar12"
        );
        createRoad(ah4, ah2, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(170,100,0),
                new BreakPoint(30,100,140 ),
                }, "ar24"
        );
        createRoad(ah5, ah2, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                        new BreakPoint(30, 150,0),
                        new BreakPoint(30, 100,50 ),
                }, "ar52"
        );
        createRoad(ah4, ah6, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(170, 100,0),
                        new BreakPoint(170, 150,50 ),
                }, "ar46"
        );
        createRoad(ah6, ah5, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                        new BreakPoint(170, 150,0),
                        new BreakPoint(30, 150,100 ),
                }, "ar65"
        );
        createRoad(ah7, ah5, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                        new BreakPoint(30, 200,0),
                        new BreakPoint(30, 150,50),
                }, "ar75"
        );
        createRoad(ah7, ah8, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(30, 200,0),
                        new BreakPoint(300, 200,270),
                }, "ar78"
        );
        createRoad(ah10, ah7, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                        new BreakPoint(30, 300,0),
                        new BreakPoint(30, 200,100),
                }, "ar107"
        );
        createRoad(ah13, ah10, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                        new BreakPoint(170, 300,0),
                        new BreakPoint(30, 300,140),
                }, "ar1310"
        );
        createRoad(ah12, ah13, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                        new BreakPoint(300, 300,0),
                        new BreakPoint(170, 300,30),
                }, "ar1213"
        );
        createRoad(ah11, ah12, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(300, 250,0),
                        new BreakPoint(300, 300,50),
                }, "ar1112"
        );
        createRoad(ah8, ah11, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(300, 200,0),
                        new BreakPoint(300, 250,50),
                }, "ar811"
        );
        createRoad(ah9, ah8, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(300, 150,0),
                        new BreakPoint(300, 200,50),
                }, "ar98"
        );
        createRoad(ah9, ah6, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                        new BreakPoint(300, 150,0),
                        new BreakPoint(170, 150,130),
                }, "ar96"
        );
        createRoad(ah3, ah15, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(170, 50,0),
                        new BreakPoint(300, 50,130),
                }, "ar315"
        );
        createRoad(ah15, ah9, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(300, 50,0),
                        new BreakPoint(300, 150,100),
                }, "ar159"
        );
        createRoad(ah15, ah16, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(300, 50,0),
                        new BreakPoint(450, 50,150),
                }, "ar1516"
        );
        createRoad(ah16, ah17, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(450, 50,0),
                        new BreakPoint(450, 150,100),
                }, "ar1617"
        );
        createRoad(ah17, ah9, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                        new BreakPoint(450, 150,0),
                        new BreakPoint(300, 150,50),
                }, "ar179"
        );
        createRoad(ah18, ah12, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                        new BreakPoint(450, 300,0),
                        new BreakPoint(300, 300,50),
                }, "ar1812"
        );
        createRoad(ah14, ah18, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                        new BreakPoint(550, 300,0),
                        new BreakPoint(450, 300,100),
                }, "ar1418"
        );

        // connecting zones a and b
        createRoad(ah16, bh1, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(450, 50,0),
                        new BreakPoint(600, 50,150),
                }, "abr161"
        );
        createRoad(bh2, ah17, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                        new BreakPoint(600, 150,0),
                        new BreakPoint(450, 150,150),
                }, "bar172"
        );
        createRoad(ah11, bh22, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(300, 250,0),
                        new BreakPoint(600, 250,300),
                }, "abr1122"
        );
        createRoad(bh12, ah14, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                        new BreakPoint(600, 300,0),
                        new BreakPoint(550, 300,50),
                }, "bar1214"
        );



        // zon b
        createRoad(bh1, bh3, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(600, 50,0),
                        new BreakPoint(900, 50,300),
                }, "br13"
        );
        createRoad(bh2, bh1, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                        new BreakPoint(600, 150,0),
                        new BreakPoint(600, 50,100),
                }, "br21"
        );
        createRoad(bh8, bh2, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                        new BreakPoint(750, 150,0),
                        new BreakPoint(600, 150,150),
                }, "br82"
        );
        createRoad(bh5, bh8, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(750, 100,0),
                        new BreakPoint(750, 150,50),
                }, "br58"
        );
        createRoad(bh4, bh5, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                        new BreakPoint(900, 100,0),
                        new BreakPoint(750, 100,150),
                }, "br45"
        );
        createRoad(bh3, bh25, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(900, 50,0),
                        new BreakPoint(1170, 50,270),
                }, "br325"
        );
        createRoad(bh4, bh26, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                        new BreakPoint(900, 100,0),
                        new BreakPoint(1170, 100,270),
                }, "br426"
        );
        createRoad(bh9, bh27, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(900, 150,0),
                        new BreakPoint(1170, 150,270),
                }, "br927"
        );
        createRoad(bh10, bh24, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(900, 200,0),
                        new BreakPoint(1050, 200,150),
                }, "br1024"
        );
        createRoad(bh24, bh28, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(1050, 200,0),
                        new BreakPoint(1170, 200,120),
                }, "br2428"
        );
        createRoad(bh3, bh4, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(900, 50,0),
                        new BreakPoint(900, 100,50),
                }, "br34"
        );
        createRoad(bh25, bh26, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(1170, 50,0),
                        new BreakPoint(1170, 100,50),
                }, "br2526"
        );
        createRoad(bh26, bh27, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(1170, 100,0),
                        new BreakPoint(1170, 150,50),
                }, "br2627"
        );
        createRoad(bh27, bh28, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(1170, 150,0),
                        new BreakPoint(1170, 200,50),
                }, "br2728"
        );
        createRoad(bh4, bh9, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(900, 100,0),
                        new BreakPoint(900, 150,50),
                }, "br49"
        );
        createRoad(bh9, bh10, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(900, 150,0),
                        new BreakPoint(900, 200,50),
                }, "br910"
        );
        createRoad(bh6, bh11, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(600, 200,0),
                        new BreakPoint(750, 200,150),
                }, "br611"
        );
        createRoad(bh6, bh2, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                        new BreakPoint(600, 200,0),
                        new BreakPoint(600, 150,150),
                }, "br62"
        );
        createRoad(bh11, bh8, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                        new BreakPoint(750, 200,0),
                        new BreakPoint(750, 150,50),
                }, "br118"
        );
        createRoad(bh11, bh10, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(750, 200,0),
                        new BreakPoint(900, 200,150),
                }, "br1110"
        );
        createRoad(bh22, bh6, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                        new BreakPoint(600, 250,0),
                        new BreakPoint(600, 200,50),
                }, "br226"
        );
        createRoad(bh12, bh22, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                        new BreakPoint(600, 300,0),
                        new BreakPoint(600, 250,50),
                }, "br1222"
        );
        createRoad(bh12, bh16, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(600, 300,0),
                        new BreakPoint(750, 300,50),
                }, "br1216"
        );
        createRoad(bh16, bh20, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(750, 300,0),
                        new BreakPoint(900, 300,150),
                }, "br1620"
        );
        createRoad(bh10, bh20, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(900, 200,0),
                        new BreakPoint(900, 300,100),
                }, "br1020"
        );
        createRoad(bh23, bh24, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                        new BreakPoint(1050, 300,0),
                        new BreakPoint(1050, 200,100),
                }, "br2324"
        );
        createRoad(bh28, bh29, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(1170, 200,0),
                        new BreakPoint(1170, 300,100),
                }, "br2829"
        );
        createRoad(bh20, bh23, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(900, 300,0),
                        new BreakPoint(1050, 300,150),
                }, "br2023"
        );
        createRoad(bh23, bh29, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(1050, 300,0),
                        new BreakPoint(1170, 300,120),
                }, "br2329"
        );
        createRoad(bh23, bh29, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                        new BreakPoint(1050, 300,0),
                        new BreakPoint(1170, 300,120),
                }, "br2329"
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