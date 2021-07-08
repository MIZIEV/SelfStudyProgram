package Controller.ButtonsControllers;

import Model.*;

public class AnswerButtonController implements Changer{
    private final DBWorker worker;
    private final ListIndex listIndex;

    public AnswerButtonController(DBWorker work, ListIndex count) {
        this.worker = work;
        this.listIndex = count;
    }
@Override
    public String startController() {
        int digit = listIndex.getIndex();

        return worker.getBufferList().get(digit).getIndex()+" - "+
                worker.getBufferList().get(digit).getTheme()+": "+"\n"+
                worker.getBufferList().get(digit).getAnswer();
    }
}