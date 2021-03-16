package Controller.ButtonsControllers;

import DataBase.DBWorker;
import View.TButtonPattern;

public class StartLearningButtonController {

    private final DBWorker worker;

    private final TButtonPattern coreButton;
    private final TButtonPattern collectionButton;
    private final TButtonPattern java8Button;
    private final TButtonPattern IOandNIOButton;
    private final TButtonPattern serializationButton;

    public StartLearningButtonController(DBWorker worker, TButtonPattern coreBut,
                                         TButtonPattern colBut, TButtonPattern java8But,
                                         TButtonPattern ioButton, TButtonPattern serButton) {
        this.coreButton = coreBut;
        this.collectionButton = colBut;
        this.java8Button = java8But;
        this.IOandNIOButton = ioButton;
        this.serializationButton = serButton;
        this.worker = worker;
    }

    public void startProg() {

        if (coreButton.isSelected()) {
            worker.getBufferList().addAll(worker.getCoreList());
        }
        if (collectionButton.isSelected()) {
            worker.getBufferList().addAll(worker.getCollectionList());
        }
        if (java8Button.isSelected()) {
            worker.getBufferList().addAll(worker.getJava8List());
        }
        if (IOandNIOButton.isSelected()) {
            worker.getBufferList().addAll(worker.getIOList());
        }
        if (serializationButton.isSelected()) {
            worker.getBufferList().addAll(worker.getSerializationList());
        }

    }
}