package View;

import Controller.ButtonsControllers.StartLearningButtonController;
import javafx.scene.Scene;
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
        FirstWindowConstructor firstWindowConstructor = new FirstWindowConstructor(this, secondWindow);

        StartLearningButtonController startLearningButtonController = new StartLearningButtonController(
                generalDependence.getWorker(), firstWindowConstructor.getCoreButton(),
                firstWindowConstructor.getCollectionButton(), firstWindowConstructor.getJava8Button(),
                firstWindowConstructor.getIOandNIOButton(), firstWindowConstructor.getSerializationButton());


        firstWindowConstructor.getStartLearningButton().setOnAction((event) -> {
            secondWindow.startWin();
            firstWindow.close();
            startLearningButtonController.startProg();
        });

        Pane pane = new Pane();
        Scene scene = new Scene(pane, 800, 400);

        pane.getChildren().addAll(firstWindowConstructor.getStartLearningButton(),
                firstWindowConstructor.getCoreButton(), firstWindowConstructor.getCollectionButton(),
                firstWindowConstructor.getJava8Button(), firstWindowConstructor.getIOandNIOButton(),
                firstWindowConstructor.getSerializationButton(), firstWindowConstructor.getEmpty1Button1(),
                firstWindowConstructor.getEmpty1Button2(), firstWindowConstructor.getEmpty1Button3(),
                firstWindowConstructor.getEmpty1Button4(), firstWindowConstructor.getEmpty1Button5(),
                firstWindowConstructor.getEmpty1Button6(), firstWindowConstructor.getEmpty1Button7(),
                firstWindowConstructor.getSelectAllButton());

        firstWindow.setScene(scene);
        firstWindow.setTitle("Start");
        firstWindow.setResizable(false);
        firstWindow.show();
    }
}