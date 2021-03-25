package Model;

import java.text.*;

public class CountingResult {

    private final DBWorker worker;
    private final Counter counter;
    private final DecimalFormat df = new DecimalFormat("###.##");

    private double totalResult, coreResult, collectionsResult, java8Result,
            inNioResult, serialisationResult, multiThreadingResult, dataBaseResult, SQLResult,
            JDBCResult, XMLResult, HTMLResult, CSSResult;

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
        double dataBaseAddend = 100.0 / worker.getDataBaseList().size();
        double SQLAddend = 100.0 / worker.getSQLList().size();
        double JDBCAddend = 100.0 / worker.getJDBCList().size();
        double XMLAddend = 100.0 / worker.getXMLList().size();
        double HTMLAddend = 100.0 / worker.getHTMLList().size();
        double CSSAddend = 100.0 / worker.getCSSList().size();

        totalResult += addend;

        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("Core")) {
            coreResult += coreAddend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("Collections")) {
            collectionsResult += collectionAddend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("Java 8")) {
            java8Result += java8Addend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("Java IO/NIO")) {
            inNioResult += ioNioAddend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("Serialization")) {
            serialisationResult += serialisationAddend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("Multithreading ")) {
            multiThreadingResult += multiThreadingAddend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("Model")) {
            dataBaseResult += dataBaseAddend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("SQL")) {
            SQLResult += SQLAddend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("JDBC")) {
            JDBCResult += JDBCAddend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("XML")) {
            XMLResult += XMLAddend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("HTML")) {
            HTMLResult += HTMLAddend;
        }
        if (worker.getBufferList().get(counter.getDigit()).getTheme().equals("CSS")) {
            CSSResult += CSSAddend;
        }

        String stringResult = ("Core - " + df.format(coreResult)) + " %" + "\n" +
                ("Collection - " + df.format(collectionsResult)) + " %" + "\n" +
                ("java 8 - " + df.format(java8Result)) + " %" + "\n" +
                ("io/nio - " + df.format(inNioResult)) + " %" + "\n" +
                ("Serialization - " + df.format(serialisationResult)) + " %" + "\n" +
                ("MultiThreading - " + df.format(multiThreadingResult)) + " %" + "\n" +
                ("Data base - " + df.format(dataBaseResult)) + " %" + "\n" +
                ("SQL - " + df.format(SQLResult)) + " %" + "\n" +
                ("JDBC - " + df.format(JDBCResult)) + " %" + "\n" +
                ("XML - " + df.format(XMLResult)) + " %" + "\n" +
                ("HTML - " + df.format(HTMLResult)) + " %" + "\n" +
                ("CSS - " + df.format(CSSResult)) + " %" + "\n" +

                ("Total - " + df.format(totalResult)) + " %" + "\n";

        return stringResult;
    }

    public double getTotalResult() { return totalResult; }
}