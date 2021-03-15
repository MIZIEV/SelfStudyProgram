package Controller.ButtonsControllers;

import DataBase.*;

public class AnswerButtonController {
    private final DBWorker worker;
    private final Counter counter;

    public AnswerButtonController(DBWorker work, Counter count) {
        this.worker = work;
        this.counter = count;
    }

    public String getAnswer() {
        int digit = counter.getDigit();

        return worker.getBufferList().get(digit).getIndex()+" - "+
                worker.getBufferList().get(digit).getTheme()+": "+"\n"+
                worker.getBufferList().get(digit).getAnswer();
    }
}