package Controller.ButtonsControllers;

import View.ProgramModel;

public class YesButtonController {

    private final ProgramModel model;

    public YesButtonController(ProgramModel model) {

        this.model=model;
    }

    public void setYes() {
        int count = model.getListIndex().getIndex();
        if (model.getDBWorker().getBufferList().get(count).getYesNo() == 0)
            model.getDBWorker().getBufferList().get(count).setYesNo(1);
    }
}