package Controller.ButtonsControllers;

import Model.*;

public class QuestionButtonController implements Changer {

    private final DBWorker worker;
    private final Counter counter;

    public QuestionButtonController(DBWorker work, Counter count) {
        this.worker = work;
        this.counter = count;
    }

    @Override
    public String startController() {
        int randomDigit = (int) (Math.random() * worker.getBufferList().size());

        String question = "";

        if (worker.getBufferList().get(randomDigit).getYesNo() == false) {

            question = worker.getBufferList().get(randomDigit).getIndex() + " - " +
                    worker.getBufferList().get(randomDigit).getTheme() + ": " + "\n" +
                    worker.getBufferList().get(randomDigit).getQuestion();
        } else {
            while (worker.getBufferList().get(randomDigit).getYesNo() != false) {

                randomDigit = (int) (Math.random() * worker.getBufferList().size());
                question = worker.getBufferList().get(randomDigit).getIndex() + " - " +
                        worker.getBufferList().get(randomDigit).getTheme() + ": " + "\n" +
                        worker.getBufferList().get(randomDigit).getQuestion();
            }
        }
        counter.setDigit(randomDigit);
        return question;
    }
}