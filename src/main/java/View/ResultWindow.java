package View;

import View.buttonsPatterns.ButtonsPattern;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ResultWindow {

    private final static String WINDOW_SC = "/Styles/ResultWindowStyle.css";
    private final static String WINDOW_ICON = "/result_icon.png";
    private final static String WINDOW_TITLE = "Your result";
    private final static String SC_TOP_DECOR_PANE = "top-pane";
    private final static String SC_BOTTOM_DECOR_PANE = "bottom-pane";

    private final static short WINDOW_WIDTH = 500;
    private final static short WINDOW_HEIGHT = 300;
    private final static short BUTTON_HEIGHT = 50;
    private final static short BUTTON_WIDTH = 150;
    private final static byte DECOR_PANE_HEIGHT = 50;
    private final static byte MARGIN = 10;

    public void initResultWin(double result) {
        String stylesheet = getClass().getResource(WINDOW_SC).toExternalForm();
        Insets margin = new Insets(MARGIN);
        Stage window = new Stage();
        BorderPane mainPane = new BorderPane();
        Pane topDecorPane = new Pane();
        Pane bottomDecorPane = new Pane();
        VBox mainVbox = new VBox();

        BorderPane.setMargin(mainVbox,margin);
        topDecorPane.setPrefHeight(DECOR_PANE_HEIGHT);
        topDecorPane.getStyleClass().add(SC_TOP_DECOR_PANE);
        bottomDecorPane.setPrefHeight(DECOR_PANE_HEIGHT);
        bottomDecorPane.getStyleClass().add(SC_BOTTOM_DECOR_PANE);

        mainVbox.setAlignment(Pos.CENTER);
        mainPane.setTop(topDecorPane);
        mainPane.setBottom(bottomDecorPane);
        mainPane.setCenter(mainVbox);
        Label title = new Label("Your result:");
        Label yourResult = new Label();
        yourResult.setText("" + (int) result * 100);
        ButtonsPattern okButton = new ButtonsPattern(BUTTON_WIDTH, BUTTON_HEIGHT, "ok");
        mainVbox.getChildren().addAll(title, yourResult, okButton);

        Scene winScene = new Scene(mainPane, WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setMaxWidth(WINDOW_WIDTH);
        window.setMaxHeight(WINDOW_HEIGHT);
        winScene.getStylesheets().add(stylesheet);
        window.setTitle(WINDOW_TITLE);
        window.initModality(Modality.APPLICATION_MODAL);
        window.getIcons().add(new Image(WINDOW_ICON));
        window.setScene(winScene);
        window.show();
    }
}