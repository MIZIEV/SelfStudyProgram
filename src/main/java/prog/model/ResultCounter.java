package prog.model;

import java.util.ArrayList;

/**
 * Class description:
 * This class is needed to counting result of your learning, each flagged question will be marked and counted.
 * <p>
 * Method description:
 * double counting(); - this method count result during learning;
 * double countingFromFile(ArrayList<InfoFromDB> list); - this method take ArrayList from saved files
 * and count result from them;
 * double resetResult(); - this method assigns 0.0 to totalResalt variable;
 * int getEndLearningResult(); - this method count only question where yesNo variable == 1.
 */
public class ResultCounter {

    private final DBWorker worker;
    private final ListIndex listIndex;
    private double totalResult;

    public ResultCounter(DBWorker work, ListIndex count) {
        this.listIndex = count;
        this.worker = work;
    }

    public double countingTotalResult() {
        double addend = 100.0 / worker.getBufferList().size();

        if (worker.getBufferList().get(listIndex.getIndex()).getYesNo() == 0) totalResult += addend / 100.0;
        if (totalResult > 0.998) totalResult = 1.0;   //todo <-------it is god???

        System.out.println("total result - " + totalResult);
        return totalResult;
    }

    public double countingFromFile(ArrayList<InfoFromDB> list) {
        double addend = 100.0 / list.size();

        for (InfoFromDB element : list) {
            if (element.getYesNo() == 1 ^ element.getYesNo() == -1) {
                totalResult += addend / 100.0;
            }
        }
        return totalResult;
    }

    public int getEndLearningResult() {
        double result = 0.0;
        double addend = 100.0 / worker.getBufferList().size();

        for (InfoFromDB element : worker.getBufferList()) {
            if (element.getYesNo() == 1) {
                result += addend;
            }
        }
        if (result > 99.9) result = 100.0; // todo<------------------it is not good !!!
        return (int) result;
    }

    public double getTotalResult() {
        return totalResult;
    }

    public double resetResult() {
        return totalResult = 0.0;
    }
}