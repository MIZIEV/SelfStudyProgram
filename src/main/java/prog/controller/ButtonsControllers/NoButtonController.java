package prog.controller.ButtonsControllers;

import prog.model.MainModel;

public class NoButtonController {

    private final MainModel model;

    public NoButtonController(MainModel model) {
        this.model=model;
    }

    public void setNo() {
        int index = model.getListIndex().getIndex();
        if (model.getDBWorker().getBufferList().get(index).getYesNo() == 0)
            model.getDBWorker().getBufferList().get(index).setYesNo(-1);
    }
}