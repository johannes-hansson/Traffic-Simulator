import java.util.HashMap;

public class PropertiesRegistry {
    private HashMap<String, VehicleProperties> registry;

    public PropertiesRegistry() {
        this.registry = new HashMap<>();
        this.registry.put("car", new VehicleProperties(
                5,
                1,
                new int[]{4,2},
                VehicleColor.Red
        ));

        this.registry.put("buss", new VehicleProperties(
                4,
                1,
                new int[]{8, 3},
                VehicleColor.Yellow
        ));
    }

    public VehicleProperties getVehicleProperties(String name) {
        return this.registry.get(name);
    }
}