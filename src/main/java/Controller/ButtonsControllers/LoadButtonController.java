package Controller.ButtonsControllers;

import Model.DBWorker;
import Model.JSONWorker;

public class LoadButtonController {
    private final DBWorker worker;
    private final JSONWorker jsonWorker;

    public LoadButtonController(DBWorker worker, JSONWorker jsonWorker) {
        this.worker = worker;
        this.jsonWorker = jsonWorker;
    }

    public void startController() {
        worker.getBufferList().addAll(jsonWorker.convertFromJSON());
    }
}