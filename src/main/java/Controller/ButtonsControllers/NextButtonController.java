package Controller.ButtonsControllers;

import Model.ListIndex;
import Model.DBWorker;

public class NextButtonController implements Changer {
    private final DBWorker worker;
    private final ListIndex listIndex;

    public NextButtonController(DBWorker work, ListIndex count) {
        this.worker = work;
        this.listIndex = count;
    }

    @Override
    public String startController() {
        int textCounter = listIndex.getIndex();
        if (textCounter >= worker.getBufferList().size() - 1) {
            textCounter = textCounter;

        } else textCounter++;

        listIndex.setIndex(textCounter);

        return worker.getBufferList().get(textCounter).getIndex() + " - " +
                worker.getBufferList().get(textCounter).getTheme() + ": " + "\n" +
                worker.getBufferList().get(textCounter).getQuestion();
    }
}