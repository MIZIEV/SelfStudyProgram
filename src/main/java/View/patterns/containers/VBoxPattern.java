package View.patterns.containers;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class VBoxPattern extends VBox {

    public VBoxPattern(Pos position, int spacing) {
        setAlignment(position);
        setSpacing(spacing);
    }
}