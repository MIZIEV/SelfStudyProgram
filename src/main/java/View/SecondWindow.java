package View;

import Controller.ButtonsControllers.*;
import Model.*;
import View.buttonsPatterns.ButtonsPattern;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SecondWindow {

    private Stage secondWindow = new Stage();
    private final GeneralDependence generalDependence;

    private final static short MIN_WINDOW_WIDTH = 800;
    private final static short MIN_WINDOW_HEIGHT = 600;
    private final static short PREF_WINDOWS_WIDTH = 1024;
    private final static short PREF_WINDOWS_HEIGHT = 768;

    private final static byte INTERVAL = 10;
    private final static byte LEFT_INTERVAL_RIGHT_VBOX = 0;
    private final static byte CENTER_HBOX_INTERVAL = 15;

    private final static short PREF_DECORATED_PANE_WIDTH = 1024;
    private final static short PREF_DECORATED_PANE_HEIGHT = 70;

    private final static short PREF_LEFT_VBOX_WIDTH = 200;
    private final static short PREF_LEFT_VBOX_HEIGHT = 630;
    private final static short PREF_LEFT_BOTTOM_VBOX_HEIGHT = 315;

    private final static short PREF_HEIGHT = 50;
    private final static short PREF_WIDTH_SMALL = 60;
    private final static short PREF_WIDTH_STANDARD = 140;
    private final static short PREF_WIDTH_YESBUTTON = 180;
    private final static short PREF_HEIGHT_YESBUTTON = 140;

    private final static short PREF_WIDTH_INDICATOR = 180;
    private final static short PREF_HEIGHT_INDICATOR = 140;

    private final static String WIN_ICON = "icon.jpg";
    private final static String TOP_DECOR_PANE_STYLE = "top-border-pane";
    private final static String BOTTOM_DECOR_PANE_STYLE = "bottom-border-pane";
    private final static String START_BUTTON_STYLE = "start-button";
    private final static String YES_BUTTON_STYLE = "yes-button";

    public SecondWindow(GeneralDependence genDependence) {
        this.generalDependence = genDependence;
    }

    public void startWin() {
        Insets margin = new Insets(INTERVAL);
        String stylesheet = getClass().getResource("/SecondStyle.css").toExternalForm();
        CountingResult countingResult = new CountingResult(generalDependence.getWorker(), generalDependence.getListIndex());
        //_________________________________________create all buttons
        ButtonsPattern startButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Start");
        ButtonsPattern nextButton = new ButtonsPattern(PREF_WIDTH_SMALL, PREF_HEIGHT, "→");
        ButtonsPattern previousButton = new ButtonsPattern(PREF_WIDTH_SMALL, PREF_HEIGHT, "←");
        ButtonsPattern questionButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Random question");
        ButtonsPattern answerButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Answer");
        ButtonsPattern yesButton = new ButtonsPattern(PREF_WIDTH_YESBUTTON, PREF_HEIGHT_YESBUTTON, "✓");
        //_________________________________________add buttons style
        startButton.getStyleClass().add(START_BUTTON_STYLE);
        yesButton.getStyleClass().add(YES_BUTTON_STYLE);
        //_________________________________________create all controllers
        Changer startButtonController = new StartButtonController(generalDependence.getWorker(), generalDependence.getListIndex());
        Changer nextButtonController = new NextButtonController(generalDependence.getWorker(), generalDependence.getListIndex());
        Changer previousButtonController = new PreviousButtonController(generalDependence.getWorker(), generalDependence.getListIndex());
        Changer questionButtonController = new QuestionButtonController(generalDependence.getWorker(), generalDependence.getListIndex());
        Changer answerButtonController = new AnswerButtonController(generalDependence.getWorker(), generalDependence.getListIndex());
        YesButtonController yesButtonController = new YesButtonController(generalDependence.getWorker(), generalDependence.getListIndex());
        //_________________________________________create main pane and all view elements
        BorderPane mainPane = new BorderPane();
        BorderPane topDecorPane = new BorderPane();
        BorderPane bottomDecorPane = new BorderPane();
        TextArea outputText = new TextArea();
        ProgressIndicator resultIndicator = new ProgressIndicator();
        resultIndicator.setPrefSize(PREF_WIDTH_INDICATOR,PREF_HEIGHT_INDICATOR);
        //_________________________________________set decorate top & bottom panel
        topDecorPane.setPrefSize(PREF_DECORATED_PANE_WIDTH, PREF_DECORATED_PANE_HEIGHT);
        topDecorPane.getStyleClass().add(TOP_DECOR_PANE_STYLE);
        bottomDecorPane.setPrefSize(PREF_DECORATED_PANE_WIDTH, PREF_DECORATED_PANE_HEIGHT);
        bottomDecorPane.getStyleClass().add(BOTTOM_DECOR_PANE_STYLE);
        //_________________________________________set left part without buttons
        VBox leftVBox = new VBox(INTERVAL);
        leftVBox.setPrefSize(PREF_LEFT_VBOX_WIDTH, PREF_LEFT_VBOX_HEIGHT);
        leftVBox.setPadding(margin);
        HBox topHBox = new HBox(INTERVAL);
        HBox centerHBox = new HBox(CENTER_HBOX_INTERVAL);
        VBox bottomVBox = new VBox(INTERVAL);
        bottomVBox.setPrefSize(PREF_LEFT_VBOX_WIDTH, PREF_LEFT_BOTTOM_VBOX_HEIGHT);
        //_________________________________________set buttons in HBox & set this box to VBox
        topHBox.setAlignment(Pos.CENTER);
        topHBox.getChildren().addAll(startButton);
        centerHBox.setAlignment(Pos.CENTER);
        centerHBox.getChildren().addAll(previousButton, nextButton);
        bottomVBox.setAlignment(Pos.BOTTOM_CENTER);
        bottomVBox.getChildren().addAll(questionButton, answerButton);
        leftVBox.getChildren().addAll(topHBox, centerHBox, bottomVBox);
        //_________________________________________create right VBox & add all element
        VBox rightVBox = new VBox(INTERVAL);
        rightVBox.setAlignment(Pos.TOP_CENTER);
        rightVBox.getChildren().addAll(resultIndicator, yesButton);

        nextButton.setDisable(true);
        previousButton.setDisable(true);
        questionButton.setDisable(true);
        answerButton.setDisable(true);
        yesButton.setDisable(true);
        //_________________________________________add listeners to all buttons
        startButton.setOnAction((event) -> {
            outputText.setText(startButtonController.startController());
            startButton.setDisable(true);
            nextButton.setDisable(false);
            previousButton.setDisable(false);
            questionButton.setDisable(false);
            answerButton.setDisable(false);
            yesButton.setDisable(false);
        });
        //_________________________________________add all listeners
        nextButton.setOnAction((event) -> outputText.setText(nextButtonController.startController()));
        previousButton.setOnAction((event) -> outputText.setText(previousButtonController.startController()));
        questionButton.setOnAction((event) -> outputText.setText(questionButtonController.startController()));
        answerButton.setOnAction((event) -> outputText.setText(answerButtonController.startController()));
        yesButton.setOnAction((event) -> {
            resultIndicator.setProgress(countingResult.counting());
            yesButtonController.setYesNo();
        });

        outputText.setWrapText(true);

        mainPane.setTop(topDecorPane);
        mainPane.setBottom(bottomDecorPane);
        mainPane.setCenter(outputText);
        BorderPane.setMargin(outputText, margin);
        mainPane.setLeft(leftVBox);
        mainPane.setRight(rightVBox);
        BorderPane.setMargin(rightVBox, new Insets(INTERVAL, INTERVAL, INTERVAL, LEFT_INTERVAL_RIGHT_VBOX));

        Scene secondWindowScene = new Scene(mainPane, PREF_WINDOWS_WIDTH, PREF_WINDOWS_HEIGHT);
        secondWindowScene.getStylesheets().add(stylesheet);
        secondWindow.setMinWidth(MIN_WINDOW_WIDTH);
        secondWindow.setMinHeight(MIN_WINDOW_HEIGHT);
        secondWindow.setScene(secondWindowScene);
        secondWindow.getIcons().add(new Image(WIN_ICON));
        secondWindow.show();
    }
}