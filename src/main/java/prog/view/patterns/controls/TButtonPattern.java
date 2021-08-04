package prog.view.patterns.controls;

import javafx.scene.control.ToggleButton;

public class TButtonPattern extends ToggleButton {

    public TButtonPattern(int width, int height, String name) {
        this.setText(name);
        this.setPrefSize(width, height);
    }
}