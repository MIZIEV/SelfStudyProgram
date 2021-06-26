package Controller.ButtonsControllers;

import Model.*;

public class AnswerButtonController implements Changer{
    private final DBWorker worker;
    private final Counter counter;

    public AnswerButtonController(DBWorker work, Counter count) {
        this.worker = work;
        this.counter = count;
    }
@Override
    public String startController() {
        int digit = counter.getDigit();

        return worker.getBufferList().get(digit).getIndex()+" - "+
                worker.getBufferList().get(digit).getTheme()+": "+"\n"+
                worker.getBufferList().get(digit).getAnswer();
    }
}