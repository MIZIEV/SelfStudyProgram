package View;

import javafx.scene.control.*;

public class ResultMessage extends TextArea {

    private static final int XCORDINATES = 885;
    private static final int YCORDINATES = 50;
    private static final int WIDTH = 135;
    private static final int HEIGHT = 300;

    public ResultMessage() {
        this.setLayoutX(XCORDINATES);
        this.setLayoutY(YCORDINATES);
        this.setPrefSize(WIDTH, HEIGHT);
        this.setEditable(false);
    }
}