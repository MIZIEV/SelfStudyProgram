package View;

import Controller.TButtonsControllers.SelectAllButtonController;
import javafx.scene.control.*;

public class FirstWindowConstructor {

    private final SecondWindow secondWindow;
    private final FirstWindow firstWindow;

    private final TButtonPattern coreButton = new TButtonPattern(50, 100, 100, 50, "Core");
    private final TButtonPattern collectionButton = new TButtonPattern(200, 100, 100, 50, "Collections");
    private final TButtonPattern java8Button = new TButtonPattern(510, 100, 100, 50, "Java 8");
    private final TButtonPattern IOandNIOButton = new TButtonPattern(660, 100, 100, 50, "IO/NIO");

    private final TButtonPattern serializationButton = new TButtonPattern(50, 175, 100, 50, "Serialization");
    private final TButtonPattern MTButton = new TButtonPattern(200, 175, 100, 50, "Multithreading");
    private final TButtonPattern empty1Button2 = new TButtonPattern(510, 175, 100, 50, "empty - 2");
    private final TButtonPattern empty1Button3 = new TButtonPattern(660, 175, 100, 50, "empty - 3");

    private final TButtonPattern empty1Button4 = new TButtonPattern(50, 250, 100, 50, "empty - 4");
    private final TButtonPattern empty1Button5 = new TButtonPattern(200, 250, 100, 50, "empty - 5");
    private final TButtonPattern empty1Button6 = new TButtonPattern(510, 250, 100, 50, "empty - 6");
    private final TButtonPattern empty1Button7 = new TButtonPattern(660, 250, 100, 50, "empty - 7");

    private final TButtonPattern selectAllButton = new TButtonPattern(345, 175, 120, 125, "Select all");
    private final ButtonsPattern startLearningButton = new ButtonsPattern(345, 340, 120, 50, "Start learning");

    public FirstWindowConstructor(FirstWindow firstW, SecondWindow secondW) {
        this.firstWindow = firstW;
        this.secondWindow = secondW;

        Label title = new Label();
        title.setStyle("-fx-font-size: 20px;");
        title.setText("Chose theme");
        title.setLayoutX(345);
        title.setLayoutY(50);

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

    public TButtonPattern getEmpty1Button2() { return empty1Button2; }

    public TButtonPattern getEmpty1Button3() { return empty1Button3; }

    public TButtonPattern getEmpty1Button4() { return empty1Button4; }

    public TButtonPattern getEmpty1Button5() { return empty1Button5; }

    public TButtonPattern getEmpty1Button6() { return empty1Button6; }

    public TButtonPattern getEmpty1Button7() { return empty1Button7; }

    public TButtonPattern getSelectAllButton() { return selectAllButton; }

    public ButtonsPattern getStartLearningButton() { return startLearningButton; }
}