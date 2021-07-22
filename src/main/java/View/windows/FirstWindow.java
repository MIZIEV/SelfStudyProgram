package View.windows;

import Controller.ButtonsControllers.StartLearningtController;
import Controller.TButtonsControllers.SelectAllButtonController;
import Model.MainModel;
import View.patterns.controls.ButtonsPattern;
import View.patterns.containers.HBoxPattern;
import View.patterns.controls.TButtonPattern;
import View.patterns.containers.VBoxPattern;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FirstWindow {

    private SecondWindow secondWindow;
    private final MainModel mainModel;
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

    private final static byte CENTRAL_VBOX_SPACING = 10;

    private final static short PREF_WIDTH = 100;
    private final static short PREF_HEIGHT = 40;
    private final static short PREF_WIDTH_CENTRAL_BUTTON = 150;
    private final static short PREF_HEIGHT_CENTRAL_BUTTON = 60;

    private final static String WIN_TITLE = "Self study program";
    private final static String WIN_ICON = "icon.jpg";
    private final static String STYLE_FILE = "/Styles/FirstWindowStyle.css";
    private final static String SELECT_ALL_BUTTON_STYLE = "selectAll-toggle-button";
    private final static String TOP_BORDER_PANE_DECOR = "top-border-pane";
    private final static String BOTTOM_BORDER_PANE_DECOR = "bottom-border-pane";
    private final static String SC_LOAD_BUTTON = "button-load";

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
    private final ButtonsPattern loadButton = new ButtonsPattern(PREF_WIDTH_CENTRAL_BUTTON, PREF_HEIGHT_CENTRAL_BUTTON, "Load");

    public FirstWindow(MainModel genDependence) {
        this.mainModel = genDependence;
    }

    public void initWin(SecondWindow secWindow) {

        this.secondWindow = secWindow;
        //mainModel.getDBWorker().distributeLists();
        String stylesheet = getClass().getResource(STYLE_FILE).toExternalForm();
        selectAllButton.setTooltip(new Tooltip("Select at least one theme"));
        startLearningButton.setTooltip(new Tooltip("Select at least one theme"));
        selectAllButton.getStyleClass().add(SELECT_ALL_BUTTON_STYLE);
        loadButton.getStyleClass().add(SC_LOAD_BUTTON);
        LoadWindow loadWindow = new LoadWindow(this, mainModel);
        //________________________________________create main pane and add decorated elements
        BorderPane mainPane = new BorderPane();
        BorderPane insertTopPane = new BorderPane();
        VBoxPattern centralVBox = new VBoxPattern(Pos.CENTER, CENTRAL_VBOX_SPACING);
        insertTopPane.setPrefSize(PREFERRED_DECORATE_PANEL_WIDTH, PREFERRED_DECORATE_PANEL_HEIGHT);
        Label title = new Label(WIN_TITLE);
        insertTopPane.setCenter(title);
        insertTopPane.getStyleClass().add(TOP_BORDER_PANE_DECOR);

        BorderPane insertBottomPane = new BorderPane();
        insertBottomPane.setPrefSize(PREFERRED_DECORATE_PANEL_WIDTH, PREFERRED_DECORATE_PANEL_HEIGHT);
        insertBottomPane.setCenter(startLearningButton);
        insertBottomPane.getStyleClass().add(BOTTOM_BORDER_PANE_DECOR);
        //________________________________________set left box with buttons
        HBoxPattern leftHBox = new HBoxPattern(Pos.CENTER, INTERVAL);
        leftHBox.setPrefSize(PREFERRED_HBOX_WIDTH, PREFERRED_HBOX_HEIGHT);
        VBoxPattern firstLiftVBox = new VBoxPattern(Pos.CENTER, INTERVAL);
        VBoxPattern secondLeftVBox = new VBoxPattern(Pos.CENTER, INTERVAL);

        firstLiftVBox.getChildren().addAll(coreButton, serializationButton, HTMLButton);
        secondLeftVBox.getChildren().addAll(collectionButton, MTButton, CSSButton);
        leftHBox.getChildren().addAll(firstLiftVBox, secondLeftVBox);
        //________________________________________right box with buttons
        HBoxPattern rightHBox = new HBoxPattern(Pos.CENTER, INTERVAL);
        rightHBox.setPrefSize(PREFERRED_HBOX_WIDTH, PREFERRED_HBOX_HEIGHT);
        VBoxPattern firstRightVBox = new VBoxPattern(Pos.CENTER, INTERVAL);
        VBoxPattern secondRightVBox = new VBoxPattern(Pos.CENTER, INTERVAL);

        firstRightVBox.getChildren().addAll(java8Button, dataBaseButton, JDBCButton);
        secondRightVBox.getChildren().addAll(IOandNIOButton, SQLButton, XMLButton);
        rightHBox.getChildren().addAll(firstRightVBox, secondRightVBox);
        //________________________________________create all controllers
        SelectAllButtonController selectAllController = new SelectAllButtonController(this);
        StartLearningtController startLearnController = new StartLearningtController(mainModel.getDBWorker(),
                coreButton, collectionButton, java8Button, IOandNIOButton, serializationButton,
                MTButton, dataBaseButton, SQLButton, JDBCButton, XMLButton, HTMLButton, CSSButton);
        //________________________________________all listeners
        selectAllButton.setOnAction((event) -> selectAllController.selectAllOrNothing());

        startLearningButton.setOnAction((event) -> {
            if (startLearnController.ifNotSelected()) {
                secondWindow.initWin();
                firstWindow.close();
                startLearnController.startLearning();
            }
        });

        loadButton.setOnAction(event -> loadWindow.launchWin(secondWindow));
        //________________________________________add all view element
        centralVBox.getChildren().addAll(selectAllButton, loadButton);

        mainPane.setTop(insertTopPane);
        mainPane.setBottom(insertBottomPane);
        mainPane.setLeft(leftHBox);
        mainPane.setRight(rightHBox);
        mainPane.setCenter(centralVBox);

        Scene firstWindowScene = new Scene(mainPane, PREFERRED_WINDOW_WIDTH, PREFERRED_WINDOW_HEIGHT);
        firstWindowScene.getStylesheets().add(stylesheet);
        firstWindow.setMinWidth(MIN_WINDOW_WIDTH);
        firstWindow.setMinHeight(MIN_WINDOW_HEIGHT);
        firstWindow.setScene(firstWindowScene);
        firstWindow.setTitle(WIN_TITLE);
        firstWindow.getIcons().add(new Image(WIN_ICON));
        firstWindow.show();
    }

    public void closeWin() { firstWindow.close(); }

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