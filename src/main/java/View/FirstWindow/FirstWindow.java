package View.FirstWindow;

import Controller.ButtonsControllers.StartLearnButController;
import View.GeneralDependence;
import View.SecondWindow.SecondWindow;
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
        FirstWinConstructor firstWinConstructor = new FirstWinConstructor(this, secondWindow);

        StartLearnButController startLearnButController = new StartLearnButController(
                generalDependence.getWorker(), firstWinConstructor.getStartLearningButton(), firstWinConstructor.getCoreButton(),
                firstWinConstructor.getCollectionButton(), firstWinConstructor.getJava8Button(),
                firstWinConstructor.getIOandNIOButton(), firstWinConstructor.getSerializationButton(),
                firstWinConstructor.getMTButton(), firstWinConstructor.getDataBaseButton(),
                firstWinConstructor.getSQLButton(), firstWinConstructor.getJDBCButton(),
                firstWinConstructor.getXMLButton(), firstWinConstructor.getHTMLButton(),
                firstWinConstructor.getCSSButton());

        firstWinConstructor.getStartLearningButton().setOnAction((event) -> {
            if (startLearnButController.ifNotSelected()) {
                secondWindow.startWin();
                firstWindow.close();
                startLearnButController.startProg();
            }
        });

        Pane pane = new Pane();
        Scene scene = new Scene(pane, 800, 400);

        pane.getChildren().addAll(firstWinConstructor.getStartLearningButton(),
                firstWinConstructor.getCoreButton(), firstWinConstructor.getCollectionButton(),
                firstWinConstructor.getJava8Button(), firstWinConstructor.getIOandNIOButton(),
                firstWinConstructor.getSerializationButton(), firstWinConstructor.getMTButton(),
                firstWinConstructor.getDataBaseButton(), firstWinConstructor.getSQLButton(),
                firstWinConstructor.getHTMLButton(), firstWinConstructor.getCSSButton(),
                firstWinConstructor.getJDBCButton(), firstWinConstructor.getXMLButton(),
                firstWinConstructor.getSelectAllButton());

        firstWindow.setScene(scene);
        firstWindow.setTitle("Start");
        firstWindow.setResizable(false);
        firstWindow.show();
    }
}