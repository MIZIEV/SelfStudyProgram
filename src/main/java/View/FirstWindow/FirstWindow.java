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
        FirstWinButtonsCollection firstWinButtonsCollection = new FirstWinButtonsCollection(this, secondWindow);

        StartLearnButController startLearnButController = new StartLearnButController(
                generalDependence.getWorker(), firstWinButtonsCollection.getStartLearningButton(), firstWinButtonsCollection.getCoreButton(),
                firstWinButtonsCollection.getCollectionButton(), firstWinButtonsCollection.getJava8Button(),
                firstWinButtonsCollection.getIOandNIOButton(), firstWinButtonsCollection.getSerializationButton(),
                firstWinButtonsCollection.getMTButton(), firstWinButtonsCollection.getDataBaseButton(),
                firstWinButtonsCollection.getSQLButton(), firstWinButtonsCollection.getJDBCButton(),
                firstWinButtonsCollection.getXMLButton(), firstWinButtonsCollection.getHTMLButton(),
                firstWinButtonsCollection.getCSSButton());

        firstWinButtonsCollection.getStartLearningButton().setOnAction((event) -> {
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
        insertBottomPane.setCenter(firstWinButtonsCollection.getStartLearningButton());
        insertBottomPane.getStyleClass().add("bottom-border-pane");

        HBox leftHBox = new HBox(INTERVAL);                  //set left box with buttons
        VBox firstLiftVBox = new VBox(INTERVAL);
        VBox secondLeftVBox = new VBox(INTERVAL);
        leftHBox.setPrefSize(PREFERRED_HBOX_WIDTH, PREFERRED_HBOX_HEIGHT);
        leftHBox.setAlignment(Pos.CENTER);
        firstLiftVBox.setAlignment(Pos.CENTER);
        secondLeftVBox.setAlignment(Pos.CENTER);

        firstLiftVBox.getChildren().addAll(firstWinButtonsCollection.getCoreButton(),
                firstWinButtonsCollection.getSerializationButton(), firstWinButtonsCollection.getHTMLButton());

        secondLeftVBox.getChildren().addAll(firstWinButtonsCollection.getCollectionButton(),
                firstWinButtonsCollection.getMTButton(), firstWinButtonsCollection.getCSSButton());

        leftHBox.getChildren().addAll(firstLiftVBox, secondLeftVBox);

        HBox rightHBox = new HBox(INTERVAL);                        //set right box with buttons
        VBox firstRightVBox = new VBox(INTERVAL);
        VBox secondRightVBox = new VBox(INTERVAL);
        rightHBox.setPrefSize(PREFERRED_HBOX_WIDTH, PREFERRED_HBOX_HEIGHT);
        rightHBox.setAlignment(Pos.CENTER);
        firstRightVBox.setAlignment(Pos.CENTER);
        secondRightVBox.setAlignment(Pos.CENTER);

        firstRightVBox.getChildren().addAll(firstWinButtonsCollection.getJava8Button(),
                firstWinButtonsCollection.getDataBaseButton(), firstWinButtonsCollection.getJDBCButton());

        secondRightVBox.getChildren().addAll(firstWinButtonsCollection.getIOandNIOButton(),
                firstWinButtonsCollection.getSQLButton(), firstWinButtonsCollection.getXMLButton());

        rightHBox.getChildren().addAll(firstRightVBox, secondRightVBox);

        generalPane.setTop(insertTopPane);
        generalPane.setBottom(insertBottomPane);
        firstWinButtonsCollection.getSelectAllButton().getStyleClass().add("selectAll-toggle-button");
        generalPane.setCenter(firstWinButtonsCollection.getSelectAllButton());
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