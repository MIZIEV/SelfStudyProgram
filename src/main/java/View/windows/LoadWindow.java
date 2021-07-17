package View.windows;

import Controller.ButtonsControllers.LoadButtonController;
import Model.MainModel;
import View.patterns.containers.DecorPanePattern;
import View.patterns.containers.HBoxPattern;
import View.patterns.containers.TButtonPattern;
import View.patterns.containers.VBoxPattern;
import View.patterns.controls.ButtonsPattern;
import animatefx.animation.FadeIn;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoadWindow {

    private final FirstWindow firstWindow;
    private final MainModel model;
    private final ArrayList<TButtonPattern> buttonsList = new ArrayList<>();

    private final static String ICON_URL = "/load_window_icon.png";
    private final static String WIN_TITLE = "Loading saved files";
    private final static String SC_FILE = "/Styles/LoadWindowStyle.css";
    private final static String TOP_DECOR_PANE_SC = "top-pane";
    private final static String BOTTOM_DECOR_PANE_SC = "bottom-pane";
    private final static String LOAD_BUTTON_SC = "button-load";
    private final static String DELETE_BUTTON_SC = "button-delete";

    private final static short TB_WIDTH = 540;
    private final static short TB_HEIGHT = 60;
    private final static short BUTTON_WIDTH = 100;
    private final static short BUTTON_HEIGHT = 60;

    private final static byte SIDE_PANE_INSERT_WIDTH = 30;
    private final static byte CENTRAL_VBOX_SPACING = 10;
    private final static byte BOTTOM_HBOX_SPACING = 100;
    private final static byte DECOR_PANE_HEIGHT = 100;
    private final static short WIN_WIDTH = 600;
    private final static short WIN_HEIGHT = 500;
    private final static short MIN_WIN_HEIGHT = 400;

    public LoadWindow(FirstWindow firstWindow, MainModel model) {
        this.firstWindow = firstWindow;
        this.model = model;
    }

    public void launchWin(SecondWindow secondWindow) {
        String stylesheets = getClass().getResource(SC_FILE).toExternalForm();

        Stage window = new Stage();
        BorderPane mainPane = new BorderPane();
        DecorPanePattern topDecorPane = new DecorPanePattern(TOP_DECOR_PANE_SC, DECOR_PANE_HEIGHT);
        Pane leftInsertPane = new Pane();
        Pane rightInsertPane = new Pane();
        leftInsertPane.setPrefWidth(SIDE_PANE_INSERT_WIDTH);
        rightInsertPane.setPrefWidth(SIDE_PANE_INSERT_WIDTH);
        BorderPane bottomDecorPane = new BorderPane();
        bottomDecorPane.getStyleClass().add(BOTTOM_DECOR_PANE_SC);
        bottomDecorPane.setPrefHeight(DECOR_PANE_HEIGHT);
        ScrollPane mainScrollPane = new ScrollPane();

        VBoxPattern centralVBox = new VBoxPattern(Pos.CENTER, CENTRAL_VBOX_SPACING);
        HBoxPattern bottomHBox = new HBoxPattern(Pos.CENTER, BOTTOM_HBOX_SPACING);
        model.getFileWorker().searchFiles();

        ToggleGroup group = new ToggleGroup();
        LoadButtonController controller = new LoadButtonController(model);
        centralVBox.getChildren().clear();

        for (int i = 0; i < model.getFileWorker().getFilesName().size(); i++) {
            buttonsList.add(new TButtonPattern(TB_WIDTH, TB_HEIGHT, model.getFileWorker().getFilesName().get(i)));
            group.getToggles().addAll(buttonsList.get(i));

            centralVBox.getChildren().addAll(buttonsList.get(i));
        }

        ButtonsPattern loadButton = new ButtonsPattern(BUTTON_WIDTH, BUTTON_HEIGHT, LOAD_BUTTON_SC, "Load");
        ButtonsPattern deleteButton = new ButtonsPattern(BUTTON_WIDTH, BUTTON_HEIGHT, DELETE_BUTTON_SC, "Delete");

        deleteButton.setOnAction(event -> {
            if (group.getSelectedToggle() == null) {
                deleteButton.setTooltip(new Tooltip("Nothing to delete"));
            } else {
                window.close();
                AdditionalWindow additionalWindow = new AdditionalWindow(model);
                additionalWindow.launchWin(this, secondWindow);
            }
        });

        loadButton.setOnAction(event -> {
            if (group.getSelectedToggle() == null) {
                loadButton.setTooltip(new Tooltip("Nothing to load"));
            } else {
                window.close();
                firstWindow.closeWin();
                for (int i = 0; i < model.getFileWorker().getFilesName().size(); i++) {
                    if (buttonsList.get(i).isSelected()) {
                        controller.loadSavedFile(buttonsList.get(i).getText());
                        break;
                    }
                }
                secondWindow.getResultIndicator().setProgress(model.getJsonWorker().getTotalResult());
                secondWindow.initWin();
            }
        });

        bottomHBox.getChildren().addAll(deleteButton, loadButton);
        mainScrollPane.setContent(centralVBox);
        bottomDecorPane.setCenter(bottomHBox);
        mainPane.setLeft(leftInsertPane);
        mainPane.setRight(rightInsertPane);
        mainPane.setTop(topDecorPane);
        mainPane.setBottom(bottomDecorPane);
        mainPane.setCenter(mainScrollPane);

        Scene winScene = new Scene(mainPane, WIN_WIDTH, WIN_HEIGHT);
        window.setMaxWidth(WIN_WIDTH);
        window.setMaxHeight(WIN_HEIGHT);
        window.setMinWidth(WIN_WIDTH);
        window.setMinHeight(MIN_WIN_HEIGHT);
        winScene.getStylesheets().add(stylesheets);
        new FadeIn(mainPane).play();
        window.setTitle(WIN_TITLE);
        window.getIcons().add(new Image(ICON_URL));
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(winScene);
        window.show();
    }
    public ArrayList<TButtonPattern> getButtonsList() { return buttonsList; }
}