package Controller.ButtonsControllers;


import View.ProgramModel;

public class NextButtonController {

    private final ProgramModel model;

    public NextButtonController(ProgramModel model) {
        this.model = model;
    }

    public String getNextQuestion() {
        int textCounter = model.getListIndex().getIndex();
        if (textCounter >= model.getDBWorker().getBufferList().size() - 1) {
            textCounter = textCounter;

        } else textCounter++;

        model.getListIndex().setIndex(textCounter);

        return model.getDBWorker().getBufferList().get(textCounter).getIndex() + " - " +
                model.getDBWorker().getBufferList().get(textCounter).getTheme() + ": " + "\n" +
                model.getDBWorker().getBufferList().get(textCounter).getQuestion();
    }
}