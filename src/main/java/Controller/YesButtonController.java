package Controller;

import DataBase.*;
import View.ResultMassage;

import java.text.DecimalFormat;

public class YesButtonController {
    private final DBWorker worker;
    private final Counter counter;
    private final CountingResult countingResult;
    private final ResultMassage resultMassage;
    DecimalFormat df = new DecimalFormat("###.##");

    public YesButtonController(DBWorker work, Counter count, ResultMassage result, CountingResult counting) {
        this.countingResult = counting;
        this.counter = count;
        this.worker = work;
        this.resultMassage = result;
    }

    public void setYesNo() {
        int count = counter.getDigit();

        if (worker.getQAList().get(count).getYesNo() != true) {

            worker.getQAList().get(count).setYesNo(true);
            double result = countingResult.counting();

            if (result < 40) {
                resultMassage.setStyle("-fx-text-inner-color: red;-fx-font-size: 20px;");
            } else if (result < 80) {
                resultMassage.setStyle("-fx-text-inner-color: orange;-fx-font-size: 20px;");
            } else if (result > 80) {
                resultMassage.setStyle("-fx-text-inner-color: green;-fx-font-size: 20px;");
            }

            resultMassage.setText(df.format(result) + " %");
        }
    }
}