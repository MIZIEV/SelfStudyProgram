package View.buttonsPatterns;

import javafx.scene.control.*;

public class ButtonsPattern extends Button {
    private int x, y;
    private int prefWidth, prefHeight;
    private final String name;

    public ButtonsPattern(int x, int y, int width, int height, String name) {

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