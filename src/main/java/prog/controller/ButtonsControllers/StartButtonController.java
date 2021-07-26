package prog.controller.ButtonsControllers;

import prog.model.MainModel;

public class StartButtonController {

    private final MainModel model;

    public StartButtonController(MainModel model) {
        this.model=model;
    }

    public String startLearning() {
        int startDigit = 0;
        model.getListIndex().setIndex(startDigit);

        return model.getDBWorker().getBufferList().get(startDigit).getIndex() + " - " +
                model.getDBWorker().getBufferList().get(startDigit).getTheme() + ": " + "\n" +
                model.getDBWorker().getBufferList().get(startDigit).getQuestion();
    }
}