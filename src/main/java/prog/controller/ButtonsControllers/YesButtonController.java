package prog.controller.ButtonsControllers;

import prog.model.MainModel;

public class YesButtonController {

    private final MainModel model;

    public YesButtonController(MainModel model) {

        this.model=model;
    }

    public void setYes() {
        int count = model.getListIndex().getIndex();
        if (model.getDBWorker().getBufferList().get(count).getYesNo() == 0)
            model.getDBWorker().getBufferList().get(count).setYesNo(1);
    }
}