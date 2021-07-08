package Model;

import java.util.ArrayList;

/**
 * Class description:
 * This class is needed to counting result of your learning, each flagged question will be marked and counted.
 * <p>
 * Method description:
 * double counting(); - this method count result during learning;
 * double countingFromFile(ArrayList<InfoFromDB> list); - this method take ArrayList from saved files
 * and count result from them;
 * double resetResult(); - this method assigns 0.0 to totalResalt variable.
 */
public class ResultCounter {

    private final DBWorker worker;
    private final ListIndex listIndex;
    private double totalResult;

    public ResultCounter(DBWorker work, ListIndex count) {
        this.listIndex = count;
        this.worker = work;
    }

    public double counting() {

        if (!worker.getBufferList().get(listIndex.getIndex()).getYesNo()) {
            double addend = 100.0 / worker.getBufferList().size();
            totalResult += addend / 100.0;
        }
        return totalResult;
    }

    public double countingFromFile(ArrayList<InfoFromDB> list) {

        double addend = 100.0 / list.size();

        for (InfoFromDB element : list) {
            if (element.getYesNo()) {
                totalResult += addend / 100.0;
            }
        }
        return totalResult;
    }

    public double resetResult() {
        return totalResult = 0.0;
    }
}