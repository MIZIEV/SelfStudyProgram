package View.SecondWindow;

import Controller.ButtonsControllers.*;
import Model.*;
import View.ButtonsDependence;
import View.GeneralDependence;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SecondWindow {

    private Stage secondWindow = new Stage();
    private final GeneralDependence generalDependence;

    public SecondWindow(GeneralDependence genDependence) {
        this.generalDependence = genDependence;
    }

    public void startWin() {
        Insets margin = new Insets(10);

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

        SecondWindowConstructor constructor = new SecondWindowConstructor(generalDependence.getOutputText(), dependence);

        BorderPane generalPane = new BorderPane();
        BorderPane topPane = new BorderPane();
        BorderPane bottomPane = new BorderPane();

        topPane.setPrefSize(1024, 70);
        topPane.getStyleClass().add("top-border-pane");
        bottomPane.setPrefSize(1024, 70);
        bottomPane.getStyleClass().add("bottom-border-pane");

        VBox leftVBox = new VBox(10);
        leftVBox.setPrefSize(200,630);
        leftVBox.setPadding(margin);
        HBox topHBox = new HBox(10);
        HBox centerHBox = new HBox(15);
        VBox bottomVBox = new VBox(10);
        bottomVBox.setPrefSize(200,315);

        topHBox.setAlignment(Pos.CENTER);
        topHBox.getChildren().addAll(constructor.getStartButton());
        centerHBox.setAlignment(Pos.CENTER);
        centerHBox.getChildren().addAll(constructor.getPreviousButton(), constructor.getNextButton());
        bottomVBox.setAlignment(Pos.BOTTOM_CENTER);
        bottomVBox.getChildren().addAll(constructor.getQuestionButton(), constructor.getAnswerButton());
        leftVBox.getChildren().addAll(topHBox, centerHBox, bottomVBox);

        VBox rightVBox = new VBox(10);
        rightVBox.setAlignment(Pos.TOP_CENTER);
        rightVBox.getChildren().addAll(generalDependence.getResultMassage(), constructor.getYesButton());

        generalPane.setTop(topPane);
        generalPane.setBottom(bottomPane);
        generalPane.setCenter(generalDependence.getOutputText());
        BorderPane.setMargin(generalDependence.getOutputText(),margin);
        generalPane.setLeft(leftVBox);
        generalPane.setRight(rightVBox);
        BorderPane.setMargin(rightVBox,new Insets(10,10,10,0));

        Scene secondWindowScene = new Scene(generalPane, 1024, 768);
        secondWindowScene.getStylesheets().add(stylesheet);
        secondWindow.setScene(secondWindowScene);
        secondWindow.show();
    }
}