import Controller.*;
import DataBase.*;
import View.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage myStage) {
        OutputText outputText = new OutputText();
        ResultMassage resultMassage = new ResultMassage();
        ErrorMessage errorMessage = new ErrorMessage();
        outputText.setWrapText(true);

        outputText.setStyle("-fx-font-size: 16px;");
        errorMessage.setStyle("-fx-text-inner-color: red; -fx-font-size: 20px;");

        Counter digit = new Counter();
        ResultCount resultCount = new ResultCount();
        DBWorker worker = new DBWorker();
        CountingResult countingResult = new CountingResult(worker, resultCount);

        StartButtonController startButtonController = new StartButtonController(worker, digit);
        NextButtonController nextButtonController = new NextButtonController(worker, digit,errorMessage);
        PreviousButtonController previousButtonController = new PreviousButtonController(worker, digit,errorMessage);
        QuestionButtonController questionButtonController = new QuestionButtonController(worker, digit);
        AnswerButtonController answerButtonController = new AnswerButtonController(worker, digit);
        YesButtonController yesButtonController = new YesButtonController(worker, digit, resultMassage, countingResult);
        NoButtonController noButtonController = new NoButtonController(worker, digit);

        ButtonsDependence dependence = new ButtonsDependence(startButtonController, nextButtonController,
                previousButtonController, questionButtonController, answerButtonController,
                yesButtonController, noButtonController);

        VisualConstructor constructor = new VisualConstructor(outputText, errorMessage, dependence);

        myStage.setTitle("Self study program");
        Pane rootNode = new Pane();
        Scene myScene = new Scene(rootNode, 1024, 768);
        myStage.setResizable(false);
        myStage.setScene(myScene);

        rootNode.getChildren().addAll(constructor.getStartButton(), constructor.getNextButton(),
                constructor.getPreviousButton(), constructor.getQuestionButton(),
                constructor.getAnswerButton(), constructor.getYesButton(), constructor.getNoButton(),
                outputText, resultMassage, errorMessage);

        myStage.show();
    }
}