package View.patterns.containers;

import javafx.scene.layout.Pane;

public class DecorPanePattern extends Pane {

    public DecorPanePattern(String styleClass, int height) {
        getStyleClass().add(styleClass);
        setPrefHeight(height);
    }
}
