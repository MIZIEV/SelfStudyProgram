package prog.view.windows;

import prog.model.MainModel;
import prog.view.patterns.containers.DecorPanePattern;
import prog.view.patterns.containers.HBoxPattern;
import prog.view.patterns.containers.VBoxPattern;
import prog.view.patterns.controls.ButtonsPattern;
import prog.view.patterns.controls.LabelPattern;
import animatefx.animation.FadeIn;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdditionalWindow {

    private final MainModel model;

    private final static String ICON_URL = "/question_icon.png";
    private final static String WIN_STYLE_FILE = "/Styles/AdditionalWinStyle.css";
    private final static String LABEL_STYLE_CLASS = "label";
    private final static String OK_BUTTON_STYLE_CLASS = "button-ok";
    private final static String UUPS_BUTTON_STYLE_CLASS = "button-uups";
    private final static String TOP_DECOR_PANE_STYLE_CLASS = "top-pane";
    private final static String BOTTOM_DECOR_PANE_STYLE_CLASS = "bottom-pane";

    private final static byte CENTRAL_VBOX_SPACING = 10;
    private final static byte BUTTON_HBOX_SPACING = 50;

    private final static byte DECOR_PANE_HEIGHT = 50;
    private final static byte BUTTON_WIDTH = 80;
    private final static byte BUTTON_HEIGHT = 60;

    private final static short WIN_WIDTH = 600;
    private final static short WIN_HEIGHT = 500;
    private final static short MIN_WIN_SIZE = 300;

    public AdditionalWindow(MainModel mainModel) {
        this.model = mainModel;
    }

    public void launchWin(LoadWindow loadWindow, SecondWindow secondWindow) {

        String stylesheets = getClass().getResource(WIN_STYLE_FILE).toExternalForm();
        Stage window = new Stage();
        BorderPane mainPane = new BorderPane();
        DecorPanePattern topDecorPane = new DecorPanePattern(TOP_DECOR_PANE_STYLE_CLASS, DECOR_PANE_HEIGHT);
        DecorPanePattern bottomPane = new DecorPanePattern(BOTTOM_DECOR_PANE_STYLE_CLASS, DECOR_PANE_HEIGHT);
        VBoxPattern centralVBox = new VBoxPattern(Pos.CENTER, CENTRAL_VBOX_SPACING);
        HBoxPattern buttonsHBox = new HBoxPattern(Pos.CENTER, BUTTON_HBOX_SPACING);

        LabelPattern questionLabel = new LabelPattern(LABEL_STYLE_CLASS, "Are you sure ???");
        ButtonsPattern yesButton = new ButtonsPattern(BUTTON_WIDTH, BUTTON_HEIGHT, OK_BUTTON_STYLE_CLASS, "Yes");
        ButtonsPattern uupsButton = new ButtonsPattern(BUTTON_WIDTH, BUTTON_HEIGHT, UUPS_BUTTON_STYLE_CLASS, "uups");

        yesButton.setOnAction(event -> {
            for (int i = 0; i < loadWindow.getButtonsList().size(); i++) {
                if (loadWindow.getButtonsList().get(i).isSelected()) {
                    model.getFileWorker().removeFile(loadWindow.getButtonsList().get(i).getText());
                    break;
                }
            }
            window.close();
            loadWindow.getButtonsList().clear();
            loadWindow.launchWin(secondWindow);
        });

        uupsButton.setOnAction(event -> {
            window.close();
            loadWindow.launchWin(secondWindow);
        });

        buttonsHBox.getChildren().addAll(uupsButton, yesButton);
        centralVBox.getChildren().addAll(questionLabel, buttonsHBox);
        mainPane.setCenter(centralVBox);
        mainPane.setTop(topDecorPane);
        mainPane.setBottom(bottomPane);

        Scene winScene = new Scene(mainPane, WIN_WIDTH, WIN_HEIGHT);
        winScene.getStylesheets().add(stylesheets);
        new FadeIn(mainPane).play();
        window.setMaxWidth(WIN_WIDTH);
        window.setMaxHeight(WIN_HEIGHT);
        window.setMinWidth(MIN_WIN_SIZE);
        window.setMinHeight(MIN_WIN_SIZE);
        window.getIcons().add(new Image(ICON_URL));
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(winScene);
        window.show();
    }
}