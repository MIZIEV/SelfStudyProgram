package Controller.ButtonsControllers;

import Model.ListIndex;
import Model.DBWorker;

public class PreviousButtonController implements Changer {
    private final DBWorker worker;
    private final ListIndex listIndex;

    public PreviousButtonController(DBWorker work, ListIndex count) {
        this.worker = work;
        this.listIndex = count;
    }

    @Override
    public String startController() {
        int textCounter = listIndex.getIndex();
//todo придумать заменитель "error messege"!!!!!
        if (textCounter <= 0) {
            textCounter = 0;
        } else textCounter--;

        listIndex.setIndex(textCounter);
        return worker.getBufferList().get(textCounter).getIndex() + " - " +
                worker.getBufferList().get(textCounter).getTheme() + ": " + "\n" +
                worker.getBufferList().get(textCounter).getQuestion();
    }
}