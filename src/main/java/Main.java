import View.FirstWindow.FirstWindow;
import View.GeneralDependence;
import View.SecondWindow.SecondWindow;
import javafx.application.*;
import javafx.stage.*;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage myStage) {

        GeneralDependence generalDependence = new GeneralDependence();

        FirstWindow firstWindow = new FirstWindow(generalDependence);
        SecondWindow secondWindow = new SecondWindow(generalDependence);

        firstWindow.startWindow(secondWindow);
    }
}