package Controller.ButtonsControllers;

import View.ProgramModel;

public class StartButtonController {

    private final ProgramModel model;

    public StartButtonController(ProgramModel model) {
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