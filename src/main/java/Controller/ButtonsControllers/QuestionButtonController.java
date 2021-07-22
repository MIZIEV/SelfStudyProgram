package Controller.ButtonsControllers;

import Model.MainModel;

public class QuestionButtonController {

    private final MainModel model;

    public QuestionButtonController(MainModel model) {
        this.model = model;
    }

    public final String getRandomQuestion() {
        int randomDigit = (int) (Math.random() * model.getDBWorker().getBufferList().size());

        String question = "!!! empty !!!";

        if (model.getDBWorker().getBufferList().get(randomDigit).getYesNo() == 0) {

            question = model.getDBWorker().getBufferList().get(randomDigit).getIndex() + " - " +
                    model.getDBWorker().getBufferList().get(randomDigit).getTheme() + ": " + "\n" +
                    model.getDBWorker().getBufferList().get(randomDigit).getQuestion();
        } else {
            while (model.getDBWorker().getBufferList().get(randomDigit).getYesNo() == 1 ^
                    model.getDBWorker().getBufferList().get(randomDigit).getYesNo() == -1) {
                if (model.getCountingResult().getTotalResult() == 1.0) break;

                randomDigit = (int) (Math.random() * model.getDBWorker().getBufferList().size());
                question = model.getDBWorker().getBufferList().get(randomDigit).getIndex() + " - " +
                        model.getDBWorker().getBufferList().get(randomDigit).getTheme() + ": " + "\n" +
                        model.getDBWorker().getBufferList().get(randomDigit).getQuestion();
            }
        }
        model.getListIndex().setIndex(randomDigit);
        return question;
    }
}