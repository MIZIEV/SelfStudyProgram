package Controller.ButtonsControllers;

import Model.*;

public class YesButtonController {

    private final DBWorker worker;
    private final ListIndex listIndex;

    public YesButtonController(DBWorker work, ListIndex count) {

        this.listIndex = count;
        this.worker = work;
    }

    public void setYes() {
        System.out.println(worker.getBufferList());
        int count = listIndex.getIndex();
        if (worker.getBufferList().get(count).getYesNo() == 0)
            worker.getBufferList().get(count).setYesNo(1);
    }
}