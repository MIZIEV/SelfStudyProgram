package View.patterns.controls;

import javafx.scene.control.Label;

public class LabelPattern extends Label {

    public LabelPattern(String styleClass, String text) {
        getStyleClass().add(styleClass);
        setText(text);
    }
}
