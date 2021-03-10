package View;

import Controller.*;

public class ButtonsDependence {

    private final StartButtonController startButtonController;
    private final NextButtonController nextButtonController;
    private final PreviousButtonController previousButtonController;
    private final QuestionButtonController questionButtonController;
    private final AnswerButtonController answerButtonController;
    private final YesButtonController yesButtonController;
    private final NoButtonController noButtonController;

    public ButtonsDependence(StartButtonController startController, NextButtonController nextController,
                             PreviousButtonController previousController, QuestionButtonController questionController,
                             AnswerButtonController answerController, YesButtonController yesController,
                             NoButtonController noController) {

        this.startButtonController = startController;
        this.nextButtonController = nextController;
        this.previousButtonController = previousController;
        this.questionButtonController = questionController;
        this.answerButtonController = answerController;
        this.yesButtonController = yesController;
        this.noButtonController = noController;
    }

    public StartButtonController getStartButtonController() {
        return startButtonController;
    }

    public NextButtonController getNextButtonController() {
        return nextButtonController;
    }

    public PreviousButtonController getPreviousButtonController() {
        return previousButtonController;
    }

    public QuestionButtonController getQuestionButtonController() {
        return questionButtonController;
    }

    public AnswerButtonController getAnswerButtonController() {
        return answerButtonController;
    }

    public YesButtonController getYesButtonController() {
        return yesButtonController;
    }

    public NoButtonController getNoButtonController() {
        return noButtonController;
    }
}