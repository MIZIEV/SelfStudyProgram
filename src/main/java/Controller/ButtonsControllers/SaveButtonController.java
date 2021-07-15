package Controller.ButtonsControllers;

import View.ProgramModel;

public class SaveButtonController {

    private final ProgramModel model;

    public SaveButtonController(ProgramModel model) {
        this.model = model;
    }

    public void saveInfoToFile() {
        model.getFileWorker().putInfoToFile(model.getDBWorker().getBufferList(), model.getCountingResult(),
                model.getJsonWorker().convertToJSON(model.getDBWorker().getBufferList()));
    }
}