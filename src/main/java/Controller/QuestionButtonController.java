package Controller;

import DataBase.*;

public class QuestionButtonController {

    private final DBWorker worker;
    private final Counter counter;

    public QuestionButtonController(DBWorker work, Counter count) {
        this.worker = work;
        this.counter = count;
    }

    public String getRandomQuestion() {
        int randomDigit = (int) (Math.random() * worker.getQAList().size());
        counter.setDigit(randomDigit);
        String question = "";

        if (worker.getQAList().get(randomDigit).getYesNo() == false) {

            question = worker.getQAList().get(randomDigit).getIndex() + " - " +
                    worker.getQAList().get(randomDigit).getQuestion();
        } else {
            while (worker.getQAList().get(randomDigit).getYesNo() != false) {

                randomDigit = (int) (Math.random() * worker.getQAList().size());
                question = worker.getQAList().get(randomDigit).getIndex() + " - " +
                        worker.getQAList().get(randomDigit).getQuestion();
            }
        }
        return question;
    }
}