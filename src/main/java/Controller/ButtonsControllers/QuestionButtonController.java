package Controller.ButtonsControllers;

import Model.*;

public class QuestionButtonController implements Changer {

    private final DBWorker worker;
    private final ListIndex listIndex;

    public QuestionButtonController(DBWorker work, ListIndex count) {
        this.worker = work;
        this.listIndex = count;
    }

    @Override
    public String startController() {
        int randomDigit = (int) (Math.random() * worker.getBufferList().size());

        String question = "!!! empty !!!";

        if (worker.getBufferList().get(randomDigit).getYesNo() == 0) {

            question = worker.getBufferList().get(randomDigit).getIndex() + " - " +
                    worker.getBufferList().get(randomDigit).getTheme() + ": " + "\n" +
                    worker.getBufferList().get(randomDigit).getQuestion();
        } else {
            while (worker.getBufferList().get(randomDigit).getYesNo() == 1 ^
                    worker.getBufferList().get(randomDigit).getYesNo() == -1) {

                randomDigit = (int) (Math.random() * worker.getBufferList().size());
                question = worker.getBufferList().get(randomDigit).getIndex() + " - " +
                        worker.getBufferList().get(randomDigit).getTheme() + ": " + "\n" +
                        worker.getBufferList().get(randomDigit).getQuestion();
            }
        }
        listIndex.setIndex(randomDigit);
        return question;
    }
}