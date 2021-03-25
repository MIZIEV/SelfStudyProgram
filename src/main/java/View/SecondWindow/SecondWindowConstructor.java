package View.SecondWindow;

import View.ButtonsDependence;
import View.buttonsPatterns.ButtonsPattern;
import View.OutputText;
import javafx.scene.effect.*;
import javafx.scene.paint.*;

public class SecondWindowConstructor {

    private final ButtonsDependence dependence;
    private final OutputText outputText;

    private final ButtonsPattern startButton = new ButtonsPattern(15, 50, 135, 50, "Start");
    private final ButtonsPattern nextButton = new ButtonsPattern(90, 110, 60, 50, "-->");
    private final ButtonsPattern previousButton = new ButtonsPattern(15, 110, 60, 50, "<--");
    private final ButtonsPattern questionButton = new ButtonsPattern(15, 640, 135, 50, "Question");
    private final ButtonsPattern answerButton = new ButtonsPattern(15, 700, 135, 50, "Answer");
    private final ButtonsPattern yesButton = new ButtonsPattern(885, 360, 135, 135, "✓");

    public SecondWindowConstructor(OutputText output, ButtonsDependence dependence) {

        this.dependence = dependence;
        this.outputText = output;

        nextButton.setDisable(true);
        previousButton.setDisable(true);
        questionButton.setDisable(true);
        answerButton.setDisable(true);
        yesButton.setDisable(true);

        startButton.setOnAction((event) -> {
            output.setText(dependence.getStartButtonController().getTextFromList());
            startButton.setDisable(true);
            nextButton.setDisable(false);
            previousButton.setDisable(false);
            questionButton.setDisable(false);
            answerButton.setDisable(false);
            yesButton.setDisable(false);
        });

        nextButton.setOnAction((event) -> output.setText(dependence.getNextButtonController().scrollText()));
        previousButton.setOnAction((event) -> output.setText(dependence.getPreviousButtonController().scrollText()));
        questionButton.setOnAction((event) -> output.setText(dependence.getQuestionButtonController().getRandomQuestion()));
        answerButton.setOnAction((event) -> output.setText(dependence.getAnswerButtonController().getAnswer()));

        InnerShadow greenEffect = new InnerShadow(20.0, Color.GREEN);

        yesButton.setEffect(greenEffect);
        yesButton.setOnAction((event) -> dependence.getYesButtonController().setYesNo());

    }

    public ButtonsPattern getStartButton() { return startButton; }

    public ButtonsPattern getNextButton() { return nextButton; }

    public ButtonsPattern getPreviousButton() { return previousButton; }

    public ButtonsPattern getQuestionButton() { return questionButton; }

    public ButtonsPattern getAnswerButton() { return answerButton; }

    public ButtonsPattern getYesButton() { return yesButton; }
}