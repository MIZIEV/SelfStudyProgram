package prog;

import prog.controller.MainController;
import prog.model.MainModel;
import prog.view.windows.FirstWindow;
import prog.view.windows.SecondWindow;
import javafx.application.*;
import javafx.stage.*;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage myStage) {

        MainModel mainModel = new MainModel();
        MainController controller = new MainController(mainModel);

        FirstWindow firstWindow = new FirstWindow(mainModel);
        SecondWindow secondWindow = new SecondWindow(firstWindow, mainModel,controller);

        firstWindow.initWin(secondWindow);
    }
}