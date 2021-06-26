package Controller.ButtonsControllers;

import Model.Counter;
import Model.DBWorker;

public class StartButtonController implements Changer {

    private final DBWorker worker;
    private final Counter counter;

    public StartButtonController(DBWorker worker, Counter count) {
        this.worker = worker;
        this.counter = count;
    }

    @Override
    public String startController() {
        int startDigit = 0;
        counter.setDigit(startDigit);

        return worker.getBufferList().get(startDigit).getIndex() + " - " +
                worker.getBufferList().get(startDigit).getTheme() + ": " + "\n" +
                worker.getBufferList().get(startDigit).getQuestion();
    }
}