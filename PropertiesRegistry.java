import java.util.HashMap;

public class PropertiesRegistry {
    private HashMap<String, VehicleProperties> registry;

    public PropertiesRegistry() {
        this.registry = new HashMap<>();
        this.registry.put("car", new VehicleProperties(
                7,
                2,
                new int[]{5,4},
                VehicleColor.ORANGE
        ));

        this.registry.put("buss", new VehicleProperties(
                6,
                1,
                new int[]{8, 4},
                VehicleColor.LIGHTBLUE
        ));
        this.registry.put("truck", new VehicleProperties(
                5,
                1,
                new int[]{8, 4},
                VehicleColor.BLACK
        ));
    }

    public VehicleProperties getVehicleProperties(String name) {
        return this.registry.get(name);
    }
}