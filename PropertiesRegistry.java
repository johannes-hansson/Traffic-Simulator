import java.util.HashMap;

public class PropertiesRegistry {
    private HashMap<String, VehicleProperties> registry;

    public PropertiesRegistry() {
        this.registry = new HashMap<>();
        this.registry.put("car", new VehicleProperties(
                5,
                1,
                new int[]{5,4},
                VehicleColor.Orange
        ));

        this.registry.put("buss", new VehicleProperties(
                4,
                1,
                new int[]{8, 4},
                VehicleColor.LightBlue
        ));
        this.registry.put("truck", new VehicleProperties(
                4,
                1,
                new int[]{8, 4},
                VehicleColor.Black
        ));
    }

    public VehicleProperties getVehicleProperties(String name) {
        return this.registry.get(name);
    }
}