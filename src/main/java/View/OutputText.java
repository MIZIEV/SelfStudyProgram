package View;

import javafx.scene.control.TextArea;

public class OutputText extends TextArea {

    private static final int XCORDINATES = 168;
    private static final int YCORDINATES = 50;
    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;

    public OutputText() {
        this.setLayoutX(XCORDINATES);
        this.setLayoutY(YCORDINATES);
        this.setPrefSize(WIDTH, HEIGHT);
        this.setEditable(false);
    }
}