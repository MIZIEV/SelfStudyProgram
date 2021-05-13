package View.SecondWindow;

import Controller.ButtonsControllers.*;
import Model.*;
import View.ButtonsDependence;
import View.GeneralDependence;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
    private final static short PREF_DECORATED_PANE_WIDTH = 1024;
    private final static short PREF_DECORATED_PANE_HEIGHT = 70;
    private final static short PREF_LEFT_VBOX_WIDTH = 200;
    private final static short PREF_LEFT_VBOX_HEIGHT = 630;
    private final static short PREF_LEFT_BOTTOM_VBOX_HEIGHT = 315;
    private final static byte LEFT_INTERVAL_RIGHT_VBOX = 0;
    private final static byte CENTER_HBOX_INTERVAL = 15;
    private final static byte INTERVAL = 10;

    public SecondWindow(GeneralDependence genDependence) {
        this.generalDependence = genDependence;
    }

    public void startWin() {
        Insets margin = new Insets(INTERVAL);

        String stylesheet = getClass().getResource("/SecondStyle.css").toExternalForm();
        generalDependence.getOutputText().setWrapText(true);

        CountingResult countingResult = new CountingResult(generalDependence.getWorker(), generalDependence.getDigit());

        StartButtonController startButtonController = new StartButtonController(generalDependence.getWorker(), generalDependence.getDigit());
        NextButtonController nextButtonController = new NextButtonController(generalDependence.getWorker(), generalDependence.getDigit());
        PreviousButtonController previousButtonController = new PreviousButtonController(generalDependence.getWorker(), generalDependence.getDigit());
        QuestionButtonController questionButtonController = new QuestionButtonController(generalDependence.getWorker(), generalDependence.getDigit());
        AnswerButtonController answerButtonController = new AnswerButtonController(generalDependence.getWorker(), generalDependence.getDigit());
        YesButtonController yesButtonController = new YesButtonController(generalDependence.getWorker(), generalDependence.getDigit(), generalDependence.getResultMassage(), countingResult);

        ButtonsDependence dependence = new ButtonsDependence(startButtonController, nextButtonController,
                previousButtonController, questionButtonController, answerButtonController,
                yesButtonController);

        SecondWinButtonsCollection constructor = new SecondWinButtonsCollection(generalDependence.getOutputText(), dependence);

        BorderPane generalPane = new BorderPane();                    //create general pane
        BorderPane topPane = new BorderPane();
        BorderPane bottomPane = new BorderPane();

        topPane.setPrefSize(PREF_DECORATED_PANE_WIDTH, PREF_DECORATED_PANE_HEIGHT);     // set decorate top & bottom panel
        topPane.getStyleClass().add("top-border-pane");
        bottomPane.setPrefSize(PREF_DECORATED_PANE_WIDTH, PREF_DECORATED_PANE_HEIGHT);
        bottomPane.getStyleClass().add("bottom-border-pane");

        VBox leftVBox = new VBox(INTERVAL);                           // set left part without buttons
        leftVBox.setPrefSize(PREF_LEFT_VBOX_WIDTH, PREF_LEFT_VBOX_HEIGHT);
        leftVBox.setPadding(margin);
        HBox topHBox = new HBox(INTERVAL);
        HBox centerHBox = new HBox(CENTER_HBOX_INTERVAL);
        VBox bottomVBox = new VBox(INTERVAL);
        bottomVBox.setPrefSize(PREF_LEFT_VBOX_WIDTH, PREF_LEFT_BOTTOM_VBOX_HEIGHT);

        topHBox.setAlignment(Pos.CENTER);                            // set buttons in left VBOX
        topHBox.getChildren().addAll(constructor.getStartButton());
        centerHBox.setAlignment(Pos.CENTER);
        centerHBox.getChildren().addAll(constructor.getPreviousButton(), constructor.getNextButton());
        bottomVBox.setAlignment(Pos.BOTTOM_CENTER);
        bottomVBox.getChildren().addAll(constructor.getQuestionButton(), constructor.getAnswerButton());
        leftVBox.getChildren().addAll(topHBox, centerHBox, bottomVBox);

        VBox rightVBox = new VBox(INTERVAL);
        rightVBox.setAlignment(Pos.TOP_CENTER);
        rightVBox.getChildren().addAll(generalDependence.getResultMassage(), constructor.getYesButton());

        generalPane.setTop(topPane);
        generalPane.setBottom(bottomPane);
        generalPane.setCenter(generalDependence.getOutputText());
        BorderPane.setMargin(generalDependence.getOutputText(), margin);
        generalPane.setLeft(leftVBox);
        generalPane.setRight(rightVBox);
        BorderPane.setMargin(rightVBox, new Insets(INTERVAL, INTERVAL, INTERVAL, LEFT_INTERVAL_RIGHT_VBOX));

        Scene secondWindowScene = new Scene(generalPane, PREF_WINDOWS_WIDTH, PREF_WINDOWS_HEIGHT);
        secondWindowScene.getStylesheets().add(stylesheet);
        secondWindow.setMinWidth(MIN_WINDOW_WIDTH);
        secondWindow.setMinHeight(MIN_WINDOW_HEIGHT);
        secondWindow.setScene(secondWindowScene);
        secondWindow.getIcons().add(new Image("icon.jpg"));
        secondWindow.show();
    }
}