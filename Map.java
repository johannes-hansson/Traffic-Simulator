import javax.smartcardio.Card;
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

        /*
        MockNode southNode = new MockNode(new double[] {600, 750}, 10, true);
        MockNode northNode = new MockNode(new double[] {600, 50}, 10, true);

        this.nodes.add(northNode);
        this.nodes.add(southNode);

        createRoad(southNode, northNode, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[] {
                new BreakPoint(600, 745, 0),
                new BreakPoint(600, 55, 500)
        }, "main");

        createRoad(northNode, southNode, CardinalDirection.EAST, CardinalDirection.EAST, new BreakPoint[] {
                new BreakPoint(605, 50, 0),
                new BreakPoint(800, 50, 100),
                new BreakPoint(800, 750, 600),
                new BreakPoint(605, 750, 700)
        }, "right");

        createRoad(northNode, southNode, CardinalDirection.WEST, CardinalDirection.WEST, new BreakPoint[] {
                new BreakPoint(595, 50, 0),
                new BreakPoint(400, 50, 100),
                new BreakPoint(400, 750, 600),
                new BreakPoint(595, 750, 700)
        }, "left");

        for (Node node : nodes) {
            if (node instanceof MockNode mock) {
                TrafficLight trafficLight = mock.getTrafficLight();
                if (trafficLight != null) {
                    infrastructures.add(trafficLight);
                }
            }
        }
        */

        //Zon c
        MockNode ch1 = new MockNode(new double[]{30, 400}, 10, false);
        MockNode ch2 = new MockNode(new double[]{30, 450}, 10, true);
        MockNode ch3 = new MockNode(new double[]{450, 400}, 10, true);
        MockNode ch4 = new MockNode(new double[]{450, 450}, 10, false);
        MockNode ch5 = new MockNode(new double[]{170, 450}, 10, false);
        MockNode ch6 = new MockNode(new double[]{30, 550}, 10, true);
        //MockNode ch7 = new MockNode(new double[]{170, 550}, 10, false);
        MockNode ch8 = new MockNode(new double[]{170, 500}, 10, false);
        MockNode ch9 = new MockNode(new double[]{450, 500}, 10,  true);
        MockNode ch10 = new MockNode(new double[]{30, 600}, 10, false);
        //MockNode ch11 = new MockNode(new double[]{170, 600}, 10, false);
        MockNode ch12 = new MockNode(new double[]{30, 650}, 10,true);
        //MockNode ch13 = new MockNode(new double[]{30, 700}, 10, false);
        MockNode ch14 = new MockNode(new double[]{170, 650}, 10, false);
        MockNode ch15 = new MockNode(new double[]{170, 700}, 10, true);
        MockNode ch17 = new MockNode(new double[]{300, 650}, 10, true);
        MockNode ch18 = new MockNode(new double[]{300, 700}, 10, false);
        //MockNode ch19 = new MockNode(new double[]{300, 600}, 10, false);
        MockNode ch20 = new MockNode(new double[]{450, 600}, 10, true);
        MockNode ch21 = new MockNode(new double[]{450, 700}, 10, true);
        MockNode ch22 = new MockNode(new double[]{550, 400}, 10, false);
        MockNode ch23 = new MockNode(new double[]{170, 400}, 10, false);
        
        //zon D
        MockNode dh1 = new MockNode(new double[]{600, 400}, 10, true);
        MockNode dh2 = new MockNode(new double[]{750, 400}, 10, false);
        MockNode dh3 = new MockNode(new double[]{600, 550}, 10, false);
        MockNode dh4 = new MockNode(new double[]{750, 550}, 10, true);
        MockNode dh6 = new MockNode(new double[]{750, 450}, 10, false);
        MockNode dh7 = new MockNode(new double[]{750, 500}, 10, true);
        MockNode dh8 = new MockNode(new double[]{900, 450}, 10, true);
        MockNode dh9 = new MockNode(new double[]{900, 400}, 10, false);
        MockNode dh10 = new MockNode(new double[]{1170, 400}, 10, true);
        MockNode dh11 = new MockNode(new double[]{1170, 450}, 10, false);
        MockNode dh12 = new MockNode(new double[]{900, 500}, 10, false);
        //MockNode dh13 = new MockNode(new double[]{1050, 500}, 10, false);
        MockNode dh14 = new MockNode(new double[]{1170, 550}, 10, true);
        MockNode dh15 = new MockNode(new double[]{1050, 550}, 10, true);
        MockNode dh16 = new MockNode(new double[]{900, 550}, 10, false);
        //MockNode dh17 = new MockNode(new double[]{900, 600}, 10, false);
        MockNode dh18 = new MockNode(new double[]{750, 600}, 10, true);
        MockNode dh19 = new MockNode(new double[]{750, 650}, 10, true);
        MockNode dh20 = new MockNode(new double[]{750, 700}, 10, true);
        MockNode dh21 = new MockNode(new double[]{600, 600}, 10, true);
        MockNode dh22 = new MockNode(new double[]{1050, 650}, 10, true);
        //MockNode dh23 = new MockNode(new double[]{1170, 700}, 10, false);
        MockNode dh24 = new MockNode(new double[]{1170, 650}, 10, false);
        MockNode dh25 = new MockNode(new double[]{600, 500}, 10, true);
        //MockNode dh26 = new MockNode(new double[]{600, 650}, 10, false);


        // lägg till i nodes lista

        // zon a
        //MockNode ah1 = new MockNode(new double[]{30, 50}, 10, false);
        MockNode ah2 = new MockNode(new double[]{30, 100}, 10, false);
        MockNode ah3 = new MockNode(new double[]{170, 50}, 10, true);
        MockNode ah4 = new MockNode(new double[]{170, 100}, 10, true);
        MockNode ah5 = new MockNode(new double[]{30, 150}, 10, true);
        MockNode ah6 = new MockNode(new double[]{170, 150}, 10, true);
        MockNode ah7 = new MockNode(new double[]{30, 200}, 10, false);
        MockNode ah8 = new MockNode(new double[]{300, 200}, 10, true);
        MockNode ah9 = new MockNode(new double[]{300, 150}, 10, true);
        MockNode ah10 = new MockNode(new double[]{30, 300}, 10, false);
        MockNode ah11 = new MockNode(new double[]{300, 250}, 10, true);
        MockNode ah12 = new MockNode(new double[]{300, 300}, 10, true);
        MockNode ah13 = new MockNode(new double[]{170, 300}, 10, true);
        MockNode ah14 = new MockNode(new double[]{550, 300}, 10, true);
        MockNode ah15 = new MockNode(new double[]{300, 50}, 10, false);
        MockNode ah16 = new MockNode(new double[]{450, 50}, 10, false);
        MockNode ah17 = new MockNode(new double[]{450, 150}, 10, true);
        MockNode ah18 = new MockNode(new double[]{450, 300}, 10, false);

        // zon b
        MockNode bh1 = new MockNode(new double[]{600, 50}, 10, true);
        MockNode bh2 = new MockNode(new double[]{600, 150}, 10, true);
        MockNode bh3 = new MockNode(new double[]{900, 50}, 10, false);
        MockNode bh4 = new MockNode(new double[]{900, 100}, 10, true);
        //MockNode bh5 = new MockNode(new double[]{750, 100}, 10, false);
        MockNode bh6 = new MockNode(new double[]{600, 200}, 10, false);
        MockNode bh8 = new MockNode(new double[]{750, 150}, 10, true);
        MockNode bh9 = new MockNode(new double[]{900, 150}, 10, false);
        MockNode bh10 = new MockNode(new double[]{900, 200}, 10, true);
        MockNode bh11 = new MockNode(new double[]{750, 200}, 10, false);
        MockNode bh12 = new MockNode(new double[]{600, 300}, 10, false);
        MockNode bh16 = new MockNode(new double[]{750, 300}, 10, true);
        MockNode bh20 = new MockNode(new double[]{900, 300}, 10, true);
        MockNode bh22 = new MockNode(new double[]{600, 250}, 10, true);
        MockNode bh23 = new MockNode(new double[]{1050, 300}, 10, false);
        MockNode bh24 = new MockNode(new double[]{1050, 200}, 10, true);
        //MockNode bh25 = new MockNode(new double[]{1170, 50}, 10, false);
        MockNode bh26 = new MockNode(new double[]{1170, 100}, 10, false);
        MockNode bh27 = new MockNode(new double[]{1170, 150}, 10, true);
        MockNode bh28 = new MockNode(new double[]{1170, 200}, 10, true);
        MockNode bh29 = new MockNode(new double[]{1170, 300}, 10, true);



        // lägg till i nodes lista

        // zon a
        //nodes.add(ah1);
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
        //nodes.add(bh5);
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
        //nodes.add(bh25);
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
        //nodes.add(ch7);
        nodes.add(ch5);
        nodes.add(ch8);
        nodes.add(ch9);
        nodes.add(ch10);
        //nodes.add(ch11);
        nodes.add(ch12);
        //nodes.add(ch13);
        nodes.add(ch14);
        nodes.add(ch15);
        nodes.add(ch17);
        nodes.add(ch18);
        //nodes.add(ch19);
        nodes.add(ch20);
        nodes.add(ch21);
        nodes.add(ch22);
        nodes.add(ch23);
    

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
        //nodes.add(dh13);
        nodes.add(dh14);
        nodes.add(dh15);
        nodes.add(dh16);
        //nodes.add(dh17);
        nodes.add(dh18);
        nodes.add(dh19);
        nodes.add(dh20);
        nodes.add(dh21);
        nodes.add(dh22);
        //nodes.add(dh23);
        nodes.add(dh24);
        nodes.add(dh25);
        //nodes.add(dh26);
        
        for (Node node : nodes) {
            if (node instanceof MockNode mock) {
                TrafficLight trafficLight = mock.getTrafficLight();
                if (trafficLight != null) {
                    infrastructures.add(trafficLight);
                }
            }
        }
        
        // -----
       

        // gör roads genom funktion


        // ZONE C START
        createRoad(ch1, ch23, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(35, 400, 0),
                new BreakPoint(165, 400, 140),
        }, "cr13");

        createRoad(ch23, ch3, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(175, 400, 0),
                new BreakPoint(445, 400, 280),
        }, "cr13");

        createRoad(ch2, ch1, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30, 445, 0),
                new BreakPoint(30, 405, 50),
        }, "cr12");

        createRoad(ch4, ch3, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(450, 445, 0),
                new BreakPoint(450, 405, 50),
        }, "cr34");

        createRoad(ch4, ch5, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(445, 450, 0),
                new BreakPoint(175, 450, 280),
        }, "cr45");

        createRoad(ch5, ch2, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(165, 450, 0),
                new BreakPoint(35, 450, 140),
        }, "cr25");

        createRoad(ch5, ch8, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(170, 455, 0),
                new BreakPoint(170, 495, 50),
        }, "cr58");

        createRoad(ch8, ch9, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(175, 500, 0),
                new BreakPoint(445, 500, 280),
        }, "cr89");

        createRoad(ch9, ch4, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(450, 495, 0),
                new BreakPoint(450, 455, 50),
        }, "cr49");

        createRoad(ch8, ch6, CardinalDirection.SOUTH, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(170, 505, 0),
                new BreakPoint(170, 550, 50),
                new BreakPoint(35, 550, 190),
        }, "cr78");

        createRoad(ch6, ch2, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30, 545, 0),
                new BreakPoint(30, 455, 100),
        }, "cr26");

        createRoad(ch10, ch6, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30, 595, 0),
                new BreakPoint(30, 555, 50),
        }, "cr106");

        createRoad(ch12, ch10, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30, 645, 0),
                new BreakPoint(30, 605, 50),
        }, "cr1210");

        createRoad(ch15, ch12, CardinalDirection.WEST, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(165, 700, 0),
                new BreakPoint(30, 700, 140),
                new BreakPoint(30, 655, 190),
        }, "cr1513");


        createRoad(ch18, ch17, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(300, 695, 0),
                new BreakPoint(300, 655, 50),
        }, "cr1817");

        createRoad(ch17, ch20, CardinalDirection.NORTH, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(300, 645, 0),
                new BreakPoint(300, 600, 50),
                new BreakPoint(445, 600, 200),
        }, "cr1719");

        createRoad(ch14, ch17, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(175, 650, 0),
                new BreakPoint(295, 650, 130),
        }, "cr1417");

        createRoad(ch18, ch15, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(295, 700, 0),
                new BreakPoint(175, 700, 130),
        }, "cr1815");

        createRoad(ch14, ch15, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(170, 655, 0),
                new BreakPoint(170, 695, 50),
        }, "cr1415");

        createRoad(ch14, ch12, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(165, 650, 0),
                new BreakPoint(35, 650, 130),
        }, "cr1412");

        createRoad(ch10, ch14, CardinalDirection.WEST, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(35, 600, 0),
                new BreakPoint(170, 600, 140),
                new BreakPoint(170, 645, 280),
        }, "cr10110");

        createRoad(ch21, ch18, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(445, 700, 0),
                new BreakPoint(305, 700, 150),
        }, "cr2118");

        createRoad(ch20, ch21, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(450, 605, 0),
                new BreakPoint(450, 695, 100),
        }, "cr2120");

        createRoad(ch3, ch22, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(455, 400, 0),
                new BreakPoint(545, 400, 100),
        }, "cr322");

        createRoad(ch20, ch9, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(450, 595, 0),
                new BreakPoint(450, 505, 100),
        }, "cr209");
        // ZONE C END

        // ZONE D START
        createRoad(dh1, dh2, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(605, 400, 0),
                new BreakPoint(745, 400, 150),
        }, "dr12");

        createRoad(dh2, dh6, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(750, 405, 0),
                new BreakPoint(750, 445, 50),
        }, "dr26");

        createRoad(dh6, dh7, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(750, 455, 0),
                new BreakPoint(750, 495, 50),
        }, "dr67");

        createRoad(dh7, dh4, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(750, 505, 0),
                new BreakPoint(750, 545, 50),
        }, "dr74");

        createRoad(dh3, dh4, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(605, 550, 0),
                new BreakPoint(745, 550, 150),
        }, "dr34");

        createRoad(dh3, dh25, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(600, 545, 0),
                new BreakPoint(600, 505, 50),
        }, "dr325");

        createRoad(dh25, dh1, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(600, 495, 0),
                new BreakPoint(600, 405, 100),
        }, "dr251");

        createRoad(dh19, dh21, CardinalDirection.WEST, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(745, 650, 0),
                new BreakPoint(600, 650, 150),
                new BreakPoint(600, 605, 200),
        }, "dr1926");

        createRoad(dh6, dh8, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(755, 450, 0),
                new BreakPoint(895, 450, 150),
        }, "dr68");

        createRoad(dh9, dh10, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(905, 400, 0),
                new BreakPoint(1165, 400, 270),
        }, "dr910");

        createRoad(dh9, dh8, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(900, 405, 0),
                new BreakPoint(900, 445, 50),
        }, "dr98");

        createRoad(dh10, dh11, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(1170, 405, 0),
                new BreakPoint(1170, 445, 50),
        }, "dr1011");

        createRoad(dh11, dh8, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(1165, 450, 0),
                new BreakPoint(905, 450, 270),
        }, "dr118");

        createRoad(dh12, dh7, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(895, 500, 0),
                new BreakPoint(755, 500, 270),
        }, "dr127");

        createRoad(dh12, dh15, CardinalDirection.EAST, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(905, 500, 0),
                new BreakPoint(1050, 500, 150),
                new BreakPoint(1050, 545, 200),
        }, "dr1213");

        createRoad(dh8, dh12, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(900, 455, 0),
                new BreakPoint(900, 495, 50),
        }, "dr812");

        createRoad(dh15, dh14, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(1055, 550, 0),
                new BreakPoint(1165, 550, 120),
        }, "dr1514");

        createRoad(dh16, dh15, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(905, 550, 0),
                new BreakPoint(1045, 550, 120),
        }, "dr1615");

        createRoad(dh11, dh14, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(1170, 455, 0),
                new BreakPoint(1170, 545, 100),
        }, "dr1114");

        createRoad(dh16, dh18, CardinalDirection.SOUTH, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(900, 555, 0),
                new BreakPoint(900, 600, 50),
                new BreakPoint(755, 600, 320),
        }, "dr1617");

        createRoad(dh4, dh18, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(750, 555, 0),
                new BreakPoint(750, 595, 50),
        }, "dr1418");

        createRoad(dh12, dh16, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(900, 505, 0),
                new BreakPoint(900, 545, 50),
        }, "dr1216");

        createRoad(dh22, dh19, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(1045, 650, 0),
                new BreakPoint(755, 650, 300),
        }, "dr2219");

        createRoad(dh24, dh20, CardinalDirection.SOUTH, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(1170, 645, 0),
                new BreakPoint(1170, 700, 50),
                new BreakPoint(755, 700, 470),
        }, "dr2423");

        createRoad(dh24, dh22, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(1165, 650, 0),
                new BreakPoint(1055, 650, 120),
        }, "dr2422");

        createRoad(dh15, dh22, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(1050, 555, 0),
                new BreakPoint(1050, 645, 100),
        }, "dr1522");

        createRoad(dh18, dh19, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(750, 605, 0),
                new BreakPoint(750, 645, 50),
        }, "dr1819");

        createRoad(dh19, dh20, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(750, 655, 0),
                new BreakPoint(750, 695, 50),
        }, "dr1920");

        createRoad(dh18, dh21, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(745, 600, 0),
                new BreakPoint(605, 600, 150),
        }, "dr1821");

        createRoad(dh21, dh3, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(600, 595, 0),
                new BreakPoint(600, 555, 50),
        }, "dr321");

        createRoad(dh14, dh24, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(1170, 555, 0),
                new BreakPoint(1170, 645, 100),
        }, "dr1424");
        // ZONE D END


        // CONNECTING ZONES A AND B
        createRoad(ah16, bh1, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(455, 50, 0),
                new BreakPoint(595, 50, 150),
        }, "abr161");

        createRoad(bh2, ah17, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(595, 150, 0),
                new BreakPoint(455, 150, 150),
        }, "bar172");

        createRoad(ah11, bh22, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(305, 250, 0),
                new BreakPoint(595, 250, 300),
        }, "abr1122");

        createRoad(bh12, ah14, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(595, 300, 0),
                new BreakPoint(555, 300, 50),
        }, "bar1214");

        // BETWEEN ZONE B AND C
        createRoad(dh20, ch21, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(745, 700, 0),
                new BreakPoint(455, 700, 300),
        }, "dr2021");

        createRoad(dh21, ch20, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(595, 600, 0),
                new BreakPoint(455, 600, 250),
        }, "dr2021");

        createRoad(ch22, dh1, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(555, 400, 0),
                new BreakPoint(595, 400, 50),
        }, "cdr221");

        createRoad(ch9, dh25, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(455, 500, 0),
                new BreakPoint(595, 500, 150),
        }, "cdr259");

// ZONE A

        createRoad(ah3, ah4, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(170, 55, 0),
                new BreakPoint(170, 95, 50),
        }, "ar34");

        createRoad(ah3, ah15, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(175, 50, 0),
                new BreakPoint(295, 50, 130),
        }, "ar315");

        createRoad(ah2, ah3, CardinalDirection.NORTH, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(30, 95, 0),
                new BreakPoint(30, 50, 50),
                new BreakPoint(165, 50, 150),
        }, "ar23");

        createRoad(ah2, ah4, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(35, 100, 0),
                new BreakPoint(165, 100, 140),
        }, "ar24");

        createRoad(ah5, ah2, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30, 145, 0),
                new BreakPoint(30, 105, 50),
        }, "ar52");

        createRoad(ah4, ah6, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(170, 105, 0),
                new BreakPoint(170, 145, 50),
        }, "ar46");

        createRoad(ah6, ah5, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(165, 150, 0),
                new BreakPoint(35, 150, 100),
        }, "ar65");

        createRoad(ah7, ah5, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30, 195, 0),
                new BreakPoint(30, 155, 50),
        }, "ar75");

        createRoad(ah7, ah8, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(35, 200, 0),
                new BreakPoint(295, 200, 270),
        }, "ar78");

        createRoad(ah10, ah7, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30, 295, 0),
                new BreakPoint(30, 205, 100),
        }, "ar107");

        createRoad(ah10, ah13, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(35, 300, 0),
                new BreakPoint(165, 300, 140),
        }, "ar1310");

        createRoad(ah13, ah12, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(175, 300, 0),
                new BreakPoint(295, 300, 130),
        }, "ar1213");

        createRoad(ah12, ah11, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(300, 295, 0),
                new BreakPoint(300, 255, 50),
        }, "ar1112");

        createRoad(ah8, ah11, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(300, 205, 0),
                new BreakPoint(300, 245, 50),
        }, "ar811");

        createRoad(ah9, ah8, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(300, 155, 0),
                new BreakPoint(300, 195, 50),
        }, "ar98");

        createRoad(ah9, ah6, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(295, 150, 0),
                new BreakPoint(175, 150, 130),
        }, "ar96");

        createRoad(ah15, ah9, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(300, 55, 0),
                new BreakPoint(300, 145, 100),
        }, "ar159");

        createRoad(ah15, ah16, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(305, 50, 0),
                new BreakPoint(445, 50, 150),
        }, "ar1516");

        createRoad(ah16, ah17, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(450, 55, 0),
                new BreakPoint(450, 145, 100),
        }, "ar1617");

        createRoad(ah17, ah9, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(445, 150, 0),
                new BreakPoint(305, 150, 150),
        }, "ar179");

        createRoad(ah18, ah12, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(445, 300, 0),
                new BreakPoint(305, 300, 150),
        }, "ar1812");

        createRoad(ah14, ah18, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(545, 300, 0),
                new BreakPoint(455, 300, 100),
        }, "ar1418");

// ZONE B
        createRoad(bh1, bh3, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(605, 50, 0),
                new BreakPoint(895, 50, 300),
        }, "br13");

        createRoad(bh2, bh1, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(600, 145, 0),
                new BreakPoint(600, 55, 100),
        }, "br21");

        createRoad(bh8, bh2, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(745, 150, 0),
                new BreakPoint(605, 150, 150),
        }, "br82");

        createRoad(bh4, bh8, CardinalDirection.WEST, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(895, 100, 0),
                new BreakPoint(750, 100, 150),
                new BreakPoint(750, 145, 200),
        }, "br45");

        createRoad(bh3, bh26, CardinalDirection.EAST, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(905, 50, 0),
                new BreakPoint(1170, 50, 270),
                new BreakPoint(1170, 95, 320),
        }, "br325");

        createRoad(bh26, bh4, CardinalDirection.WEST, CardinalDirection.EAST, new BreakPoint[]{
                new BreakPoint(1165, 100, 0),
                new BreakPoint(905, 100, 270),
        }, "br426");

        createRoad(bh9, bh27, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(905, 150, 0),
                new BreakPoint(1165, 150, 270),
        }, "br927");

        createRoad(bh10, bh24, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(905, 200, 0),
                new BreakPoint(1045, 200, 150),
        }, "br1024");

        createRoad(bh24, bh28, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(1055, 200, 0),
                new BreakPoint(1165, 200, 120),
        }, "br2428");

        createRoad(bh3, bh4, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(900, 55, 0),
                new BreakPoint(900, 95, 50),
        }, "br34");

        createRoad(bh26, bh27, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(1170, 105, 0),
                new BreakPoint(1170, 145, 50),
        }, "br2627");

        createRoad(bh27, bh28, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(1170, 155, 0),
                new BreakPoint(1170, 195, 50),
        }, "br2728");

        createRoad(bh4, bh9, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(900, 105, 0),
                new BreakPoint(900, 145, 50),
        }, "br49");

        createRoad(bh9, bh10, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(900, 155, 0),
                new BreakPoint(900, 195, 50),
        }, "br910");

        createRoad(bh6, bh11, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(605, 200, 0),
                new BreakPoint(745, 200, 150),
        }, "br611");

        createRoad(bh6, bh2, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(600, 195, 0),
                new BreakPoint(600, 155, 150),
        }, "br62");

        createRoad(bh11, bh8, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(750, 195, 0),
                new BreakPoint(750, 155, 50),
        }, "br118");

        createRoad(bh11, bh10, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(755, 200, 0),
                new BreakPoint(895, 200, 150),
        }, "br1110");

        createRoad(bh22, bh6, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(600, 245, 0),
                new BreakPoint(600, 205, 50),
        }, "br226");

        createRoad(bh12, bh22, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(600, 295, 0),
                new BreakPoint(600, 255, 50),
        }, "br1222");

        createRoad(bh12, bh16, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(605, 300, 0),
                new BreakPoint(745, 300, 150),
        }, "br1216");

        createRoad(bh16, bh20, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(755, 300, 0),
                new BreakPoint(895, 300, 150),
        }, "br1620");

        createRoad(bh10, bh20, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(900, 205, 0),
                new BreakPoint(900, 295, 100),
        }, "br1020");

        createRoad(bh23, bh24, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(1050, 295, 0),
                new BreakPoint(1050, 205, 100),
        }, "br2324");

        createRoad(bh28, bh29, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(1170, 205, 0),
                new BreakPoint(1170, 295, 100),
        }, "br2829");

        createRoad(bh20, bh23, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(905, 300, 0),
                new BreakPoint(1045, 300, 150),
        }, "br2023");

        createRoad(bh23, bh29, CardinalDirection.EAST, CardinalDirection.WEST, new BreakPoint[]{
                new BreakPoint(1055, 300, 0),
                new BreakPoint(1165, 300, 120),
        }, "br2329");

// FINAL INTER-ZONE
        createRoad(bh29, dh10, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(1170, 305, 0),
                new BreakPoint(1170, 395, 100),
        }, "bdr2910");

        createRoad(bh20, dh9, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(900, 305, 0),
                new BreakPoint(900, 395, 100),
        }, "bdr209");

        createRoad(dh2, bh16, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(750, 395, 0),
                new BreakPoint(750, 305, 100),
        }, "bdr216");

        createRoad(dh1, bh12, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(600, 395, 0),
                new BreakPoint(600, 305, 100),
        }, "dbr112");

        createRoad(ch22, ah14, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(550, 395, 0),
                new BreakPoint(550, 305, 100),
        }, "ca2214");

        createRoad(ah18, ch3, CardinalDirection.SOUTH, CardinalDirection.NORTH, new BreakPoint[]{
                new BreakPoint(450, 305, 0),
                new BreakPoint(450, 395, 100),
        }, "ca2214");

        createRoad(ch1, ah10, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(30, 395, 0),
                new BreakPoint(30, 305, 100),
        }, "ca110");

        createRoad(ch23, ah13, CardinalDirection.NORTH, CardinalDirection.SOUTH, new BreakPoint[]{
                new BreakPoint(170, 395, 0),
                new BreakPoint(170, 305, 100),
        }, "cra2313");
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