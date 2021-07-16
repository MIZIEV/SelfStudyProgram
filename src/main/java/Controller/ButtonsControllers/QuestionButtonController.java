package Controller.ButtonsControllers;

import View.ProgramModel;

public class QuestionButtonController  {

private final ProgramModel model;

    public QuestionButtonController(ProgramModel model) {
        this.model = model;
    }

    public String getRandomQuestion() {
        int randomDigit = (int) (Math.random() * model.getDBWorker().getBufferList().size());

        String question = "!!! empty !!!";

        if (model.getDBWorker().getBufferList().get(randomDigit).getYesNo() == 0) {

            question = model.getDBWorker().getBufferList().get(randomDigit).getIndex() + " - " +
                    model.getDBWorker().getBufferList().get(randomDigit).getTheme() + ": " + "\n" +
                    model.getDBWorker().getBufferList().get(randomDigit).getQuestion();
        } else {
            while (model.getDBWorker().getBufferList().get(randomDigit).getYesNo() == 1 ^
                    model.getDBWorker().getBufferList().get(randomDigit).getYesNo() == -1) {

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