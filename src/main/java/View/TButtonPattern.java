package View;

import javafx.scene.control.ToggleButton;

public class TButtonPattern extends ToggleButton {
    private int x, y;
    private int prefWidth, prefHeight;
    private final String name;

    public TButtonPattern(int x, int y, int width, int height, String name) {
        this.name = name;
        this.setText(name);
        this.x = x;
        this.y = y;
        this.setLayoutX(x);
        this.setLayoutY(y);

        this.prefWidth = width;
        this.prefHeight = height;
        this.setPrefSize(width, height);
    }
}
