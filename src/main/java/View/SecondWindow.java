package View;

import Controller.ButtonsControllers.*;
import DataBase.CountingResult;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SecondWindow {

    private final GeneralDependence generalDependence;

    public SecondWindow(GeneralDependence genDependence){
        this.generalDependence=genDependence;
    }

    public void startWin() {

       /* OutputText outputText = new OutputText();
        ResultMassage resultMassage = new ResultMassage();
        ErrorMessage errorMessage = new ErrorMessage();*/
        /*outputText.setWrapText(true);
        outputText.setStyle("-fx-font-size: 16px;");
        errorMessage.setStyle("-fx-text-inner-color: red; -fx-font-size: 20px;");*/

        generalDependence.getOutputText().setWrapText(true);
        generalDependence.getOutputText().setStyle("-fx-font-size: 16px;");
        generalDependence.getErrorMessage().setStyle("-fx-text-inner-color: red; -fx-font-size: 20px;");

        CountingResult countingResult = new CountingResult(generalDependence.getWorker(), generalDependence.getResultCount());

        StartButtonController startButtonController = new StartButtonController(generalDependence.getWorker(), generalDependence.getDigit());
        NextButtonController nextButtonController = new NextButtonController(generalDependence.getWorker(), generalDependence.getDigit(),generalDependence.getErrorMessage()/*errorMessage*/);
        PreviousButtonController previousButtonController = new PreviousButtonController(generalDependence.getWorker(), generalDependence.getDigit(),generalDependence.getErrorMessage()/*errorMessage*/);
        QuestionButtonController questionButtonController = new QuestionButtonController(generalDependence.getWorker(), generalDependence.getDigit());
        AnswerButtonController answerButtonController = new AnswerButtonController(generalDependence.getWorker(), generalDependence.getDigit());
        YesButtonController yesButtonController = new YesButtonController(generalDependence.getWorker(), generalDependence.getDigit(), generalDependence.getResultMassage()/*resultMassage*/, countingResult);
        NoButtonController noButtonController = new NoButtonController(generalDependence.getWorker(), generalDependence.getDigit());

        ButtonsDependence dependence = new ButtonsDependence(startButtonController, nextButtonController,
                previousButtonController, questionButtonController, answerButtonController,
                yesButtonController, noButtonController);

        SecondWindowConstructor constructor = new SecondWindowConstructor(/*outputText, errorMessage,*/
                generalDependence.getOutputText(),generalDependence.getErrorMessage(),dependence);
        Stage myStage = new Stage();

        myStage.setTitle("Self study program");
        Pane rootNode = new Pane();
        Scene myScene = new Scene(rootNode, 1024, 768);
        myStage.setResizable(false);
        myStage.setScene(myScene);

        rootNode.getChildren().addAll(constructor.getStartButton(), constructor.getNextButton(),
                constructor.getPreviousButton(), constructor.getQuestionButton(),
                constructor.getAnswerButton(), constructor.getYesButton(), constructor.getNoButton(),
                generalDependence.getOutputText(),generalDependence.getResultMassage(),generalDependence.getErrorMessage()
                /*outputText, resultMassage, errorMessage*/);

        myStage.show();
    }
}