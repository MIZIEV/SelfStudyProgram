package View;

import Model.*;

public class GeneralDependence {

    private final DBWorker worker = new DBWorker();
    private final Counter digit = new Counter();
    private final OutputText outputText = new OutputText();
    private final ResultMessage resultMessage = new ResultMessage();

    public DBWorker getWorker() { return worker; }

    public Counter getDigit() { return digit; }

    public OutputText getOutputText() { return outputText; }

    public ResultMessage getResultMassage() { return resultMessage; }
}