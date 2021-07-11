package Controller.ButtonsControllers;

import Model.DBWorker;
import Model.JSONWorker;

public class SaveButtonController {

    private final DBWorker worker;
    private final JSONWorker jsonWorker;

    public SaveButtonController(DBWorker worker, JSONWorker jsonWorker) {
        this.worker = worker;
        this.jsonWorker = jsonWorker;
    }

    public void startController() {
        jsonWorker.convertToJSON(worker.getBufferList());
    }
}
