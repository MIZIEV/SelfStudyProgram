package prog.view.patterns.controls;

import prog.controller.ColorController;
import javafx.scene.control.TextArea;

/**
 * class description:
 * this class needed for showing text by different color.
 * Color dependency from yasNo variable:
 * if var=1, color = green, if var =-1, color = red, if var=0, color = black.
 * todo check this description!!!
 */
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