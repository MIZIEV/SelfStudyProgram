package DataBase;

public class CountingResult {

    private final DBWorker worker;
    private final ResultCount resultCount;

    public CountingResult(DBWorker work, ResultCount result) {
        this.resultCount = result;
        this.worker = work;
    }

    public double counting() {

        double result = resultCount.getResult();
        double addend = 100.0 / worker.getBufferList().size();

        result = result + addend;
        resultCount.setResult(result);

        return result;
    }
}