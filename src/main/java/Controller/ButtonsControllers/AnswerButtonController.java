package Controller.ButtonsControllers;

import View.ProgramModel;

public class AnswerButtonController {

    private final ProgramModel model;

    public AnswerButtonController(ProgramModel model) {
        this.model = model;
    }

    public String getAnswer() {
        int digit = model.getListIndex().getIndex();

        return model.getDBWorker().getBufferList().get(digit).getIndex() + " - " +
                model.getDBWorker().getBufferList().get(digit).getTheme() + ": " + "\n" +
                model.getDBWorker().getBufferList().get(digit).getAnswer();
    }
}