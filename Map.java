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

        //Zon c
        MockNode ch1 = new MockNode(new double[]{30, 400}, 50);
        MockNode ch2 = new MockNode(new double[]{30, 450}, 50);
        MockNode ch3 = new MockNode(new double[]{450, 400}, 50);
        MockNode ch4 = new MockNode(new double[]{450, 450}, 50);
        MockNode ch5 = new MockNode(new double[]{170, 450}, 50);
        MockNode ch6 = new MockNode(new double[]{30, 550}, 50);
        MockNode ch7 = new MockNode(new double[]{170, 550}, 50);
        MockNode ch8 = new MockNode(new double[]{170, 500}, 50);
        MockNode ch9 = new MockNode(new double[]{560, 500}, 50);
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
        
        //zon D
        MockNode dh1 = new MockNode(new double[]{600, 400}, 50);
        MockNode dh2 = new MockNode(new double[]{750, 400}, 50);
        MockNode dh3 = new MockNode(new double[]{600, 550}, 50);
        MockNode dh4 = new MockNode(new double[]{750, 550}, 50);
        MockNode dh6 = new MockNode(new double[]{750, 450}, 50);
        MockNode dh7 = new MockNode(new double[]{750, 500}, 50);
        MockNode dh8 = new MockNode(new double[]{900, 450}, 50);
        MockNode dh9 = new MockNode(new double[]{900, 400}, 50);
        MockNode dh10 = new MockNode(new double[]{1170, 400}, 50);
        MockNode dh11 = new MockNode(new double[]{1170, 450}, 50);
        MockNode dh12 = new MockNode(new double[]{900, 500}, 50);
        MockNode dh13 = new MockNode(new double[]{1050, 500}, 50);
        MockNode dh14 = new MockNode(new double[]{1170, 550}, 50);
        MockNode dh15 = new MockNode(new double[]{1050, 550}, 50);  
        MockNode dh16 = new MockNode(new double[]{900, 550}, 50);
        MockNode dh17 = new MockNode(new double[]{900, 600}, 50);  
        MockNode dh18 = new MockNode(new double[]{750, 600}, 50);
        MockNode dh19 = new MockNode(new double[]{750, 650}, 50);
        MockNode dh20 = new MockNode(new double[]{750, 700}, 50);
        MockNode dh21 = new MockNode(new double[]{600, 600}, 50);
        MockNode dh22 = new MockNode(new double[]{1050, 650}, 50); 
        MockNode dh23 = new MockNode(new double[]{1170, 700}, 50);
        MockNode dh24 = new MockNode(new double[]{1170, 650}, 50);
        MockNode dh25 = new MockNode(new double[]{600, 500}, 50);      


        // lägg till i nodes lista
        nodes.add(ah1);
        nodes.add(ah2);
        nodes.add(ah3);
        nodes.add(ah4);

        //zon C
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

        //zon D
        nodes.add(dh1);
        nodes.add(dh2);
        nodes.add(dh3);
        nodes.add(dh4);
        nodes.add(dh6);
        nodes.add(dh7);
        nodes.add(dh8);
        nodes.add(dh9);
        nodes.add(dh10);
        nodes.add(dh11);
        nodes.add(dh12);
        nodes.add(dh13);
        nodes.add(dh14);
        nodes.add(dh15);
        nodes.add(dh16);
        nodes.add(dh17);
        nodes.add(dh18);
        nodes.add(dh19);
        nodes.add(dh20);
        nodes.add(dh21);
        nodes.add(dh22);
        nodes.add(dh23);
        nodes.add(dh24);
        nodes.add(dh25);
        

        
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
        infrastructures.add(ch18.getTrafficLight());
        infrastructures.add(ch19.getTrafficLight());
        infrastructures.add(ch20.getTrafficLight());
        infrastructures.add(ch21.getTrafficLight());
        infrastructures.add(ch22.getTrafficLight());
        
        infrastructures.add(dh1.getTrafficLight());
        infrastructures.add(dh2.getTrafficLight());
        infrastructures.add(dh3.getTrafficLight());
        infrastructures.add(dh4.getTrafficLight());
        infrastructures.add(dh7.getTrafficLight());
        infrastructures.add(dh8.getTrafficLight());
        infrastructures.add(dh9.getTrafficLight());
        infrastructures.add(dh10.getTrafficLight());
        infrastructures.add(dh11.getTrafficLight());
        infrastructures.add(dh12.getTrafficLight());
        infrastructures.add(dh13.getTrafficLight());
        infrastructures.add(dh14.getTrafficLight());
        infrastructures.add(dh15.getTrafficLight());
        infrastructures.add(dh16.getTrafficLight());
        infrastructures.add(dh17.getTrafficLight());
        infrastructures.add(dh18.getTrafficLight());
        infrastructures.add(dh19.getTrafficLight());
        infrastructures.add(dh20.getTrafficLight());
        infrastructures.add(dh21.getTrafficLight());
        infrastructures.add(dh22.getTrafficLight());
        infrastructures.add(dh23.getTrafficLight());
        infrastructures.add(dh24.getTrafficLight());
        infrastructures.add(dh25.getTrafficLight());

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
                new BreakPoint(450,400,420),
                }, "cr13"
        );

        createRoad(ch2, ch1, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30,450,0),
                new BreakPoint(30,400,50),
                }, "cr12"
        );

        createRoad(ch4, ch3, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(450,450,0),
                new BreakPoint(450,400, 50),
                }, "cr34"
        );

        createRoad(ch4, ch5, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(450,450,0),
                new BreakPoint(170, 450,280),
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
                new BreakPoint(450, 500,280),
                }, "cr89"
        );

        createRoad(ch9, ch4, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(450, 500,0),
                new BreakPoint(450, 450,50),
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
                }, "cr2118"
        );

        createRoad(ch21, ch20, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(450, 700,0),
                new BreakPoint(450, 600,100),
                }, "cr2120"
        );

        createRoad(ch19, ch20, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(300, 600,0),
                new BreakPoint(450, 600,150),
                }, "cr2120"
        );

        createRoad(ch3, ch22, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(450, 400,0),
                new BreakPoint(540, 400,100),
                }, "cr322"
        );

        createRoad(ch20, ch9, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(450, 600,0),
                new BreakPoint(450, 500,100),
                }, "cr209"
        );
       
        //ZONE C END

        //ZONE D START
        createRoad(dh1, dh2, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(600, 400,0),
                new BreakPoint(750, 400,150),
                }, "dr12"
        );

        createRoad(dh2, dh6, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(750, 400,0),
                new BreakPoint(750, 450,50),
                }, "dr26"
        );

        createRoad(dh6, dh7, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(750, 450,0),
                new BreakPoint(750, 500,50),
                }, "dr67"
        );
         createRoad(dh7, dh4, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(750, 500,0),
                new BreakPoint(750, 550,50),
                }, "dr74"
        );
        createRoad(dh3, dh4, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(600, 550,0),
                new BreakPoint(750, 550,150),
                }, "dr34"
        );
        createRoad(dh3, dh1, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(600, 550,0),
                new BreakPoint(600, 400,150),
                }, "dr31"
        );

        createRoad(dh6, dh8, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(750, 450, 0),
                new BreakPoint(900, 450,150),
                }, "dr68"
        );

        createRoad(dh9, dh10, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(900, 400, 0),
                new BreakPoint(1170, 400,270),
                }, "dr910"
        );
        createRoad(dh9, dh8, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(900, 400, 0),
                new BreakPoint(900, 450,50),
                }, "dr98"
        );
        createRoad(dh10, dh11, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(1170, 400, 0),
                new BreakPoint(1170, 450,50),
                }, "dr1011"
        );

        createRoad(dh11, dh8, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(1170, 450, 0),
                new BreakPoint(900, 450,270),
                }, "dr118"
        );

        createRoad(dh12, dh7, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(900, 500, 0),
                new BreakPoint(750, 500,270),
                }, "dr127"
        );

        createRoad(dh12, dh13, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(900, 500, 0),
                new BreakPoint(1050, 500,150),
                }, "dr1213"
        );

        createRoad(dh8, dh12, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(900, 450, 0),
                new BreakPoint(900, 500,50),
                }, "dr812"
        );

        createRoad(dh15, dh14, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(1050, 550, 0),
                new BreakPoint(1170, 550,120),
                }, "dr1514"
        );

        createRoad(dh16, dh15, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(900, 550, 0),
                new BreakPoint(1050, 550,120),
                }, "dr1615"
        );
        createRoad(dh13, dh15, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(1050, 500, 0),
                new BreakPoint(1050, 550,50),
                }, "dr1315"
        );

        createRoad(dh11, dh14, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(1170, 450, 0),
                new BreakPoint(1170, 550,100),
                }, "dr1114"
        );
        createRoad(dh16, dh17, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(900, 550, 0),
                new BreakPoint(900, 600,50),
                }, "dr1617"
        );
        createRoad(dh4, dh18, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(750, 550, 0),
                new BreakPoint(750, 600,50),
                }, "dr1418"
        );

        createRoad(dh12, dh16, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(900, 500, 0),
                new BreakPoint(900, 550,50),
                }, "dr1216"
        );

        createRoad(dh17, dh18, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(900, 600, 0),
                new BreakPoint(750, 600,270),
                }, "dr1718"
        );

        createRoad(dh22, dh19, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(1050, 650, 0),
                new BreakPoint(750, 650,300),
                }, "dr2219"
        );

        createRoad(dh23, dh20, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(1170, 700, 0),
                new BreakPoint(750, 700,420),
                }, "dr2320"
        );

        createRoad(dh24, dh22, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(1170, 650, 0),
                new BreakPoint(1050, 650,120),
                }, "dr2422"
        );
        createRoad(dh15, dh22, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(1050, 550, 0),
                new BreakPoint(1050, 650,100),
                }, "dr1522"
        );

        createRoad(dh18, dh19, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(750, 600, 0),
                new BreakPoint(750, 650,50),
                }, "dr1819"
        );
        createRoad(dh19, dh20, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(750, 650, 0),
                new BreakPoint(750, 700,50),
                }, "dr1920"
        );
        createRoad(dh18, dh21, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(750, 600, 0),
                new BreakPoint(600, 600,150),
                }, "dr1821"
        );
        createRoad(dh21, dh3, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(600, 600, 0),
                new BreakPoint(600, 550,50),
                }, "dr321"
        );
        createRoad(dh14, dh24, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(1170, 550, 0),
                new BreakPoint(1170, 650,100),
                }, "dr1424"
        );
        createRoad(dh24, dh23, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(1170, 650, 0),
                new BreakPoint(1170, 700,50),
                }, "dr2423"
        );


        //BETWEEN ZONE B AND C

        createRoad(dh2, ch21, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(750, 700, 0),
                new BreakPoint(450, 700,300),
                }, "dr221"
        );

        createRoad(ch22, dh1, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(550, 400,0),
                new BreakPoint(600, 400,50),
                }, "cdr221"
        );
        createRoad(dh25, ch9, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(600, 500,0),
                new BreakPoint(450, 500,150),
                }, "cdr259"
        );
        createRoad(dh21, ch20, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(600, 600, 0),
                new BreakPoint(450, 600,150),
                }, "cdr2021"
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