import DataBase.DBWorker;
import DataBase.RandomDigit;
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
        DBWorker worker = new DBWorker();
        RandomDigit digit = new RandomDigit();

        OutputText outputText = new OutputText();
        ResultMassage resultMassage = new ResultMassage();
        ErrorMassage errorMassage = new ErrorMassage();

        StartButton startButton = new StartButton(outputText, worker.getQAList(), digit);

        NextButton nextButton = new NextButton(outputText, worker.getQAList(), digit, errorMassage);
        PreviousButton previousButton = new PreviousButton(outputText, worker.getQAList(), digit, errorMassage);

        QuestionButton questionButton = new QuestionButton(outputText, worker.getQAList(), digit);
        AnswerButton answerButton = new AnswerButton(outputText, worker.getQAList(), digit);

        startButton.buttonAction();
        nextButton.buttonAction();
        questionButton.buttonAction();
        previousButton.buttonAction();
        answerButton.buttonAction();

        myStage.setTitle("Self study program");
        Pane rootNode = new Pane();
        Scene myScene = new Scene(rootNode, 1024, 768);
        myStage.setResizable(false);
        myStage.setScene(myScene);

        rootNode.getChildren().addAll(startButton, nextButton, previousButton, questionButton, answerButton,
                outputText, resultMassage, errorMassage);
        myStage.show();
    }
}