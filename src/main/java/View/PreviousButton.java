package View;

import DataBase.RandomDigit;
import DataBase.StringFromDB;
import javafx.scene.control.*;
import javafx.event.*;

import java.util.ArrayList;

public class PreviousButton extends Button {

    private final OutputText outputText;
    private final ErrorMassage errorMassage;
    private final ArrayList<StringFromDB> QAList;
    private final RandomDigit digit;
    private int previousDigit;

    public PreviousButton(OutputText output, ArrayList<StringFromDB> list, RandomDigit d, ErrorMassage error) {
        this.outputText = output;
        this.QAList = list;
        this.digit = d;
        this.errorMassage = error;

        this.setText("Previous");
        this.setLayoutX(15);
        this.setLayoutY(715);
        this.setPrefSize(80, 50);
    }

    public void buttonAction() {
        this.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                previousDigit = digit.getDigit();
                previousDigit--;

                if (previousDigit < 0) {
                    previousDigit = 0;
                    errorMassage.setText("It si a first question!!!");
                }
                outputText.setText(QAList.get(previousDigit).getIndex() + " - "
                        + QAList.get(previousDigit).getQuestion());
                digit.setDigit(previousDigit);
            }
        });
    }
}