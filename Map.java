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
    
        //Zon c
        MockNode ch1 = new MockNode(new double[]{30, 400}, 50, true);
        MockNode ch2 = new MockNode(new double[]{30, 450}, 50, true);
        MockNode ch3 = new MockNode(new double[]{450, 400}, 50, true);
        MockNode ch4 = new MockNode(new double[]{450, 450}, 50, false);
        MockNode ch5 = new MockNode(new double[]{170, 450}, 50, false);
        MockNode ch6 = new MockNode(new double[]{30, 550}, 50, true);
        MockNode ch7 = new MockNode(new double[]{170, 550}, 50, false);
        MockNode ch8 = new MockNode(new double[]{170, 500}, 50, false);
        MockNode ch9 = new MockNode(new double[]{560, 500}, 50,  true);
        MockNode ch10 = new MockNode(new double[]{30, 600}, 50, false);
        MockNode ch11 = new MockNode(new double[]{170, 600}, 50, false);
        MockNode ch12 = new MockNode(new double[]{30, 650}, 50,false);
        MockNode ch13 = new MockNode(new double[]{30, 700}, 50, false);
        MockNode ch14 = new MockNode(new double[]{170, 650}, 50, false);
        MockNode ch15 = new MockNode(new double[]{170, 700}, 50, true);
        MockNode ch17 = new MockNode(new double[]{300, 650}, 50, true);
        MockNode ch18 = new MockNode(new double[]{300, 700}, 50, false);
        MockNode ch19 = new MockNode(new double[]{300, 600}, 50, false);
        MockNode ch20 = new MockNode(new double[]{460, 600}, 50, true);
        MockNode ch21 = new MockNode(new double[]{460, 700}, 50, true);
        MockNode ch22 = new MockNode(new double[]{530, 400}, 50, false);
        
        //zon D
        MockNode dh1 = new MockNode(new double[]{600, 400}, 50, true);
        MockNode dh2 = new MockNode(new double[]{750, 400}, 50, true);
        MockNode dh3 = new MockNode(new double[]{600, 550}, 50, false);
        MockNode dh4 = new MockNode(new double[]{750, 550}, 50, true);
        MockNode dh6 = new MockNode(new double[]{750, 450}, 50, false);
        MockNode dh7 = new MockNode(new double[]{750, 500}, 50, true);
        MockNode dh8 = new MockNode(new double[]{900, 450}, 50, true);
        MockNode dh9 = new MockNode(new double[]{900, 400}, 50, false);
        MockNode dh10 = new MockNode(new double[]{1170, 400}, 50, true);
        MockNode dh11 = new MockNode(new double[]{1170, 450}, 50, false);
        MockNode dh12 = new MockNode(new double[]{900, 500}, 50, false);
        MockNode dh13 = new MockNode(new double[]{1050, 500}, 50, false);
        MockNode dh14 = new MockNode(new double[]{1170, 550}, 50, true);
        MockNode dh15 = new MockNode(new double[]{1050, 550}, 50, true);  
        MockNode dh16 = new MockNode(new double[]{900, 550}, 50, false);
        MockNode dh17 = new MockNode(new double[]{900, 600}, 50, false);  
        MockNode dh18 = new MockNode(new double[]{750, 600}, 50, true);
        MockNode dh19 = new MockNode(new double[]{750, 650}, 50, false);
        MockNode dh20 = new MockNode(new double[]{750, 700}, 50, true);
        MockNode dh21 = new MockNode(new double[]{600, 600}, 50, false);
        MockNode dh22 = new MockNode(new double[]{1050, 650}, 50, true); 
        MockNode dh23 = new MockNode(new double[]{1170, 700}, 50, false);
        MockNode dh24 = new MockNode(new double[]{1170, 650}, 50, false);
        MockNode dh25 = new MockNode(new double[]{600, 500}, 50, false);      


        // lägg till i nodes lista

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

        /*
        for (Node node : nodes) {
            if (node instanceof MockNode mock) {
                TrafficLight trafficLight = mock.getTrafficLight();
                if (trafficLight != null) {
                    infrastructures.add(trafficLight);
                }
            }
        }
        */
        
        // -----


        // här gör vi traffic lights? och lägger till i infrastructures
       
        infrastructures.add(ch1.getTrafficLight());
        infrastructures.add(ch2.getTrafficLight());
        infrastructures.add(ch3.getTrafficLight());
        //infrastructures.add(ch4.getTrafficLight());
        //infrastructures.add(ch5.getTrafficLight());
        infrastructures.add(ch6.getTrafficLight());
        //infrastructures.add(ch7.getTrafficLight());
        //infrastructures.add(ch8.getTrafficLight());
        infrastructures.add(ch9.getTrafficLight());
        //infrastructures.add(ch10.getTrafficLight());
        //infrastructures.add(ch11.getTrafficLight());
        //infrastructures.add(ch12.getTrafficLight());
        //infrastructures.add(ch13.getTrafficLight());
        //infrastructures.add(ch14.getTrafficLight());
        infrastructures.add(ch15.getTrafficLight());
        infrastructures.add(ch17.getTrafficLight());
        //infrastructures.add(ch18.getTrafficLight());
        //infrastructures.add(ch19.getTrafficLight());
        infrastructures.add(ch20.getTrafficLight());
        infrastructures.add(ch21.getTrafficLight());
        //infrastructures.add(ch22.getTrafficLight());
        
        infrastructures.add(dh1.getTrafficLight());
        infrastructures.add(dh2.getTrafficLight());
        //infrastructures.add(dh3.getTrafficLight());
        infrastructures.add(dh4.getTrafficLight());
        //infrastructures.add(dh6.getTrafficLight());
        infrastructures.add(dh7.getTrafficLight());
        infrastructures.add(dh8.getTrafficLight());
        //infrastructures.add(dh9.getTrafficLight());
        infrastructures.add(dh10.getTrafficLight());
        //infrastructures.add(dh11.getTrafficLight());
        //infrastructures.add(dh12.getTrafficLight());
        //infrastructures.add(dh13.getTrafficLight());
        infrastructures.add(dh14.getTrafficLight());
        infrastructures.add(dh15.getTrafficLight());
        //infrastructures.add(dh16.getTrafficLight());
        //infrastructures.add(dh17.getTrafficLight());
        infrastructures.add(dh18.getTrafficLight());
        //infrastructures.add(dh19.getTrafficLight());
        infrastructures.add(dh20.getTrafficLight());
        //infrastructures.add(dh21.getTrafficLight());
        infrastructures.add(dh22.getTrafficLight());
        //infrastructures.add(dh23.getTrafficLight());
        //infrastructures.add(dh24.getTrafficLight());
        //infrastructures.add(dh25.getTrafficLight());

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
                new BreakPoint(300, 700,0),
                new BreakPoint(170, 700,130),
                }, "cr1815"
        );

        createRoad(ch15, ch13, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(170, 700,0),
                new BreakPoint(30, 700,140),
                }, "cr1513"
        );

        createRoad(ch14,ch15, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
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

        createRoad(ch20, ch21, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(450, 600,0),
                new BreakPoint(450, 700,100),
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

        createRoad(dh6, dh8, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
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

        createRoad(dh20, ch21, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(750, 700, 0),
                new BreakPoint(450, 700,300),
                }, "dr2021"
        );
        createRoad(dh21, ch20, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(600, 700, 0),
                new BreakPoint(450, 700,250),
                }, "dr2021"
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

        //Between zone B and zone C
        createRoad(bh29, dh10, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(1170, 300,0),
                        new BreakPoint(1170, 400,100),
                }, "bdr2910"
        );
        createRoad(bh20, dh9, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                        new BreakPoint(900, 300,0),
                        new BreakPoint(900, 400,100),
                }, "bdr209"
        );
        createRoad(dh2, bh16, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                        new BreakPoint(750, 400,0),
                        new BreakPoint(750, 300,100),
                }, "bdr216"
        );
        createRoad(dh1, bh12, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                        new BreakPoint(600, 400,0),
                        new BreakPoint(600, 300,100),
                }, "dbr112"
        );

        //Between zone A and zone C
        createRoad(ch22, ah14, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                        new BreakPoint(550, 400,0),
                        new BreakPoint(550, 300,100),
                }, "ca2214"
        );
        createRoad(ch1, ah10, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                        new BreakPoint(30, 400,0),
                        new BreakPoint(30, 300,100),
                }, "ca110"
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
