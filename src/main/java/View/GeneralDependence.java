package View;

import DataBase.*;

public class GeneralDependence {

    private DBWorker worker = new DBWorker();
    private Counter digit = new Counter();
    private ResultCount resultCount = new ResultCount();

    private OutputText outputText = new OutputText();
    private ResultMassage resultMassage = new ResultMassage();
    private ErrorMessage errorMessage = new ErrorMessage();

    public OutputText getOutputText() {
        return outputText;
    }

    public ResultMassage getResultMassage() {
        return resultMassage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public DBWorker getWorker() {
        return worker;
    }

    public void setWorker(DBWorker worker) {
        this.worker = worker;
    }

    public Counter getDigit() {
        return digit;
    }

    public void setDigit(Counter digit) {
        this.digit = digit;
    }

    public ResultCount getResultCount() {
        return resultCount;
    }

    public void setResultCount(ResultCount resultCount) {
        this.resultCount = resultCount;
    }
}
