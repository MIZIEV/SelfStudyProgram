package View.FirstWindow;

import Controller.ButtonsControllers.StartLearnButController;
import View.GeneralDependence;
import View.SecondWindow.SecondWindow;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FirstWindow {

    private SecondWindow secondWindow;
    private final Stage firstWindow = new Stage();
    private final GeneralDependence generalDependence;

    private final static short PREFERRED_DECORATE_PANEL_HEIGHT = 150;
    private final static short PREFERRED_DECORATE_PANEL_WIDTH = 200;
    private final static short PREFERRED_HBOX_HEIGHT = 150;
    private final static short PREFERRED_HBOX_WIDTH = 300;
    private final static short PREFERRED_WINDOW_WIDTH = 800;
    private final static short PREFERRED_WINDOW_HEIGHT = 600;
    private final static short MIN_WINDOW_WIDTH = 650;
    private final static short MIN_WINDOW_HEIGHT = 450;
    private final static byte INTERVAL = 10;

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

        BorderPane generalPane = new BorderPane();            // create general pane

        BorderPane insertTopPane = new BorderPane();          // set decorate top & bottom panel with title
        insertTopPane.setPrefSize(PREFERRED_DECORATE_PANEL_WIDTH, PREFERRED_DECORATE_PANEL_HEIGHT);
        Label title = new Label("Self study program");
        insertTopPane.setCenter(title);
        insertTopPane.getStyleClass().add("top-border-pane");

        BorderPane insertBottomPane = new BorderPane();
        insertBottomPane.setPrefSize(PREFERRED_DECORATE_PANEL_WIDTH, PREFERRED_DECORATE_PANEL_HEIGHT);
        insertBottomPane.setCenter(firstWinConstructor.getStartLearningButton());
        insertBottomPane.getStyleClass().add("bottom-border-pane");

        HBox leftHBox = new HBox(INTERVAL);                  //set left box with buttons
        VBox firstLiftVBox = new VBox(INTERVAL);
        VBox secondLeftVBox = new VBox(INTERVAL);
        leftHBox.setPrefSize(PREFERRED_HBOX_WIDTH, PREFERRED_HBOX_HEIGHT);
        leftHBox.setAlignment(Pos.CENTER);
        firstLiftVBox.setAlignment(Pos.CENTER);
        secondLeftVBox.setAlignment(Pos.CENTER);

        firstLiftVBox.getChildren().addAll(firstWinConstructor.getCoreButton(),
                firstWinConstructor.getSerializationButton(), firstWinConstructor.getHTMLButton());

        secondLeftVBox.getChildren().addAll(firstWinConstructor.getCollectionButton(),
                firstWinConstructor.getMTButton(), firstWinConstructor.getCSSButton());

        leftHBox.getChildren().addAll(firstLiftVBox, secondLeftVBox);

        HBox rightHBox = new HBox(INTERVAL);                        //set right box with buttons
        VBox firstRightVBox = new VBox(INTERVAL);
        VBox secondRightVBox = new VBox(INTERVAL);
        rightHBox.setPrefSize(PREFERRED_HBOX_WIDTH, PREFERRED_HBOX_HEIGHT);
        rightHBox.setAlignment(Pos.CENTER);
        firstRightVBox.setAlignment(Pos.CENTER);
        secondRightVBox.setAlignment(Pos.CENTER);

        firstRightVBox.getChildren().addAll(firstWinConstructor.getJava8Button(),
                firstWinConstructor.getDataBaseButton(), firstWinConstructor.getJDBCButton());

        secondRightVBox.getChildren().addAll(firstWinConstructor.getIOandNIOButton(),
                firstWinConstructor.getSQLButton(), firstWinConstructor.getXMLButton());

        rightHBox.getChildren().addAll(firstRightVBox, secondRightVBox);

        generalPane.setTop(insertTopPane);
        generalPane.setBottom(insertBottomPane);
        firstWinConstructor.getSelectAllButton().getStyleClass().add("selectAll-toggle-button");
        generalPane.setCenter(firstWinConstructor.getSelectAllButton());
        generalPane.setLeft(leftHBox);
        generalPane.setRight(rightHBox);

        Scene firstWindowScene = new Scene(generalPane, PREFERRED_WINDOW_WIDTH, PREFERRED_WINDOW_HEIGHT);
        firstWindowScene.getStylesheets().add(stylesheet);
        firstWindow.setMinWidth(MIN_WINDOW_WIDTH);
        firstWindow.setMinHeight(MIN_WINDOW_HEIGHT);
        firstWindow.setScene(firstWindowScene);
        firstWindow.setTitle("Self study program");
        firstWindow.getIcons().add(new Image("icon.jpg"));
        firstWindow.show();
    }
}