import javafx.scene.paint.Color;

public enum VehicleColor {
    Red(Color.RED),
    Green(Color.GREEN),
    LightBlue(Color.SKYBLUE),
    Black(Color.BLACK),
    Pink(Color.HOTPINK),
    Grey(Color.DARKGREY),
    Orange(Color.ORANGE);

    private Color javaFXColor;

    private VehicleColor(Color javaFxColor) {this.javaFXColor = javaFxColor;}

    public Color getJavaFxColor() {
        return this.javaFXColor;
    }
}
