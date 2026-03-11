public class FelixTestClass {

    public static void main(String[] args) throws InterruptedException {

        MockNode node = new MockNode(new double[]{0, 0}, 50);

        Road inNorth = new Road(node, 100, 1, null, "inNorth");
        Road inEast  = new Road(node, 100, 1, null, "inEast");
        Road outSouth = new Road(node, 100, 1, null, "outSouth");
        Road outWest  = new Road(node, 100, 1, null, "outWest");

        node.addIncomingRoad(inNorth, CardinalDirection.NORTH);
        node.addIncomingRoad(inEast, CardinalDirection.EAST);
        node.addOutgoingRoad(outSouth, CardinalDirection.SOUTH);
        node.addOutgoingRoad(outWest, CardinalDirection.WEST);

        // Lägg en bil nära slutet av inEast så att det finns incoming traffic där
        RoadPosition pos = new RoadPosition(inEast, 0, 95);
        VehicleProperties props = new VehicleProperties(5, 1, 1);
        Vehicle vehicle = new Vehicle(props, pos, 0);
        inEast.enterVehicle(vehicle, 0, 95);

        System.out.println("Initial open roads: " + node.getOpenRoads().size());
        System.out.println("Initial closed roads: " + node.getClosedRoads().size());

        for (int i = 1; i <= 10; i++) {
            node.getTrafficLight().update();

            System.out.println("Tick " + i);
            System.out.println("Open roads:");
            for (Road road : node.getOpenRoads()) {
                System.out.println("  " + road.name);
            }

            System.out.println("Closed roads:");
            for (Road road : node.getClosedRoads()) {
                System.out.println("  " + road.name);
            }

            System.out.println("Can inNorth turn? " + node.requestTurn(inNorth, outSouth));
            System.out.println("Can inEast turn? " + node.requestTurn(inEast, outSouth));
            System.out.println();
        }

       /* // Build a ready-to-run demo simulation (map + behaviour + movement + 2 cars + stats + debug listeners)
        Simulation sim = Simulation.createDemoWithStats();

        // Start simulation
        sim.start();

        // Let it run a bit
        Thread.sleep(350);

        // Pause
        sim.pause();
        int pausedAt = sim.getTick();
        System.out.println("Paused at tick: " + pausedAt);

        // Wait while paused (tick should not change)
        Thread.sleep(400);
        System.out.println("Still paused tick: " + sim.getTick());

        // Resume and let it run a bit more
        sim.resume();
        Thread.sleep(300);

        // Stop
        sim.stop();
        System.out.println("Stopped at tick: " + sim.getTick());

        // Optional: give the simulation thread a tiny moment to exit cleanly
        Thread.sleep(50);
        */

        /* MockNode node = new MockNode(new double[]{0, 0}, 50);

        Road road1 = new Road(node, 100, 1, null, "road1");
        Road road2 = new Road(node, 100, 1, null, "road2");

        TrafficLight light = new TrafficLight(2);
        light.addRoad(road1, 0);
        light.addRoad(road2, 1);

        // Lägg en bil nära slutet av road2 så att den ska räknas som incoming traffic
        RoadPosition pos = new RoadPosition(road2, 0, 95);
        VehicleProperties props = new VehicleProperties(5, 1, 1);
        Vehicle vehicle = new Vehicle(props, pos, 0);
        road2.enterVehicle(vehicle, 0, 95);

        System.out.println("Start:");
        System.out.println("road1 green? " + light.hasGreen(road1));
        System.out.println("road2 green? " + light.hasGreen(road2));
        System.out.println("activeGreenIndex = " + light.getActiveGreenIndex());

        for (int i = 1; i <= 10; i++) {
            light.update();
            System.out.println("Tick " + i);
            System.out.println("road1 green? " + light.hasGreen(road1));
            System.out.println("road2 green? " + light.hasGreen(road2));
            System.out.println("activeGreenIndex = " + light.getActiveGreenIndex());
            System.out.println("greenTime = " + light.getCurrentGreenTime());
            System.out.println();
        }
         */
    }
}