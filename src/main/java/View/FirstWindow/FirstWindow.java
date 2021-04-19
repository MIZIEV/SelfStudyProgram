package View.FirstWindow;

import Controller.ButtonsControllers.StartLearnButController;
import View.GeneralDependence;
import View.SecondWindow.SecondWindow;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
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
        String stylesheet = getClass().getResource("/FirstWindowStyle.css").toExternalForm();

        BorderPane generalPane = new BorderPane();

        BorderPane insertTopPane = new BorderPane();
        insertTopPane.setPrefSize(200, 150);
        Label title = new Label("Self learning program");
        insertTopPane.setCenter(title);
        insertTopPane.getStyleClass().add("top-border-pane");

        BorderPane insertBottomPane = new BorderPane();
        insertBottomPane.setPrefSize(200, 150);
        insertBottomPane.setCenter(firstWinConstructor.getStartLearningButton());
        insertBottomPane.getStyleClass().add("bottom-border-pane");

        HBox leftHBox = new HBox(10);
        VBox firstLiftVBox = new VBox(10);
        VBox secondLeftVBox = new VBox(10);
        leftHBox.setPrefSize(300,150);
        leftHBox.setAlignment(Pos.CENTER);
        firstLiftVBox.setAlignment(Pos.CENTER);
        secondLeftVBox.setAlignment(Pos.CENTER);

        firstLiftVBox.getChildren().addAll(firstWinConstructor.getCoreButton(),
                firstWinConstructor.getSerializationButton(), firstWinConstructor.getHTMLButton());

        secondLeftVBox.getChildren().addAll(firstWinConstructor.getCollectionButton(),
                firstWinConstructor.getMTButton(), firstWinConstructor.getCSSButton());

        leftHBox.getChildren().addAll(firstLiftVBox, secondLeftVBox);

        HBox rightHBox = new HBox(10);
        VBox firstRightVBox = new VBox(10);
        VBox secondRightVBox = new VBox(10);
        rightHBox.setPrefSize(300,150);
        rightHBox.setAlignment(Pos.CENTER);
        firstRightVBox.setAlignment(Pos.CENTER);
        secondRightVBox.setAlignment(Pos.CENTER);

        firstRightVBox.getChildren().addAll(firstWinConstructor.getJava8Button(),
                firstWinConstructor.getDataBaseButton(),firstWinConstructor.getJDBCButton());

        secondRightVBox.getChildren().addAll(firstWinConstructor.getIOandNIOButton(),
                firstWinConstructor.getSQLButton(),firstWinConstructor.getXMLButton());

        rightHBox.getChildren().addAll(firstRightVBox,secondRightVBox);

        generalPane.setTop(insertTopPane);
        generalPane.setBottom(insertBottomPane);
        firstWinConstructor.getSelectAllButton().getStyleClass().add("selectAll-toggle-button");
        generalPane.setCenter(firstWinConstructor.getSelectAllButton());
        generalPane.setLeft(leftHBox);
        generalPane.setRight(rightHBox);

        Scene firstWindowScene = new Scene(generalPane,800,600);
        firstWindowScene.getStylesheets().add(stylesheet);
        firstWindow.setScene(firstWindowScene);
        firstWindow.setTitle("Start");
        firstWindow.show();
    }
}