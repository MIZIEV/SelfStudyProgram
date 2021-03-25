package Controller.ButtonsControllers;

import Model.Counter;
import Model.DBWorker;

public class NextButtonController {
    private final DBWorker worker;
    private final Counter counter;

    public NextButtonController(DBWorker work, Counter count) {
        this.worker = work;
        this.counter = count;
    }

    public String scrollText() {
        int textCounter = counter.getDigit();
//todo придумать заменитель "error messege"!!!!!
        if (textCounter >= worker.getBufferList().size() - 1) {
            textCounter = textCounter;


        } else textCounter++;

        counter.setDigit(textCounter);

        return worker.getBufferList().get(textCounter).getIndex() + " - " +
                worker.getBufferList().get(textCounter).getTheme() + ": " + "\n" +
                worker.getBufferList().get(textCounter).getQuestion();
    }
}