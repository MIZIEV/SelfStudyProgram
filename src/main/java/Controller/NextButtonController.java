package Controller;

import DataBase.Counter;
import DataBase.DBWorker;
import View.ErrorMessage;

public class NextButtonController {
    private final DBWorker worker;
    private final Counter counter;
    private final ErrorMessage errorMessage;

    public NextButtonController(DBWorker work, Counter count, ErrorMessage error) {
        this.errorMessage = error;
        this.worker = work;
        this.counter = count;
    }

    public String scrollText() {
        int textCounter = counter.getDigit();

        if (textCounter >= worker.getQAList().size()-1) {
            textCounter = textCounter;
            errorMessage.setText("This is the last question!!!");

        } else textCounter++;
        counter.setDigit(textCounter);

        return worker.getQAList().get(textCounter).getIndex() + " - " +
                worker.getQAList().get(textCounter).getQuestion();
    }
}