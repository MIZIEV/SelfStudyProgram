package Controller.ButtonsControllers;

import View.ProgramModel;

public class LoadButtonController {

    private final ProgramModel model;

    public LoadButtonController(ProgramModel model) {
        this.model=model;
    }

    public void loadSavedFile(String fileName) {
        model.getDBWorker().getBufferList().
                addAll(model.getJsonWorker().convertFromJSON(model.getFileWorker().getFile(fileName)));
    }
}