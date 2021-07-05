package View;

import Controller.ButtonsControllers.LoadButtonController;
import View.buttonsPatterns.ButtonsPattern;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoadWindow {

    GeneralDependence generalDependence;

    public LoadWindow(GeneralDependence generalDependence) {
        this.generalDependence = generalDependence;
    }

    public void launchWin(SecondWindow secondWindow) {
        Stage window = new Stage();
        BorderPane mainPane = new BorderPane();

        LoadButtonController controller = new LoadButtonController(generalDependence.getWorker(), generalDependence.getJsonWorker());
        ButtonsPattern load = new ButtonsPattern(100, 80, "load");
        load.setOnAction(event -> {
            window.close();
            controller.startController();
            secondWindow.startWin();
        });
        mainPane.setCenter(load);
        Scene winScene = new Scene(mainPane, 800, 600);
        window.setScene(winScene);
        window.show();
    }
}