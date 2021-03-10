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

        if (worker.getQAList().get(randomDigit).getYesNo() == true) {
            //randomDigit = (int) (Math.random() * worker.getQAList().size());   //todo придумать норм логику!!!!

        }

        return worker.getQAList().get(randomDigit).getIndex() + " - " +
                worker.getQAList().get(randomDigit).getQuestion();
    }
}