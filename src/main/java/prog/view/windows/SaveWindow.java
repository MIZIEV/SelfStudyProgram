package prog.view.windows;

import prog.view.patterns.containers.DecorPanePattern;
import prog.view.patterns.controls.ButtonsPattern;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SaveWindow {

    private final static String STYLE_WINDOW_FILE = "/Styles/SaveWindowStyle.css";
    private final static String STYLE_WINDOW_FILE_ERROR = "/Styles/SaveWindowStyleError.css";

    private final static String SC_TOP_DECOR_PANE = "top-pane";
    private final static String SC_BOTTOM_PANE = "bottom-pane";

    private final static String WINDOW_ICON = "/save_win_icon.png";
    private final static String WINDOW_TITLE = "Saving result";

    private final static short WINDOW_HEIGHT = 250;
    private final static short WINDOW_WIDTH = 400;
    private final static short MIN_WIN_HEIGHT = 230;
    private final static short MIN_WIN_WIDTH = 300;

    private final static byte DECOR_PANE_HEIGHT = 50;
    private final static byte BUTTON_WIDTH = 80;
    private final static byte BUTTON_HEIGHT = 40;

    private final static String DONE_RESULT = "File was saved";
    private final static String ERROR_RESULT = "File was not saved";


    public static void initWindow(boolean savingResult) {
        Stage window = new Stage();
        String stylesheet;
        Label text = new Label();
        if (savingResult) {
            stylesheet = SaveWindow.class.getResource(STYLE_WINDOW_FILE).toExternalForm();
            text.setText(DONE_RESULT);
        } else {
            stylesheet = SaveWindow.class.getClass().getResource(STYLE_WINDOW_FILE_ERROR).toExternalForm();
            text.setText(ERROR_RESULT);
        }

        BorderPane mainPane = new BorderPane();
        VBox mainVBox = new VBox();
        DecorPanePattern topDecorPane = new DecorPanePattern(SC_TOP_DECOR_PANE, DECOR_PANE_HEIGHT);
        DecorPanePattern bottomDecorPane = new DecorPanePattern(SC_BOTTOM_PANE, DECOR_PANE_HEIGHT);

        ButtonsPattern okButton = new ButtonsPattern(BUTTON_WIDTH, BUTTON_HEIGHT, "ok");

        okButton.setOnAction(event -> window.close());
        mainVBox.setAlignment(Pos.CENTER);

        mainVBox.getChildren().addAll(text, okButton);
        mainPane.setTop(topDecorPane);
        mainPane.setBottom(bottomDecorPane);
        mainPane.setCenter(mainVBox);
        Scene winScene = new Scene(mainPane, WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setMaxWidth(WINDOW_WIDTH);
        window.setMaxHeight(WINDOW_HEIGHT);
        window.setMinWidth(MIN_WIN_WIDTH);
        window.setMinHeight(MIN_WIN_HEIGHT);
        winScene.getStylesheets().add(stylesheet);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(winScene);
        window.setTitle(WINDOW_TITLE);
        window.getIcons().add(new Image(WINDOW_ICON));
        window.show();
    }
}