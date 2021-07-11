package View;

import Controller.ButtonsControllers.*;
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
    private final static short PREF_WINDOWS_WIDTH = 1024;
    private final static short PREF_WINDOWS_HEIGHT = 768;

    private final static byte INTERVAL = 10;
    private final static byte RIGHT_VBOX_INTERVAL = 50;

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

    private final static String STYLE_FILE = "/Styles/SecondStyle.css";
    private final static String WIN_ICON = "icon.jpg";
    private final static String TOP_DECOR_PANE_STYLE = "top-border-pane";
    private final static String BOTTOM_DECOR_PANE_STYLE = "bottom-border-pane";
    private final static String START_BUTTON_STYLE = "start-button";
    private final static String YES_BUTTON_STYLE = "yes-button";

    public SecondWindow(FirstWindow firstW, GeneralDependence genDependence) {

        this.generalDependence = genDependence;
        this.firstWindow = firstW;
    }

    public void startWin() {
        Stage secondWindow = new Stage();
        Insets margin = new Insets(INTERVAL);
        String stylesheet = getClass().getResource(STYLE_FILE).toExternalForm();
        //_________________________________________create all buttons
        ButtonsPattern startButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Start");
        ButtonsPattern nextButton = new ButtonsPattern(PREF_WIDTH_SMALL, PREF_HEIGHT, "→");
        ButtonsPattern previousButton = new ButtonsPattern(PREF_WIDTH_SMALL, PREF_HEIGHT, "←");
        ButtonsPattern questionButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Random question");
        ButtonsPattern answerButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Answer");
        ButtonsPattern yesButton = new ButtonsPattern(PREF_WIDTH_YESBUTTON, PREF_HEIGHT_YESBUTTON, "✓");
        ButtonsPattern saveButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Save");
        ButtonsPattern backButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Back to main menu");
        //_________________________________________add buttons style
        startButton.getStyleClass().add(START_BUTTON_STYLE);
        yesButton.getStyleClass().add(YES_BUTTON_STYLE);
        //_________________________________________create all controllers
        Changer startButtonController = new StartButtonController(generalDependence.getDBWorker(), generalDependence.getListIndex());
        Changer nextButtonController = new NextButtonController(generalDependence.getDBWorker(), generalDependence.getListIndex());
        Changer previousButtonController = new PreviousButtonController(generalDependence.getDBWorker(), generalDependence.getListIndex());
        Changer questionButtonController = new QuestionButtonController(generalDependence.getDBWorker(), generalDependence.getListIndex());
        Changer answerButtonController = new AnswerButtonController(generalDependence.getDBWorker(), generalDependence.getListIndex());
        YesButtonController yesButtonController = new YesButtonController(generalDependence.getDBWorker(), generalDependence.getListIndex());
        SaveButtonController saveController = new SaveButtonController(generalDependence.getDBWorker(), generalDependence.getJsonWorker());
        //_________________________________________create main pane and all view elements
        BorderPane mainPane = new BorderPane();
        BorderPane topDecorPane = new BorderPane();
        BorderPane bottomDecorPane = new BorderPane();
        TextArea outputText = new TextArea();
        outputText.setWrapText(true);
        outputText.setEditable(false);
        resultIndicator.setPrefSize(PREF_WIDTH_INDICATOR, PREF_HEIGHT_INDICATOR);
        //_________________________________________set decorate top & bottom panel
        topDecorPane.setPrefSize(PREF_DECORATED_PANE_WIDTH, PREF_DECORATED_PANE_HEIGHT);
        topDecorPane.getStyleClass().add(TOP_DECOR_PANE_STYLE);
        bottomDecorPane.setPrefSize(PREF_DECORATED_PANE_WIDTH, PREF_DECORATED_PANE_HEIGHT);
        bottomDecorPane.getStyleClass().add(BOTTOM_DECOR_PANE_STYLE);
        //_________________________________________set left part without buttons
        VBox leftVBox = new VBox(INTERVAL);
        leftVBox.setPrefSize(PREF_LEFT_VBOX_WIDTH, PREF_LEFT_VBOX_HEIGHT);
        leftVBox.setPadding(margin);
        HBoxPattern topHBox = new HBoxPattern(Pos.CENTER, INTERVAL);
        HBoxPattern centerHBox = new HBoxPattern(Pos.CENTER, CENTER_HBOX_INTERVAL);
        VBoxPattern bottomVBox = new VBoxPattern(Pos.CENTER, INTERVAL);
        bottomVBox.setPrefSize(PREF_LEFT_VBOX_WIDTH, PREF_LEFT_BOTTOM_VBOX_HEIGHT);
        //_________________________________________set buttons in HBox & set this box to VBox
        topHBox.getChildren().addAll(startButton);
        centerHBox.getChildren().addAll(previousButton, nextButton);
        bottomVBox.getChildren().addAll(questionButton, answerButton, backButton);
        leftVBox.getChildren().addAll(topHBox, centerHBox, bottomVBox);
        //_________________________________________create right VBox & add all element
        VBoxPattern rightVBox = new VBoxPattern(Pos.CENTER,RIGHT_VBOX_INTERVAL);
        rightVBox.getChildren().addAll(resultIndicator, saveButton, yesButton);

        nextButton.setDisable(true);
        previousButton.setDisable(true);
        questionButton.setDisable(true);
        answerButton.setDisable(true);
        yesButton.setDisable(true);
        saveButton.setDisable(true);
        //_________________________________________add listeners to all buttons
        startButton.setOnAction((event) -> {
            outputText.setText(startButtonController.startController());
            startButton.setDisable(true);
            nextButton.setDisable(false);
            previousButton.setDisable(false);
            questionButton.setDisable(false);
            answerButton.setDisable(false);
            yesButton.setDisable(false);
            saveButton.setDisable(false);
        });
        //_________________________________________add all listeners
        nextButton.setOnAction((event) -> outputText.setText(nextButtonController.startController()));
        previousButton.setOnAction((event) -> outputText.setText(previousButtonController.startController()));
        questionButton.setOnAction((event) -> outputText.setText(questionButtonController.startController()));
        answerButton.setOnAction((event) -> outputText.setText(answerButtonController.startController()));
        yesButton.setOnAction((event) -> {
            resultIndicator.setProgress(generalDependence.getCountingResult().counting());
            yesButtonController.setYesNo();
        });
        saveButton.setOnAction(event -> saveController.startController());

        backButton.setOnAction(event -> {
            secondWindow.close();
            generalDependence.getDBWorker().getBufferList().clear();
            resultIndicator.setProgress(generalDependence.getCountingResult().resetResult());
            firstWindow.startWindow(this);
        });

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
    public ProgressIndicator getResultIndicator() {
        return resultIndicator;
    }
}