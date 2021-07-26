package prog.controller.ButtonsControllers;


import prog.model.MainModel;

public class NextButtonController {

    private final MainModel model;

    public NextButtonController(MainModel model) {
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