package Controller;

import DataBase.*;

public class NoButtonController {
    DBWorker worker;
    Counter counter;

    public NoButtonController(DBWorker work, Counter count) {
        this.worker = work;
        this.counter = count;
    }

    public void setNo() {
        int digit = counter.getDigit();
        if (worker.getQAList().get(digit).getYesNo() != true) worker.getQAList().get(digit).setYesNo(false);
    }
}