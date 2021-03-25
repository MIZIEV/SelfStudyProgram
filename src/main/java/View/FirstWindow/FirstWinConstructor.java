package View.FirstWindow;

import Controller.TButtonsControllers.SelectAllButtonController;
import View.buttonsPatterns.ButtonsPattern;
import View.SecondWindow.SecondWindow;
import View.buttonsPatterns.TButtonPattern;
import javafx.scene.control.*;

public class FirstWinConstructor {

    private final SecondWindow secondWindow;
    private final FirstWindow firstWindow;

    private final TButtonPattern coreButton = new TButtonPattern(50, 100, 100, 50, "Core");
    private final TButtonPattern collectionButton = new TButtonPattern(200, 100, 100, 50, "Collections");
    private final TButtonPattern java8Button = new TButtonPattern(510, 100, 100, 50, "Java 8");
    private final TButtonPattern IOandNIOButton = new TButtonPattern(660, 100, 100, 50, "IO/NIO");

    private final TButtonPattern serializationButton = new TButtonPattern(50, 175, 100, 50, "Serialization");
    private final TButtonPattern MTButton = new TButtonPattern(200, 175, 100, 50, "Multithreading");
    private final TButtonPattern dataBaseButton = new TButtonPattern(510, 175, 100, 50, "Data base");
    private final TButtonPattern SQLButton = new TButtonPattern(660, 175, 100, 50, "SQL");

    private final TButtonPattern HTMLButton = new TButtonPattern(50, 250, 100, 50, "HTML");
    private final TButtonPattern CSSButton = new TButtonPattern(200, 250, 100, 50, "CSS");
    private final TButtonPattern JDBCButton = new TButtonPattern(510, 250, 100, 50, "JDBC");
    private final TButtonPattern XMLButton = new TButtonPattern(660, 250, 100, 50, "XML");

    private final TButtonPattern selectAllButton = new TButtonPattern(345, 175, 120, 125, "Select all");
    private final ButtonsPattern startLearningButton = new ButtonsPattern(345, 340, 120, 50, "Start learning");

    public FirstWinConstructor(FirstWindow firstW, SecondWindow secondW) {
        this.firstWindow = firstW;
        this.secondWindow = secondW;

        Label title = new Label();
        title.setStyle("-fx-font-size: 20px;");
        title.setText("Chose theme");
        title.setLayoutX(345);
        title.setLayoutY(50);

        selectAllButton.setTooltip(new Tooltip("Select at least one theme"));
        startLearningButton.setTooltip(new Tooltip("Select at least one theme"));
        selectAllButton.setOnAction((event) -> {
            SelectAllButtonController selectAllButtonController = new SelectAllButtonController(this);
        });
    }

    public TButtonPattern getCoreButton() { return coreButton; }

    public TButtonPattern getCollectionButton() { return collectionButton; }

    public TButtonPattern getJava8Button() { return java8Button; }

    public TButtonPattern getIOandNIOButton() { return IOandNIOButton; }

    public TButtonPattern getSerializationButton() { return serializationButton; }

    public TButtonPattern getMTButton() { return MTButton; }

    public TButtonPattern getDataBaseButton() { return dataBaseButton; }

    public TButtonPattern getSQLButton() { return SQLButton; }

    public TButtonPattern getHTMLButton() { return HTMLButton; }

    public TButtonPattern getCSSButton() { return CSSButton; }

    public TButtonPattern getJDBCButton() { return JDBCButton; }

    public TButtonPattern getXMLButton() { return XMLButton; }

    public TButtonPattern getSelectAllButton() { return selectAllButton; }

    public ButtonsPattern getStartLearningButton() { return startLearningButton; }
}