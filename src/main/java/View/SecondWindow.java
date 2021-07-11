package View;

import Controller.ButtonsControllers.*;
import Controller.ColorController;
import View.buttonsPatterns.ButtonsPattern;
import View.buttonsPatterns.HBoxPattern;
import View.buttonsPatterns.VBoxPattern;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SecondWindow {

    private final FirstWindow firstWindow;
    private final GeneralDependence generalDependence;

    private final ProgressIndicator resultIndicator = new ProgressIndicator();

    private final static short MIN_WINDOW_WIDTH = 800;
    private final static short MIN_WINDOW_HEIGHT = 600;
    private final static short PREF_WINDOWS_WIDTH = 1366;
    private final static short PREF_WINDOWS_HEIGHT = 900;

    private final static byte INTERVAL = 10;
    private final static byte RIGHT_VBOX_INTERVAL = 50;

    private final static byte LEFT_INTERVAL_RIGHT_VBOX = 0;
    private final static byte CENTER_HBOX_INTERVAL = 15;

    private final static short PREF_DECORATED_PANE_WIDTH = 1024;
    private final static short PREF_DECORATED_PANE_HEIGHT = 70;

    private final static short PREF_LEFT_VBOX_WIDTH = 200;
    private final static short PREF_LEFT_VBOX_HEIGHT = 630;
    private final static short PREF_SIDE_BLOCK_HEIGHT = 300;

    private final static short PREF_HEIGHT = 50;
    private final static short PREF_WIDTH_SMALL = 60;
    private final static short PREF_WIDTH_STANDARD = 140;


    private final static short PREF_WIDTH_INDICATOR = 180;
    private final static short PREF_HEIGHT_INDICATOR = 140;

    private final static String STYLE_FILE = "/Styles/SecondStyle.css";
    private final static String WIN_ICON = "icon.jpg";
    private final static String TOP_DECOR_PANE_STYLE = "top-border-pane";
    private final static String BOTTOM_DECOR_PANE_STYLE = "bottom-border-pane";
    private final static String START_BUTTON_STYLE = "start-button";
    private final static String YES_BUTTON_STYLE = "yes-button";
    private final static String SC_NO_BUTTON = "no-button";
    private final static String SC_TEXT_AREA = "default-text-area";

    public SecondWindow(FirstWindow firstW, GeneralDependence genDependence) {

        this.generalDependence = genDependence;
        this.firstWindow = firstW;
    }

    public void startWin() {
        Stage secondWindow = new Stage();
        Insets margin = new Insets(INTERVAL);
        String stylesheet = getClass().getResource(STYLE_FILE).toExternalForm();
        //_________________________________________create all buttons
        ButtonsPattern startButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, START_BUTTON_STYLE, "Start");
        ButtonsPattern nextButton = new ButtonsPattern(PREF_WIDTH_SMALL, PREF_HEIGHT, "→");
        ButtonsPattern previousButton = new ButtonsPattern(PREF_WIDTH_SMALL, PREF_HEIGHT, "←");
        ButtonsPattern questionButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Random question");
        ButtonsPattern answerButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Answer");
        ButtonsPattern yesButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, YES_BUTTON_STYLE, "✓");
        ButtonsPattern noButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, SC_NO_BUTTON, "X");
        ButtonsPattern saveButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Save");
        ButtonsPattern backButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Back");
        //_________________________________________create all controllers
        ColorController colorController = new ColorController(generalDependence.getDBWorker(),generalDependence.getListIndex());
        Changer startButtonController = new StartButtonController(generalDependence.getDBWorker(), generalDependence.getListIndex());
        Changer nextButtonController = new NextButtonController(generalDependence.getDBWorker(), generalDependence.getListIndex());
        Changer previousButtonController = new PreviousButtonController(generalDependence.getDBWorker(), generalDependence.getListIndex());
        Changer questionButtonController = new QuestionButtonController(generalDependence.getDBWorker(), generalDependence.getListIndex());
        Changer answerButtonController = new AnswerButtonController(generalDependence.getDBWorker(), generalDependence.getListIndex());
        YesButtonController yesButtonController = new YesButtonController(generalDependence.getDBWorker(), generalDependence.getListIndex());
        NoButtonController noButtonController = new NoButtonController(generalDependence.getDBWorker(), generalDependence.getListIndex());
        SaveButtonController saveController = new SaveButtonController(generalDependence.getDBWorker(), generalDependence.getJsonWorker());
        //_________________________________________create main pane and all view elements
        BorderPane mainPane = new BorderPane();
        BorderPane topDecorPane = new BorderPane();
        BorderPane bottomDecorPane = new BorderPane();
        TextArea outputText = new TextArea();
        outputText.getStyleClass().clear();
        outputText.getStyleClass().add(SC_TEXT_AREA);
        outputText.setWrapText(true);
        outputText.setEditable(false);
        resultIndicator.getStyleClass().add(colorController.selectIndicatorColor(generalDependence.getCountingResult().getTotalResult()));
        resultIndicator.setPrefSize(PREF_WIDTH_INDICATOR, PREF_HEIGHT_INDICATOR);
        //_________________________________________set decorate top & bottom panel
        topDecorPane.setPrefSize(PREF_DECORATED_PANE_WIDTH, PREF_DECORATED_PANE_HEIGHT);
        topDecorPane.getStyleClass().add(TOP_DECOR_PANE_STYLE);
        bottomDecorPane.setPrefSize(PREF_DECORATED_PANE_WIDTH, PREF_DECORATED_PANE_HEIGHT);
        bottomDecorPane.getStyleClass().add(BOTTOM_DECOR_PANE_STYLE);
        //_________________________________________set left part without buttons
        VBox leftVBox = new VBox(INTERVAL);
        VBoxPattern topLeftBlock = new VBoxPattern(Pos.TOP_CENTER, INTERVAL);
        topLeftBlock.setPrefHeight(PREF_SIDE_BLOCK_HEIGHT);
        VBoxPattern centralLeftBlock = new VBoxPattern(Pos.CENTER, INTERVAL);
        centralLeftBlock.setPrefHeight(PREF_SIDE_BLOCK_HEIGHT);
        VBoxPattern bottomLeftBlock = new VBoxPattern(Pos.BOTTOM_CENTER, INTERVAL);
        bottomLeftBlock.setPrefHeight(PREF_SIDE_BLOCK_HEIGHT);
        leftVBox.setPrefSize(PREF_LEFT_VBOX_WIDTH, PREF_LEFT_VBOX_HEIGHT);
        leftVBox.setPadding(margin);
        HBoxPattern centerHBox = new HBoxPattern(Pos.CENTER, CENTER_HBOX_INTERVAL);
        //_________________________________________set buttons in HBox & set this box to VBox
        centerHBox.getChildren().addAll(previousButton, nextButton);
        topLeftBlock.getChildren().addAll(startButton, centerHBox);
        centralLeftBlock.getChildren().addAll(questionButton, answerButton);
        bottomLeftBlock.getChildren().addAll(backButton);
        leftVBox.getChildren().addAll(topLeftBlock, centralLeftBlock, bottomLeftBlock);
        //_________________________________________create right VBox & add all element
        VBoxPattern rightVBox = new VBoxPattern(Pos.TOP_CENTER, RIGHT_VBOX_INTERVAL);
        VBoxPattern topRightBlock = new VBoxPattern(Pos.TOP_CENTER, INTERVAL);
        topRightBlock.setPrefHeight(PREF_SIDE_BLOCK_HEIGHT);
        VBoxPattern centralRightBlock = new VBoxPattern(Pos.CENTER, INTERVAL);
        centralRightBlock.setPrefHeight(PREF_SIDE_BLOCK_HEIGHT);
        VBoxPattern bottomRightBlock = new VBoxPattern(Pos.BOTTOM_CENTER, INTERVAL);
        bottomRightBlock.setPrefHeight(PREF_SIDE_BLOCK_HEIGHT);
        topRightBlock.getChildren().addAll(resultIndicator, saveButton);
        centralRightBlock.getChildren().addAll(yesButton, noButton);
        rightVBox.getChildren().addAll(topRightBlock, centralRightBlock, bottomRightBlock);

        nextButton.setDisable(true);
        previousButton.setDisable(true);
        questionButton.setDisable(true);
        answerButton.setDisable(true);
        yesButton.setDisable(true);
        saveButton.setDisable(true);
        noButton.setDisable(true);
        //_________________________________________add listeners to all buttons
        startButton.setOnAction((event) -> {
            outputText.getStyleClass().clear();
            outputText.getStyleClass().add(colorController.selectTextColor());
            outputText.setText(startButtonController.startController());
            startButton.setDisable(true);
            nextButton.setDisable(false);
            previousButton.setDisable(false);
            questionButton.setDisable(false);
            answerButton.setDisable(false);
            yesButton.setDisable(false);
            saveButton.setDisable(false);
            noButton.setDisable(false);
        });
        //_________________________________________add all listeners
        nextButton.setOnAction((event) -> {
            outputText.getStyleClass().clear();
            outputText.setText(nextButtonController.startController());
            outputText.getStyleClass().add(colorController.selectTextColor());
        });
        previousButton.setOnAction((event) -> {
            outputText.getStyleClass().clear();
            outputText.setText(previousButtonController.startController());
            outputText.getStyleClass().add(colorController.selectTextColor());
        });
        questionButton.setOnAction((event) -> outputText.setText(questionButtonController.startController()));
        answerButton.setOnAction((event) -> outputText.setText(answerButtonController.startController()));
        yesButton.setOnAction((event) -> {
            outputText.getStyleClass().clear();
            resultIndicator.getStyleClass().add(colorController.selectIndicatorColor(generalDependence.getCountingResult().getTotalResult()));
            resultIndicator.setProgress(generalDependence.getCountingResult().counting());
            yesButtonController.setYes();
            outputText.getStyleClass().add(colorController.selectTextColor());
        });
        noButton.setOnAction(event -> {
            outputText.getStyleClass().clear();
            resultIndicator.getStyleClass().add(colorController.selectIndicatorColor(generalDependence.getCountingResult().getTotalResult()));
            resultIndicator.setProgress(generalDependence.getCountingResult().counting());
            noButtonController.setNo();
            outputText.getStyleClass().add(colorController.selectTextColor());
        });
        saveButton.setOnAction(event -> saveController.startController());

        backButton.setOnAction(event -> {
            secondWindow.close();
            generalDependence.getDBWorker().getBufferList().clear();
            resultIndicator.setProgress(generalDependence.getCountingResult().resetResult());
            firstWindow.startWindow(this);
        });

        mainPane.setTop(topDecorPane);
        mainPane.setLeft(leftVBox);
        mainPane.setRight(rightVBox);
        mainPane.setBottom(bottomDecorPane);
        mainPane.setCenter(outputText);
        BorderPane.setMargin(outputText, margin);
        BorderPane.setMargin(rightVBox, new Insets(INTERVAL, INTERVAL, INTERVAL, LEFT_INTERVAL_RIGHT_VBOX));

        Scene secondWindowScene = new Scene(mainPane, PREF_WINDOWS_WIDTH, PREF_WINDOWS_HEIGHT);
        secondWindowScene.getStylesheets().add(stylesheet);
        secondWindow.setMinWidth(MIN_WINDOW_WIDTH);
        secondWindow.setMinHeight(MIN_WINDOW_HEIGHT);
        secondWindow.setScene(secondWindowScene);
        secondWindow.getIcons().add(new Image(WIN_ICON));
        secondWindow.show();
    }

    public ProgressIndicator getResultIndicator() {
        return resultIndicator;
    }
}