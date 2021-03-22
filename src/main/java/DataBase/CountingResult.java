package DataBase;

import java.text.*;

public class CountingResult {

    private final DBWorker worker;
    private final Counter counter;
    private final DecimalFormat df = new DecimalFormat("###.##");

    private double totalResult,coreResult,collectionsResult,java8Result,
            inNioResult,serialisationResult,multiThreadingResult;

    public CountingResult(DBWorker work, Counter count) {
        this.counter = count;
        this.worker = work;
    }

    public String counting() {

        double addend = 100.0 / worker.getBufferList().size();
        double coreAddend = 100.0 / worker.getCoreList().size();
        double collectionAddend = 100.0 / worker.getCollectionList().size();
        double java8Addend = 100.0 / worker.getJava8List().size();
        double ioNioAddend = 100.0 / worker.getIOList().size();
        double serialisationAddend = 100.0 / worker.getSerializationList().size();
        double multiThreadingAddend = 100.0 / worker.getMTList().size();

        totalResult = totalResult + addend;

        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("Core")) {
            coreResult = coreResult + coreAddend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("Collections")) {
            collectionsResult = collectionsResult + collectionAddend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("Java 8")) {
            java8Result = java8Result + java8Addend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("Java IO/NIO")) {
            inNioResult = inNioResult + ioNioAddend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("Serialization")) {
            serialisationResult = serialisationResult + serialisationAddend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("Multithreading ")) {
            multiThreadingResult = multiThreadingResult + multiThreadingAddend;
        }

        String stringResult = ("Core - " + df.format(coreResult)) + " %" + "\n" +
                ("Collection - " + df.format(collectionsResult)) + " %" + "\n" +
                ("java 8 - " + df.format(java8Result)) + " %" + "\n" +
                ("io/nio - " + df.format(inNioResult)) + " %" + "\n" +
                ("Serialization - " + df.format(serialisationResult)) + " %" + "\n" +
                ("MultiThreading - " + df.format(multiThreadingResult)) + " %" + "\n" +
                ("Total - " + df.format(totalResult)) + " %" + "\n";

        return stringResult;
    }
    public double getTotalResult() {
        return totalResult;
    }
}