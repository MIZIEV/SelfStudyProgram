package Controller.ButtonsControllers;

import Model.JSONWorker;
import Model.ListIndex;
import Model.DBWorker;

public class StartButtonController implements Changer {

    private final DBWorker worker;
    private final ListIndex listIndex;

    public StartButtonController(DBWorker worker, ListIndex count) {
        this.worker = worker;
        this.listIndex = count;
    }

    @Override
    public String startController() {
        int startDigit = 0;
        listIndex.setIndex(startDigit);

        return worker.getBufferList().get(startDigit).getIndex() + " - " +
                worker.getBufferList().get(startDigit).getTheme() + ": " + "\n" +
                worker.getBufferList().get(startDigit).getQuestion();
    }
}