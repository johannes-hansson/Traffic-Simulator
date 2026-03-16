import static org.junit.Assert.*;    //imports JUnits assertion methods
import org.junit.Test;     //imports the @Test anotations

import org.junit.Before;   //import for before and after annotations
import org.junit.After;
import java.util.ArrayList;

public class Testing {
    
    private Vehicle vehicle1;
    private Vehicle vehicle2;
    private Vehicle vehicle3;
    private ArrayList<Vehicle> vehicles;
    private VehicleProperties properties;   //maxVelocity, acceleration, size, VehicleColor color
    private RoadPosition pos1;   //road cell lane
    private RoadPosition pos2;
    private RoadPosition pos3;
    private Road road; 
    private Road road2; 
    private Road endroad; 
    private MockNode roadcorner;
    private VehicleBehaviour beh;
    private VehicleMovement move;
    private Simulation sim; 
    private PropertiesRegistry propertiesRegistry;
    private TrafficLight trafficlight;

    @Before //each test
   public void setUp(){
        //create new objects
        sim = new Simulation();
        beh = new VehicleBehaviour();
        move = new VehicleMovement();
        vehicles = new ArrayList<>();
        propertiesRegistry = new PropertiesRegistry();

        //road objects
        trafficlight = new TrafficLight(3);

        //adding roads and corner
        roadcorner = new MockNode(new double[]{100, 100}, 10, true);
        road = new Road(roadcorner, 20, 1, null, "TestRoad");
        road2 = new Road(roadcorner, 30, 1, null, "TestRoad 2");
        roadcorner.addIncomingRoad(road, CardinalDirection.WEST);
        roadcorner.addIncomingRoad(road2, CardinalDirection.EAST);
        
        endroad = new Road(null, 30, 1, null, "The road which both road 1 and road 2 leads to");
        roadcorner.addOutgoingRoad(endroad, CardinalDirection.NORTH);

        //creations of cars    
        properties = propertiesRegistry.getVehicleProperties("car");

        //all on same road
        pos1 = new RoadPosition(road, 0, 1);
        pos2 = new RoadPosition(road, 0, 5);
        pos3 = new RoadPosition(road, 0, 4);

        vehicle1 = new Vehicle(properties, pos1, 5);
        vehicle2 = new Vehicle(properties, pos2, 3);
        vehicle3 = new Vehicle(properties, pos3, 10);

        //adding to their own info
        vehicle1.setPosition(pos1);
        vehicle2.setPosition(pos2);
        vehicle3.setPosition(pos3);

        //adding to full vehicle list 
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
    }

    @After
    public void destroy(){
        vehicles.clear();
    }

    
    @Test 
    public void testMoveVehiclePosition(){
        int cellposition1 = vehicle1.getPosition().cell();
        int cellposition2 = vehicle2.getPosition().cell();

        int currentSpeed1 = vehicle1.getVelocity();
        int currentSpeed2 = vehicle2.getVelocity();

        //check for updates of all vehicles get right position
        move.process(vehicles);
        assertEquals("vehicle1 move success", vehicle1.getPosition().cell(), cellposition1 + currentSpeed1);
        assertEquals("vehicle2 move success",vehicle2.getPosition().cell(), cellposition2 + currentSpeed2);
    }

    @Test
    public void testBehaviorMovement(){  //check change of speed

        int Speed1 = vehicle1.getVelocity();
        int Speed2 = vehicle2.getVelocity();
        int Speed3 = vehicle3.getVelocity();

        //check that behavior prohibits vehicle collisions
        beh.process(vehicles);

        ////vehicle 3 should not collide or run through vehicle 2 but have slowed down
        int NewSpeed1 = vehicle1.getVelocity();
        int NewSpeed2 = vehicle2.getVelocity();
        int NewSpeed3 = vehicle3.getVelocity();


        assertTrue("No cars close enough in front to hinder to go same speed", Speed1 == NewSpeed1 || Speed1 == NewSpeed1--);       
        //have same speed or 1 less unit speed 

        assertTrue("No cars in front of this vehicle", Speed2 == NewSpeed2 || Speed2 == NewSpeed2--);     
        //have same speed or 1 less unit speed 

        //have a different slower speed (vehicle 2 is in front)
        assertNotEquals(Speed3, NewSpeed3); 
        assertTrue("vehicle have succesfully slowed down", Speed3 > NewSpeed3);       
        
        //non negative velocities
        assertTrue(Speed1 > 0);
        assertTrue(Speed2 > 0);
        assertTrue(Speed3 > 0);

        assertTrue(NewSpeed1 > 0);
        assertTrue(NewSpeed2 > 0);
        assertTrue(NewSpeed3 > 0);
    }

      @Test
    public void testRandomisation(){
        //test random decrease of one time unit
        boolean decreasedVelocity = false;
        boolean sameVelocity = false;

        for(int i=1; i<100; i++){
            Vehicle vehicleX = new Vehicle(properties, pos1, 5);
            int prev_velocity = vehicleX.getVelocity();
            int newVelocity = beh.randomisation(vehicleX, 0.5);

            if(newVelocity == prev_velocity--){
                decreasedVelocity = true;
            }
            else if(newVelocity == prev_velocity){
                sameVelocity = true;
            }
            else{
                fail("Invalid velocity change" + newVelocity);
            }
            if(decreasedVelocity == true && sameVelocity == true){
                break;
            }
        }
        assertTrue("Decrease happened", decreasedVelocity);
        assertTrue("Same velocity", sameVelocity);
    }

    @Test
    public void testAccelerate(){
        int prev_velocity = vehicle1.getVelocity();
        int newVelocity = beh.accelerate(vehicle1);
        assertEquals("Acceleration function success", prev_velocity++, newVelocity);
    }

    @Test
    public void testDeaccelerate(){ 
        int prev_velocity = vehicle1.getVelocity();
        int newVelocity = beh.deaccelerate(vehicle1);
        assertTrue("Deaccelerate function success", prev_velocity >= newVelocity);
    }


    @Test
    public void testStatistics(){
        
    }

    @Test
    public void testScanCells(){
        
        //adding vehicles to the road itself
        road.enterVehicle(vehicle1, 0, pos1.cell());
        road.enterVehicle(vehicle2, 0, pos2.cell());
        road.enterVehicle(vehicle3, 0, pos3.cell());

        //Check no vehicles on empty road
        Road.ScanResult isRoadEmpty = endroad.scanCells(0, 0 , 29, false);
        assertNotEquals("Returns null, error", isRoadEmpty, null);
        assertFalse("Empty road is not occupied", isRoadEmpty.wasBlocked());

        //traffic on road
        Road.ScanResult isRoadBlocked = road.scanCells(0, 2 , 19, false);
        assertNotEquals("Returns null, error", isRoadBlocked, null);
        assertTrue("Road should be blocked by vehicles", isRoadBlocked.wasBlocked());
    }
    
    @Test
    public void testTrafficLightInitialState(){
        trafficlight.addRoad(road, 0);  //has traffic
        trafficlight.addRoad(road2, 1); //has no traffic

        trafficlight.update();
        assertTrue("Road1 should have green initially", trafficlight.hasGreen(road));
        assertFalse("Road2 should have red initially", trafficlight.hasGreen(road2));  
    }

    @Test
    public void testTrafficLightSwitch(){
        

        //add vehicle to the road that has red
        pos1 = new RoadPosition(road2, 0, 5);
        pos2 = new RoadPosition(road2, 0, 20);

        road2.enterVehicle(vehicle1, 0, pos1.cell());
        road2.enterVehicle(vehicle2, 0, pos2.cell());

        //update until min green has been reached
        for(int i = 0; i < 25; i++){
            trafficlight.update();
        }
     
        assertFalse("Road1 should be red", trafficlight.hasGreen(road));
        assertTrue("Road2 should be green", trafficlight.hasGreen(road2)); 
    }

    @Test
    public void testSimulationButtonFunctionality(){        //Not yet fixed
        SimulationStatistics stats = new SimulationStatistics();
        
        sim.addUpdateListener(s -> System.out.println("tick = " + s.getTick()));
        sim.addUpdateListener(stats);

        sim.addUpdateListener(s -> {
            var latest = stats.getLatest();
            if (latest != null && latest.tick() % 5 == 0) { //printing statistics each 5 ticks
                System.out.println(latest);
            }
        });

        sim.addUpdateListener(s -> {
            for (Vehicle v : s.getVehicles()) {
                System.out.println(
                        v.getProperties().color() +
                                " cell=" + v.getPosition().cell() +
                                " vel=" + v.getVelocity()
                );
            }
        });

        /*sim.start();

        Thread.sleep(350);

        sim.pause();
        int pausedAt = sim.getTick();
        System.out.println("Paused at tick: " + pausedAt);

        Thread.sleep(400);
        System.out.println("Still paused tick: " + sim.getTick());

        sim.resume();
        Thread.sleep(300);

        sim.stop();

        System.out.println("Stopped at tick: " + sim.getTick());*/
    }

}
