package View;

import Controller.ButtonsControllers.StartLearnButController;
import Controller.TButtonsControllers.SelectAllButtonController;
import View.buttonsPatterns.ButtonsPattern;
import View.buttonsPatterns.TButtonPattern;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FirstWindow {

    private SecondWindow secondWindow;
    private final GeneralDependence generalDependence;
    private final Stage firstWindow = new Stage();

    private final static byte INTERVAL = 10;

    private final static short PREFERRED_DECORATE_PANEL_HEIGHT = 150;
    private final static short PREFERRED_DECORATE_PANEL_WIDTH = 200;
    private final static short PREFERRED_HBOX_HEIGHT = 150;
    private final static short PREFERRED_HBOX_WIDTH = 300;
    private final static short PREFERRED_WINDOW_WIDTH = 800;
    private final static short PREFERRED_WINDOW_HEIGHT = 600;
    private final static short MIN_WINDOW_WIDTH = 650;
    private final static short MIN_WINDOW_HEIGHT = 450;

    private final static short PREF_WIDTH = 100;
    private final static short PREF_HEIGHT = 40;
    private final static short PREF_WIDTH_CENTRAL_BUTTON = 150;
    private final static short PREF_HEIGHT_CENTRAL_BUTTON = 60;

    private final static String WIN_TITLE = "Self study program";
    private final static String WIN_ICON = "icon.jpg";
    private final static String SELECT_ALL_BUTTON_STYLE = "selectAll-toggle-button";
    private final static String TOP_BORDER_PANE_DECOR = "top-border-pane";
    private final static String BOTTOM_BORDER_PANE_DECOR = "bottom-border-pane";

    private final TButtonPattern coreButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "Core");
    private final TButtonPattern collectionButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "Collections");
    private final TButtonPattern java8Button = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "Java 8");
    private final TButtonPattern IOandNIOButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "IO/NIO");

    private final TButtonPattern serializationButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "Serialization");
    private final TButtonPattern MTButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "Multithreading");
    private final TButtonPattern dataBaseButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "Data base");
    private final TButtonPattern SQLButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "SQL");

    private final TButtonPattern HTMLButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "HTML");
    private final TButtonPattern CSSButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "CSS");
    private final TButtonPattern JDBCButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "JDBC");
    private final TButtonPattern XMLButton = new TButtonPattern(PREF_WIDTH, PREF_HEIGHT, "XML");

    private final TButtonPattern selectAllButton = new TButtonPattern(PREF_WIDTH_CENTRAL_BUTTON, PREF_HEIGHT_CENTRAL_BUTTON, "Select all");
    private final ButtonsPattern startLearningButton = new ButtonsPattern(PREF_WIDTH_CENTRAL_BUTTON, PREF_HEIGHT_CENTRAL_BUTTON, "Start learning");


    public FirstWindow(GeneralDependence genDependence) {
        this.generalDependence = genDependence;
    }

    public void startWindow(SecondWindow secWindow) {

        this.secondWindow = secWindow;

        generalDependence.getWorker().distributeLists();
        String stylesheet = getClass().getResource("/FirstWindowStyle.css").toExternalForm();
        selectAllButton.setTooltip(new Tooltip("Select at least one theme"));
        startLearningButton.setTooltip(new Tooltip("Select at least one theme"));
        selectAllButton.getStyleClass().add(SELECT_ALL_BUTTON_STYLE);
        //________________________________________create main pane and add decorated elements
        BorderPane mainPane = new BorderPane();
        BorderPane insertTopPane = new BorderPane();
        insertTopPane.setPrefSize(PREFERRED_DECORATE_PANEL_WIDTH, PREFERRED_DECORATE_PANEL_HEIGHT);
        Label title = new Label(WIN_TITLE);
        insertTopPane.setCenter(title);
        insertTopPane.getStyleClass().add(TOP_BORDER_PANE_DECOR);

        BorderPane insertBottomPane = new BorderPane();
        insertBottomPane.setPrefSize(PREFERRED_DECORATE_PANEL_WIDTH, PREFERRED_DECORATE_PANEL_HEIGHT);
        insertBottomPane.setCenter(startLearningButton);
        insertBottomPane.getStyleClass().add(BOTTOM_BORDER_PANE_DECOR);
        //________________________________________set left box with buttons
        HBox leftHBox = new HBox(INTERVAL);
        VBox firstLiftVBox = new VBox(INTERVAL);
        VBox secondLeftVBox = new VBox(INTERVAL);
        leftHBox.setPrefSize(PREFERRED_HBOX_WIDTH, PREFERRED_HBOX_HEIGHT);
        leftHBox.setAlignment(Pos.CENTER);
        firstLiftVBox.setAlignment(Pos.CENTER);
        secondLeftVBox.setAlignment(Pos.CENTER);

        firstLiftVBox.getChildren().addAll(coreButton, serializationButton, HTMLButton);
        secondLeftVBox.getChildren().addAll(collectionButton, MTButton, CSSButton);
        leftHBox.getChildren().addAll(firstLiftVBox, secondLeftVBox);

        //________________________________________right box with buttons
        HBox rightHBox = new HBox(INTERVAL);
        VBox firstRightVBox = new VBox(INTERVAL);
        firstRightVBox.setAlignment(Pos.CENTER);
        VBox secondRightVBox = new VBox(INTERVAL);
        secondRightVBox.setAlignment(Pos.CENTER);
        rightHBox.setPrefSize(PREFERRED_HBOX_WIDTH, PREFERRED_HBOX_HEIGHT);
        rightHBox.setAlignment(Pos.CENTER);

        firstRightVBox.getChildren().addAll(java8Button, dataBaseButton, JDBCButton);
        secondRightVBox.getChildren().addAll(IOandNIOButton, SQLButton, XMLButton);
        rightHBox.getChildren().addAll(firstRightVBox, secondRightVBox);

        //________________________________________create all controllers
        SelectAllButtonController selectAllController = new SelectAllButtonController(this);
        StartLearnButController startLearnController = new StartLearnButController(generalDependence.getWorker(),
                startLearningButton, coreButton, collectionButton, java8Button, IOandNIOButton, serializationButton,
                MTButton, dataBaseButton, SQLButton, JDBCButton, XMLButton, HTMLButton, CSSButton);

        //________________________________________all listeners
        selectAllButton.setOnAction((event) -> { selectAllController.selectAllOrNothing(); });

        startLearningButton.setOnAction((event) -> {
            if (startLearnController.ifNotSelected()) {
                secondWindow.startWin();
                firstWindow.close();
                startLearnController.startProg();
            }
        });
        //________________________________________add all view element
        mainPane.setTop(insertTopPane);
        mainPane.setBottom(insertBottomPane);
        mainPane.setLeft(leftHBox);
        mainPane.setRight(rightHBox);
        mainPane.setCenter(selectAllButton);

        Scene firstWindowScene = new Scene(mainPane, PREFERRED_WINDOW_WIDTH, PREFERRED_WINDOW_HEIGHT);
        firstWindowScene.getStylesheets().add(stylesheet);
        firstWindow.setMinWidth(MIN_WINDOW_WIDTH);
        firstWindow.setMinHeight(MIN_WINDOW_HEIGHT);
        firstWindow.setScene(firstWindowScene);
        firstWindow.setTitle(WIN_TITLE);
        firstWindow.getIcons().add(new Image(WIN_ICON));
        firstWindow.show();
    }

    public TButtonPattern getCoreButton() {
        return coreButton;
    }

    public TButtonPattern getCollectionButton() {
        return collectionButton;
    }

    public TButtonPattern getJava8Button() {
        return java8Button;
    }

    public TButtonPattern getIOandNIOButton() {
        return IOandNIOButton;
    }

    public TButtonPattern getSerializationButton() {
        return serializationButton;
    }

    public TButtonPattern getMTButton() {
        return MTButton;
    }

    public TButtonPattern getDataBaseButton() {
        return dataBaseButton;
    }

    public TButtonPattern getSQLButton() {
        return SQLButton;
    }

    public TButtonPattern getHTMLButton() {
        return HTMLButton;
    }

    public TButtonPattern getCSSButton() {
        return CSSButton;
    }

    public TButtonPattern getJDBCButton() {
        return JDBCButton;
    }

    public TButtonPattern getXMLButton() {
        return XMLButton;
    }

    public TButtonPattern getSelectAllButton() {
        return selectAllButton;
    }
}