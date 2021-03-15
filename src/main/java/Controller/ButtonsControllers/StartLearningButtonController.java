package Controller.ButtonsControllers;

import DataBase.DBWorker;
import View.ToggleButtonPattern;

public class StartLearningButtonController {

    private final DBWorker worker;

    private final ToggleButtonPattern coreButton;
    private final ToggleButtonPattern collectionButton;
    private final ToggleButtonPattern java8Button;
    private final ToggleButtonPattern IOandNIOButton;
    private final ToggleButtonPattern serializationButton;

    public StartLearningButtonController(DBWorker worker, ToggleButtonPattern coreBut,
                                         ToggleButtonPattern colBut, ToggleButtonPattern java8But,
                                         ToggleButtonPattern ioButton, ToggleButtonPattern serButton) {
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