import Controller.*;
import DataBase.*;
import View.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage myStage) {

        GeneralDependence generalDependence = new GeneralDependence();

        FirstWindow firstWindow = new FirstWindow(generalDependence);
        SecondWindow secondWindow = new SecondWindow(generalDependence);

        firstWindow.startWindow(secondWindow);
    }
}