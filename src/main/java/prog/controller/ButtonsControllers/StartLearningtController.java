package prog.controller.ButtonsControllers;

import prog.model.DBWorker;
import prog.view.patterns.controls.TButtonPattern;

public class StartLearningtController {

    private final DBWorker worker;

    private final TButtonPattern coreButton;
    private final TButtonPattern collectionButton;
    private final TButtonPattern java8Button;
    private final TButtonPattern IOandNIOButton;
    private final TButtonPattern serializationButton;
    private final TButtonPattern MultithreadingButton;
    private final TButtonPattern dataBaseButton;
    private final TButtonPattern SQLButton;
    private final TButtonPattern JDBCButton;
    private final TButtonPattern XMLButton;
    private final TButtonPattern HTMLButton;
    private final TButtonPattern CSSButton;

    public StartLearningtController(DBWorker worker, TButtonPattern coreBut,
                                    TButtonPattern colBut, TButtonPattern java8But, TButtonPattern ioButton,
                                    TButtonPattern serButton, TButtonPattern mtButton, TButtonPattern DBButton,
                                    TButtonPattern sqlButton, TButtonPattern jdbcButton, TButtonPattern xmlButton,
                                    TButtonPattern htmlButton, TButtonPattern cssButton) {

        this.coreButton = coreBut;
        this.collectionButton = colBut;
        this.java8Button = java8But;
        this.IOandNIOButton = ioButton;
        this.serializationButton = serButton;
        this.MultithreadingButton = mtButton;
        this.XMLButton = xmlButton;
        this.JDBCButton = jdbcButton;
        this.SQLButton = sqlButton;
        this.dataBaseButton = DBButton;
        this.HTMLButton = htmlButton;
        this.CSSButton = cssButton;
        this.worker = worker;
    }

    public void startLearning() {

        if (coreButton.isSelected()) worker.getBufferList().addAll(worker.getCoreList());

        if (collectionButton.isSelected()) worker.getBufferList().addAll(worker.getCollectionList());

        if (java8Button.isSelected()) worker.getBufferList().addAll(worker.getJava8List());

        if (IOandNIOButton.isSelected()) worker.getBufferList().addAll(worker.getIOList());

        if (serializationButton.isSelected()) worker.getBufferList().addAll(worker.getSerializationList());

        if (MultithreadingButton.isSelected()) worker.getBufferList().addAll(worker.getMTList());

        if (dataBaseButton.isSelected()) worker.getBufferList().addAll(worker.getDataBaseList());

        if (SQLButton.isSelected()) worker.getBufferList().addAll(worker.getSQLList());

        if (JDBCButton.isSelected()) worker.getBufferList().addAll(worker.getJDBCList());

        if (XMLButton.isSelected()) worker.getBufferList().addAll(worker.getXMLList());

        if (HTMLButton.isSelected()) worker.getBufferList().addAll(worker.getHTMLList());

        if (CSSButton.isSelected()) worker.getBufferList().addAll(worker.getCSSList());
    }

    public boolean ifNotSelected() {
        boolean answer = false;
        if (coreButton.isSelected() | collectionButton.isSelected() | java8Button.isSelected() |
                IOandNIOButton.isSelected() | serializationButton.isSelected() | MultithreadingButton.isSelected() |
                dataBaseButton.isSelected() | SQLButton.isSelected() | JDBCButton.isSelected() | XMLButton.isSelected() |
                HTMLButton.isSelected() | CSSButton.isSelected()) {
            answer = true;
        }
        return answer;
    }
}