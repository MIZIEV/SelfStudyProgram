package View.SecondWindow;

import View.ButtonsDependence;
import View.buttonsPatterns.ButtonsPattern;
import View.OutputText;

public class SecondWinButtonsCollection {

    private final static short PREF_HEIGHT = 50;
    private final static short PREF_WIDTH_SMALL = 60;
    private final static short PREF_WIDTH_STANDARD = 140;
    private final static short PREF_WIDTH_YESBUTTON = 180;
    private final static short PREF_HEIGHT_YESBUTTON = 140;

    private final ButtonsDependence dependence;
    private final OutputText outputText;

    private final ButtonsPattern startButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Start");
    private final ButtonsPattern nextButton = new ButtonsPattern(PREF_WIDTH_SMALL, PREF_HEIGHT, "→");
    private final ButtonsPattern previousButton = new ButtonsPattern(PREF_WIDTH_SMALL, PREF_HEIGHT, "←");
    private final ButtonsPattern questionButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Random question");
    private final ButtonsPattern answerButton = new ButtonsPattern(PREF_WIDTH_STANDARD, PREF_HEIGHT, "Answer");
    private final ButtonsPattern yesButton = new ButtonsPattern(PREF_WIDTH_YESBUTTON, PREF_HEIGHT_YESBUTTON, "✓");

    public SecondWinButtonsCollection(OutputText output, ButtonsDependence dependence) {

        this.dependence = dependence;
        this.outputText = output;

        nextButton.setDisable(true);
        previousButton.setDisable(true);
        questionButton.setDisable(true);
        answerButton.setDisable(true);
        yesButton.setDisable(true);
                                                              // add listeners to all buttons
        startButton.getStyleClass().add("start-button-button");
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

        yesButton.getStyleClass().add("yes-button-button");
        yesButton.setOnAction((event) -> dependence.getYesButtonController().setYesNo());
    }

    public ButtonsPattern getStartButton() { return startButton; }

    public ButtonsPattern getNextButton() { return nextButton; }

    public ButtonsPattern getPreviousButton() { return previousButton; }

    public ButtonsPattern getQuestionButton() { return questionButton; }

    public ButtonsPattern getAnswerButton() { return answerButton; }

    public ButtonsPattern getYesButton() { return yesButton; }
}