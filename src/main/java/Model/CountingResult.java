package Model;

public class CountingResult {

    private final DBWorker worker;
    private final ListIndex listIndex;

    private double totalResult;

    public CountingResult(DBWorker work, ListIndex count) {
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
}