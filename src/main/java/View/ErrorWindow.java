package View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorWindow {

    private final static short WIN_WIDTH = 500;
    private final static short WIN_HEIGHT = 300;
    private final static byte VBOX_SPACING = 20;

    private final static String WIN_ICON = "/error_icon.jpg";
    private final static String LABEL_STYLE = "Label";
    private final static String PANE_STYLE = "Border-Pane";
    private final static String WIN_TITLE = "Error window";

    public void launchWin(String errorText,String fixAdvise) {
        String stylesheet = getClass().getResource("/ErrorWindowStyle.css").toExternalForm();

        Label errorMessage = new Label(errorText);
        errorMessage.getStyleClass().add(LABEL_STYLE);
        Label fixAdvice = new Label(fixAdvise);
        fixAdvice.getStyleClass().add(LABEL_STYLE);

        Stage window = new Stage();
        BorderPane mainPane = new BorderPane();
        mainPane.getStyleClass().add(PANE_STYLE);
        VBox centralVBox = new VBox(VBOX_SPACING);
        centralVBox.setAlignment(Pos.CENTER);
        centralVBox.getChildren().addAll(errorMessage,fixAdvice);
        mainPane.setCenter(centralVBox);
        Scene winScene = new Scene(mainPane, WIN_WIDTH, WIN_HEIGHT);
        winScene.getStylesheets().add(stylesheet);
        window.setTitle(WIN_TITLE);
        window.initModality(Modality.APPLICATION_MODAL);
        window.getIcons().add(new Image(WIN_ICON));
        window.setScene(winScene);
        window.show();
    }
}