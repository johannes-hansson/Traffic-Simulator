import javafx.scene.paint.Color;

public enum VehicleColor {
    Red(Color.RED),
    Green(Color.GREEN),
    Blue(Color.BLUE),
    Yellow(Color.YELLOW);

    private Color javaFXColor;

    private VehicleColor(Color javaFxColor) {this.javaFXColor = javaFxColor;}

    public Color getJavaFxColor() {
        return this.javaFXColor;
    }
}
