package Controller;

import DataBase.Counter;
import DataBase.DBWorker;

public class StartButtonController {

    private final DBWorker worker;
    private final Counter counter;

    public StartButtonController(DBWorker worker, Counter count) {
        this.worker = worker;
        this.counter = count;
    }

    public String getTextFromList() {
        int startDigit = 0;
        counter.setDigit(startDigit);

        return worker.getQAList().get(startDigit).getIndex() + " - " +
                worker.getQAList().get(startDigit).getQuestion();
    }
}