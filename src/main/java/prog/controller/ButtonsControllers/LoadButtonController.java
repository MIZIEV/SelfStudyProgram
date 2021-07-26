package prog.controller.ButtonsControllers;

import prog.model.MainModel;

public class LoadButtonController {

    private final MainModel model;

    public LoadButtonController(MainModel model) {
        this.model=model;
    }

    public void loadSavedFile(String fileName) {
        model.getDBWorker().getBufferList().
                addAll(model.getJsonWorker().convertFromJSON(model.getFileWorker().getFile(fileName)));
    }
}