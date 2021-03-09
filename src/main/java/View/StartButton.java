package View;

import DataBase.*;
import javafx.event.*;
import javafx.scene.control.*;

import java.util.*;

public class StartButton extends Button {

    private final OutputText outputText;               //todo why final????
    private final RandomDigit digit;
    private final ArrayList<StringFromDB> QAList;
    private int startDigit;

    public StartButton(OutputText output, ArrayList<StringFromDB> list, RandomDigit d) {

        this.outputText = output;
        this.QAList = list;
        this.digit = d;

        this.setText("Start");
        this.setLayoutX(475);
        this.setLayoutY(715);
        this.setPrefSize(80, 50);
    }

    public void buttonAction() {
        this.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                startDigit = 0;

                outputText.setText(QAList.get(startDigit).getIndex() + " - "
                        + QAList.get(startDigit).getQuestion());

                digit.setDigit(startDigit);
            }
        });
    }
}