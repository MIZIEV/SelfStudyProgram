package Controller.ButtonsControllers;

import DataBase.Counter;
import DataBase.DBWorker;

public class StartButtonController {

    private final DBWorker worker;
    private final Counter counter;

    public StartButtonController(DBWorker worker, Counter count) {
        this.worker = worker;
        this.counter = count;
    }

    public String getTextFromList() {
        int startDigit = 0;
        counter.setDigit(startDigit);

        System.out.println("---buffer list size - " + worker.getBufferList().size());
        System.out.println("core list size - " + worker.getCoreList().size());
        System.out.println("collection list size - " + worker.getCollectionList().size());
        System.out.println("java 8 list size - " + worker.getJava8List().size());
        System.out.println("io/nio list size - " + worker.getIOList().size());
        System.out.println("Serialization list size - " + worker.getSerializationList().size());
        System.out.println("MultiThreading list - size - "+worker.getMTList().size());

        return worker.getBufferList().get(startDigit).getIndex() + " - " +
                worker.getBufferList().get(startDigit).getTheme() + ": " + "\n" +
                worker.getBufferList().get(startDigit).getQuestion();
    }
}