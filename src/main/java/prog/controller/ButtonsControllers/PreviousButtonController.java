package prog.controller.ButtonsControllers;

import prog.model.MainModel;

public class PreviousButtonController {

    private final MainModel model;

    public PreviousButtonController(MainModel model) {
        this.model = model;
    }

    public String getPreviousQuestion() {
        int textCounter = model.getListIndex().getIndex();
        if (textCounter <= 0) {
            textCounter = 0;
        } else textCounter--;

        model.getListIndex().setIndex(textCounter);
        return model.getDBWorker().getBufferList().get(textCounter).getIndex() + " - " +
                model.getDBWorker().getBufferList().get(textCounter).getTheme() + ": " + "\n" +
                model.getDBWorker().getBufferList().get(textCounter).getQuestion();
    }
}