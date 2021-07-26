package prog.view.patterns.containers;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class HBoxPattern extends HBox {

    public HBoxPattern(Pos position, int spacing) {
        setAlignment(position);
        setSpacing(spacing);
    }
}
