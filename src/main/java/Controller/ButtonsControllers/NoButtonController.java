package Controller.ButtonsControllers;

import View.ProgramModel;

public class NoButtonController {

    private final ProgramModel model;

    public NoButtonController(ProgramModel model) {
        this.model=model;
    }

    public void setNo() {
        int index = model.getListIndex().getIndex();
        if (model.getDBWorker().getBufferList().get(index).getYesNo() == 0)
            model.getDBWorker().getBufferList().get(index).setYesNo(-1);
    }
}