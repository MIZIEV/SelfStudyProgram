package DataBase;

import java.text.*;

public class CountingResult {

    private final DBWorker worker;
    private final DecimalFormat df = new DecimalFormat("###.##");
    private double result;

    public CountingResult(DBWorker work) {
        this.worker = work;
    }

    public String counting() {

        result = this.getResult();
        double addend = 100.0 / worker.getBufferList().size();
        result = result + addend;
        this.setResult(result);
        String stringResult = ("Result - " + df.format(result)) + " %";

        return stringResult;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}