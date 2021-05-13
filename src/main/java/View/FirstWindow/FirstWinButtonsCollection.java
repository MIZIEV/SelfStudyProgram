package View.FirstWindow;

import Controller.TButtonsControllers.SelectAllButtonController;
import View.buttonsPatterns.ButtonsPattern;
import View.SecondWindow.SecondWindow;
import View.buttonsPatterns.TButtonPattern;
import javafx.scene.control.*;

public class FirstWinButtonsCollection {
    private static final short PREF_WIDTH = 100;
    private static final short PREF_HEIGHT = 40;
    private static final short PREF_WIDTH_CENTRAL_BUTTON = 150;
    private static final short PREF_HEIGHT_CENTRAL_BUTTON = 60;

    private final SecondWindow secondWindow;
    private final FirstWindow firstWindow;

    private final TButtonPattern coreButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "Core");
    private final TButtonPattern collectionButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "Collections");
    private final TButtonPattern java8Button = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "Java 8");
    private final TButtonPattern IOandNIOButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "IO/NIO");

    private final TButtonPattern serializationButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "Serialization");
    private final TButtonPattern MTButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "Multithreading");
    private final TButtonPattern dataBaseButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "Data base");
    private final TButtonPattern SQLButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "SQL");

    private final TButtonPattern HTMLButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "HTML");
    private final TButtonPattern CSSButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "CSS");
    private final TButtonPattern JDBCButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "JDBC");
    private final TButtonPattern XMLButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "XML");

    private final TButtonPattern selectAllButton = new TButtonPattern(PREF_WIDTH_CENTRAL_BUTTON, PREF_HEIGHT_CENTRAL_BUTTON, "Select all");
    private final ButtonsPattern startLearningButton = new ButtonsPattern(PREF_WIDTH_CENTRAL_BUTTON, PREF_HEIGHT_CENTRAL_BUTTON, "Start learning");

    public FirstWinButtonsCollection(FirstWindow firstW, SecondWindow secondW) {
        this.firstWindow = firstW;
        this.secondWindow = secondW;

        selectAllButton.setTooltip(new Tooltip("Select at least one theme"));
        startLearningButton.setTooltip(new Tooltip("Select at least one theme"));
        selectAllButton.setOnAction((event) -> {
            SelectAllButtonController selectAllButtonController = new SelectAllButtonController(this);
        });
    }

    public TButtonPattern getCoreButton() {
        return coreButton;
    }

    public TButtonPattern getCollectionButton() {
        return collectionButton;
    }

    public TButtonPattern getJava8Button() {
        return java8Button;
    }

    public TButtonPattern getIOandNIOButton() {
        return IOandNIOButton;
    }

    public TButtonPattern getSerializationButton() {
        return serializationButton;
    }

    public TButtonPattern getMTButton() {
        return MTButton;
    }

    public TButtonPattern getDataBaseButton() {
        return dataBaseButton;
    }

    public TButtonPattern getSQLButton() {
        return SQLButton;
    }

    public TButtonPattern getHTMLButton() {
        return HTMLButton;
    }

    public TButtonPattern getCSSButton() {
        return CSSButton;
    }

    public TButtonPattern getJDBCButton() {
        return JDBCButton;
    }

    public TButtonPattern getXMLButton() {
        return XMLButton;
    }

    public TButtonPattern getSelectAllButton() {
        return selectAllButton;
    }

    public ButtonsPattern getStartLearningButton() {
        return startLearningButton;
    }
}