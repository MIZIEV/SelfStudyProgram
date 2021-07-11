package Controller.ButtonsControllers;

import Model.DBWorker;
import Model.ListIndex;

public class NoButtonController {

    private final DBWorker worker;
    private final ListIndex listIndex;

    public NoButtonController(DBWorker work, ListIndex count) {
        this.listIndex = count;
        this.worker = work;
    }

    public void setNo() {
        int index = listIndex.getIndex();
        if (worker.getBufferList().get(index).getYesNo() == 0)
            worker.getBufferList().get(index).setYesNo(-1);
    }
}