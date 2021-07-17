package View.patterns.controls;

import Controller.ColorController;
import javafx.scene.control.TextArea;

public class TextAreaPattern extends TextArea {

    private final ColorController controller;
    private final static String STYLE_FILE = "/Styles/TextAreaStyle.css";
    private final static String SC_DEFAULT = "default-text-area";

    public TextAreaPattern(ColorController controller) {
        String stylesheet = getClass().getResource(STYLE_FILE).toExternalForm();
        this.controller = controller;
        this.getStylesheets().add(stylesheet);
        this.getStyleClass().add(SC_DEFAULT);
        this.setEditable(false);
        this.setWrapText(true);
    }

    public void showText(String text) {
        this.getStyleClass().clear();
        this.setText(text);
        this.getStyleClass().add(controller.selectTextColor());
    }
}