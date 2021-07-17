package View.windows;

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

    private final static String STYLE_FILE = "/Styles/ErrorWindowStyle.css";
    private final static String WIN_TITLE = "Error window";
    private final static String WIN_ICON = "/error_icon.jpg";
    private final static String LABEL_SC = "Label";
    private final static String PANE_SC = "Border-Pane";

    public void launchWin(String errorText, String adviceForFix) {
        String stylesheet = getClass().getResource(STYLE_FILE).toExternalForm();

        Label errorMessage = new Label(errorText);
        errorMessage.getStyleClass().add(LABEL_SC);
        Label fixAdvice = new Label(adviceForFix);
        fixAdvice.getStyleClass().add(LABEL_SC);

        BorderPane mainPane = new BorderPane();
        mainPane.getStyleClass().add(PANE_SC);
        VBox centralVBox = new VBox(VBOX_SPACING);
        centralVBox.setAlignment(Pos.CENTER);
        centralVBox.getChildren().addAll(errorMessage, fixAdvice);
        mainPane.setCenter(centralVBox);

        Stage window = new Stage();
        Scene winScene = new Scene(mainPane, WIN_WIDTH, WIN_HEIGHT);
        winScene.getStylesheets().add(stylesheet);
        window.setTitle(WIN_TITLE);
        window.initModality(Modality.APPLICATION_MODAL);
        window.getIcons().add(new Image(WIN_ICON));
        window.setScene(winScene);
        window.show();
    }
}