package View.buttonsPatterns;

import javafx.scene.control.*;

public class ButtonsPattern extends Button {

    public ButtonsPattern(int width, int height, String name) {
        setText(name);
        setPrefSize(width, height);
    }

    public ButtonsPattern(int width, int height, String styleClass, String name) {
        setPrefSize(width, height);
        getStyleClass().add(styleClass);
        setText(name);
    }
}