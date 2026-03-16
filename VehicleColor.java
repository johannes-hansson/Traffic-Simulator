import javafx.scene.paint.Color;

public enum VehicleColor {
    RED(Color.RED),
    GREEN(Color.GREEN),
    LIGHTBLUE(Color.SKYBLUE),
    BLACK(Color.BLACK),
    PINK(Color.HOTPINK),
    GREY(Color.DARKGREY),
    ORANGE(Color.ORANGE);

    private Color javaFXColor;

    private VehicleColor(Color javaFxColor) {this.javaFXColor = javaFxColor;}

    public Color getJavaFxColor() {
        return this.javaFXColor;
    }
}
