package prog.controller.ButtonsControllers;

import prog.model.MainModel;

public class AnswerButtonController {

    private final MainModel model;

    public AnswerButtonController(MainModel model) {
        this.model = model;
    }

    public String getAnswer() {
        int digit = model.getListIndex().getIndex();

        return model.getDBWorker().getBufferList().get(digit).getIndex() + " - " +
                model.getDBWorker().getBufferList().get(digit).getTheme() + ": " + "\n" +
                model.getDBWorker().getBufferList().get(digit).getAnswer();
    }
}