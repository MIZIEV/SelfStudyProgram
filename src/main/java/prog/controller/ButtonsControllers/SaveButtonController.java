package prog.controller.ButtonsControllers;

import prog.model.MainModel;

public class SaveButtonController {

    private final MainModel model;

    public SaveButtonController(MainModel model) {
        this.model = model;
    }

    public void saveInfoToFile() {
        model.getFileWorker().putInfoToFile(model.getDBWorker().getBufferList(), model.getCountingResult(),
                model.getJsonWorker().convertToJSON(model.getDBWorker().getBufferList()));
    }
}