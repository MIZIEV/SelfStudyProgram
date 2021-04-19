package View.buttonsPatterns;

import javafx.scene.control.*;

public class ButtonsPattern extends Button {

    private int prefWidth, prefHeight;
    private final String name;

    public ButtonsPattern( int width, int height, String name) {

        this.name = name;
        this.setText(name);

        this.prefWidth = width;
        this.prefHeight = height;
        this.setPrefSize(width, height);
    }
}