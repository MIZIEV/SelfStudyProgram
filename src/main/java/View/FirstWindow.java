package View;

import Controller.ButtonsControllers.StartLearningButtonController;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FirstWindow {

    private SecondWindow secondWindow;
    private final Stage firstWindow = new Stage();
    private final GeneralDependence generalDependence;

    public FirstWindow(GeneralDependence genDependence) {
        this.generalDependence = genDependence;
    }

    public void startWindow(SecondWindow secWindow) {
        this.secondWindow = secWindow;

        Label title = new Label();
        title.setStyle("-fx-font-size: 20px;");
        title.setText("Chose theme");
        title.setLayoutX(345);
        title.setLayoutY(50);

        ToggleButtonPattern coreButton = new ToggleButtonPattern(50, 100, 100, 50, "Core");
        ToggleButtonPattern collectionButton = new ToggleButtonPattern(200, 100, 100, 50, "Collections");
        ToggleButtonPattern java8Button = new ToggleButtonPattern(510, 100, 100, 50, "Java 8");
        ToggleButtonPattern IOandNIOButton = new ToggleButtonPattern(660, 100, 100, 50, "IO/NIO");

        ToggleButtonPattern serializationButton = new ToggleButtonPattern(50, 175, 100, 50, "Serialization");
        ToggleButtonPattern empty1Button1 = new ToggleButtonPattern(200, 175, 100, 50, "empty - 1");
        ToggleButtonPattern empty1Button2 = new ToggleButtonPattern(510, 175, 100, 50, "empty - 2");
        ToggleButtonPattern empty1Button3 = new ToggleButtonPattern(660, 175, 100, 50, "empty - 3");

        ToggleButtonPattern empty1Button4 = new ToggleButtonPattern(50, 250, 100, 50, "empty - 4");
        ToggleButtonPattern empty1Button5 = new ToggleButtonPattern(200, 250, 100, 50, "empty - 5");
        ToggleButtonPattern empty1Button6 = new ToggleButtonPattern(510, 250, 100, 50, "empty - 6");
        ToggleButtonPattern empty1Button7 = new ToggleButtonPattern(660, 250, 100, 50, "empty - 7");

        ButtonsPattern selectAllButton = new ButtonsPattern(345, 175, 120, 125, "Select all");
        ButtonsPattern startLearningButton = new ButtonsPattern(345, 340, 120, 50, "Start learning");

        StartLearningButtonController startLearningButtonController = new StartLearningButtonController(generalDependence.getWorker()
                , coreButton, collectionButton, java8Button, IOandNIOButton, serializationButton);


        startLearningButton.setOnAction((event) -> {
            secondWindow.startWin();
            firstWindow.close();
            startLearningButtonController.startProg();
        });

        selectAllButton.setOnAction((event) -> {
            coreButton.setSelected(true);
            collectionButton.setSelected(true);
            java8Button.setSelected(true);
            IOandNIOButton.setSelected(true);
            serializationButton.setSelected(true);
            empty1Button1.setSelected(true);
            empty1Button2.setSelected(true);
            empty1Button3.setSelected(true);
            empty1Button4.setSelected(true);
            empty1Button5.setSelected(true);
            empty1Button6.setSelected(true);
            empty1Button7.setSelected(true);
        });

        Pane pane = new Pane();
        Scene scene = new Scene(pane, 800, 400);

        pane.getChildren().addAll(startLearningButton, coreButton, collectionButton, java8Button,
                IOandNIOButton, serializationButton, empty1Button1, empty1Button2, empty1Button3, empty1Button4,
                empty1Button5, empty1Button6, empty1Button7, selectAllButton, title);

        firstWindow.setScene(scene);
        firstWindow.setTitle("Start");
        firstWindow.setResizable(false);
        firstWindow.show();
    }
}