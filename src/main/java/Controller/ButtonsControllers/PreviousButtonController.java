package Controller.ButtonsControllers;

import DataBase.Counter;
import DataBase.DBWorker;
import View.ErrorMessage;

public class PreviousButtonController {
    private final DBWorker worker;
    private final Counter counter;
    private final ErrorMessage errorMessage;

    public PreviousButtonController(DBWorker work, Counter count, ErrorMessage error) {
        this.errorMessage = error;
        this.worker = work;
        this.counter = count;
    }

    public String scrollText() {
        int textCounter = counter.getDigit();

        if (textCounter <= 0) {
            textCounter = 0;
            errorMessage.setText("This is the first question!!!");

        } else textCounter--;

        counter.setDigit(textCounter);
        return worker.getBufferList().get(textCounter).getIndex()+" - "+
                worker.getBufferList().get(textCounter).getTheme()+": "+"\n"+
                worker.getBufferList().get(textCounter).getQuestion();
    }
}
