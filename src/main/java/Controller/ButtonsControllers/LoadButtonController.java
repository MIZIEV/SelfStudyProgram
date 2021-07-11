package Controller.ButtonsControllers;

import Model.DBWorker;
import Model.FileWorker;
import Model.JSONWorker;

public class LoadButtonController {
    private final DBWorker worker;
    private final JSONWorker jsonWorker;
    private final FileWorker fileWorker;

    public LoadButtonController(DBWorker worker, JSONWorker jsonWorker, FileWorker fileWorker) {
        this.worker = worker;
        this.jsonWorker = jsonWorker;
        this.fileWorker = fileWorker;
    }

    public void startController(String fileName) {
        worker.getBufferList().addAll(jsonWorker.convertFromJSON(fileWorker.getFile(fileName)));
    }
}