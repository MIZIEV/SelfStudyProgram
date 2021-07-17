package View;

import View.buttonsPatterns.ButtonsPattern;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SaveWindow {

    private final static String STYLE_WINDOW_FILE = "/Styles/SaveWindowStyle.css";
    private final static String SC_TOP_DECOR_PANE = "top-pane";
    private final static String SC_BOTTOM_PANE = "bottom-pane";

    private final Stage window = new Stage();

    public void initWindow() {
        String stylesheet = getClass().getResource(STYLE_WINDOW_FILE).toExternalForm();

        BorderPane mainPane = new BorderPane();
        VBox mainVBox = new VBox();
        Pane topDecorePane = new Pane();
        Pane bottomDecorPane = new Pane();
        Label text = new Label("File was saved");

        topDecorePane.setPrefHeight(50);
        bottomDecorPane.setPrefHeight(50);
        topDecorePane.getStyleClass().add(SC_TOP_DECOR_PANE);
        bottomDecorPane.getStyleClass().add(SC_BOTTOM_PANE);
        ButtonsPattern okButton = new ButtonsPattern(80, 40, "ok");

        okButton.setOnAction(event -> window.close());
        mainVBox.setAlignment(Pos.CENTER);

        mainVBox.getChildren().addAll(text, okButton);
        mainPane.setTop(topDecorePane);
        mainPane.setBottom(bottomDecorPane);
        mainPane.setCenter(mainVBox);
        Scene winScene = new Scene(mainPane, 200, 200);
        winScene.getStylesheets().add(stylesheet);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(winScene);
        window.show();
    }
}