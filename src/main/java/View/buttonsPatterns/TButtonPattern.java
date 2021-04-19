package View.buttonsPatterns;

import javafx.scene.control.ToggleButton;

public class TButtonPattern extends ToggleButton {


    private int prefWidth, prefHeight;
    private final String name;

    public TButtonPattern( int width, int height, String name) {
        this.name = name;
        this.setText(name);
        this.prefWidth = width;
        this.prefHeight = height;
        this.setPrefSize(width, height);
    }
}
