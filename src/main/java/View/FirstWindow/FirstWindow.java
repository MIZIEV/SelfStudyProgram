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
        FirstWindowConstructor firstWindowConstructor = new FirstWindowConstructor(this, secondWindow);

        StartLearnButController startLearnButController = new StartLearnButController(
                generalDependence.getWorker(), firstWindowConstructor.getCoreButton(),
                firstWindowConstructor.getCollectionButton(), firstWindowConstructor.getJava8Button(),
                firstWindowConstructor.getIOandNIOButton(), firstWindowConstructor.getSerializationButton(),
                firstWindowConstructor.getMTButton(),firstWindowConstructor.getDataBaseButton(),
                firstWindowConstructor.getSQLButton(),firstWindowConstructor.getJDBCButton(),
                firstWindowConstructor.getXMLButton(),firstWindowConstructor.getHTMLButton(),
                firstWindowConstructor.getCSSButton());

        firstWindowConstructor.getStartLearningButton().setOnAction((event) -> {
            secondWindow.startWin();
            firstWindow.close();
            startLearnButController.startProg();
        });

        Pane pane = new Pane();
        Scene scene = new Scene(pane, 800, 400);

        pane.getChildren().addAll(firstWindowConstructor.getStartLearningButton(),
                firstWindowConstructor.getCoreButton(), firstWindowConstructor.getCollectionButton(),
                firstWindowConstructor.getJava8Button(), firstWindowConstructor.getIOandNIOButton(),
                firstWindowConstructor.getSerializationButton(), firstWindowConstructor.getMTButton(),
                firstWindowConstructor.getDataBaseButton(), firstWindowConstructor.getSQLButton(),
                firstWindowConstructor.getHTMLButton(), firstWindowConstructor.getCSSButton(),
                firstWindowConstructor.getJDBCButton(), firstWindowConstructor.getXMLButton(),
                firstWindowConstructor.getSelectAllButton());

        firstWindow.setScene(scene);
        firstWindow.setTitle("Start");
        firstWindow.setResizable(false);
        firstWindow.show();
    }
}