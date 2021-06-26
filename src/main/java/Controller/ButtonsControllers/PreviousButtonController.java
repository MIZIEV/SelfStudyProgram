package Controller.ButtonsControllers;

import Model.Counter;
import Model.DBWorker;

public class PreviousButtonController implements Changer {
    private final DBWorker worker;
    private final Counter counter;

    public PreviousButtonController(DBWorker work, Counter count) {
        this.worker = work;
        this.counter = count;
    }

    @Override
    public String changeQuestion() {
        int textCounter = counter.getDigit();
//todo придумать заменитель "error messege"!!!!!
        if (textCounter <= 0) {
            textCounter = 0;
        } else textCounter--;

        counter.setDigit(textCounter);
        return worker.getBufferList().get(textCounter).getIndex() + " - " +
                worker.getBufferList().get(textCounter).getTheme() + ": " + "\n" +
                worker.getBufferList().get(textCounter).getQuestion();
    }
}