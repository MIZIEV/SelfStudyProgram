package View;

import Model.*;

public class GeneralDependence {

    private DBWorker worker = new DBWorker();
    private Counter digit = new Counter();

    private OutputText outputText = new OutputText();
    private ResultMessage resultMessage = new ResultMessage();

    public OutputText getOutputText() {
        return outputText;
    }

    public ResultMessage getResultMassage() {
        return resultMessage;
    }

    public DBWorker getWorker() {
        return worker;
    }

    public Counter getDigit() {
        return digit;
    }
}