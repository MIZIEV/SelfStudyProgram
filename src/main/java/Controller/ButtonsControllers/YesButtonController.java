package Controller.ButtonsControllers;

import DataBase.*;
import View.ResultMessage;

public class YesButtonController {
    private final DBWorker worker;
    private final Counter counter;
    private final CountingResult countingResult;
    private final ResultMessage resultMessage;

    public YesButtonController(DBWorker work, Counter count, ResultMessage result, CountingResult counting) {
        this.countingResult = counting;
        this.counter = count;
        this.worker = work;
        this.resultMessage = result;
    }

    public void setYesNo() {
        int count = counter.getDigit();

        if (worker.getBufferList().get(count).getYesNo() != true) {

            worker.getBufferList().get(count).setYesNo(true);
            String result = countingResult.counting();

            if (countingResult.getResult() < 40) {
                resultMessage.setStyle("-fx-text-inner-color: red;-fx-font-size: 16px;");
            } else if (countingResult.getResult() < 80) {
                resultMessage.setStyle("-fx-text-inner-color: orange;-fx-font-size: 16px;");
            } else if (countingResult.getResult() > 80) {
                resultMessage.setStyle("-fx-text-inner-color: green;-fx-font-size: 16px;");
            }

               resultMessage.setText(result);
        }
    }
}