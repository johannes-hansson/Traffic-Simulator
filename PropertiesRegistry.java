import java.util.HashMap;

public class PropertiesRegistry {
    private HashMap<String, VehicleProperties> registry;

    public PropertiesRegistry() {
        this.registry = new HashMap<>();
        this.registry.put("car", new VehicleProperties(
                10,
                1,
                new int[]{8, 4},
                VehicleColor.Red
        ));

        this.registry.put("buss", new VehicleProperties(
                8,
                1,
                new int[]{16, 6},
                VehicleColor.Yellow
        ));
    }

    public VehicleProperties getVehicleProperties(String name) {
        return this.registry.get(name);
    }
}