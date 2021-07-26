package prog.controller.ButtonsControllers;

import prog.model.InfoFromDB;
import prog.model.MainModel;

public class BackButtonController {

    private final MainModel model;

    public BackButtonController(MainModel model) {
        this.model = model;
    }

    public void setDefaultVarInList() {
        for (InfoFromDB element : model.getDBWorker().getBufferList()) {
            element.setYesNo(0);
        }
    }
}