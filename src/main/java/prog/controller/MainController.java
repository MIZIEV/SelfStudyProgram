package prog.controller;

import prog.controller.ButtonsControllers.*;
import prog.model.MainModel;

public class MainController {
    private final MainModel mainModel;

    private ColorController colorController;
    private StartButtonController startButtonController;
    private NextButtonController nextButtonController;
    private PreviousButtonController previousButtonController;
    private QuestionButtonController questionButtonController;
    private AnswerButtonController answerButtonController;
    private YesButtonController yesButtonController;
    private NoButtonController noButtonController;
    private SaveButtonController saveController;
    private BackButtonController backController;

    public MainController(MainModel model) {
        this.mainModel = model;
        colorController = new ColorController(mainModel);
        startButtonController = new StartButtonController(mainModel);
        nextButtonController = new NextButtonController(mainModel);
        previousButtonController = new PreviousButtonController(mainModel);
        questionButtonController = new QuestionButtonController(mainModel);
        answerButtonController = new AnswerButtonController(mainModel);
        yesButtonController = new YesButtonController(mainModel);
        noButtonController = new NoButtonController(mainModel);
        saveController = new SaveButtonController(mainModel);
        backController=new BackButtonController(mainModel);
    }

    public ColorController getColorController() { return colorController; }

    public StartButtonController getStartButtonController() { return startButtonController; }

    public NextButtonController getNextButtonController() { return nextButtonController; }

    public PreviousButtonController getPreviousButtonController() { return previousButtonController; }

    public QuestionButtonController getQuestionButtonController() { return questionButtonController; }

    public AnswerButtonController getAnswerButtonController() { return answerButtonController; }

    public YesButtonController getYesButtonController() { return yesButtonController; }

    public NoButtonController getNoButtonController() { return noButtonController; }

    public SaveButtonController getSaveController() { return saveController; }

    public BackButtonController getBackController() { return backController; }
}