package View;

import DataBase.*;
import javafx.event.*;
import javafx.scene.control.*;

import java.util.*;

public class NextButton extends Button {

    private final OutputText outputText;
    private final ErrorMassage errorMassage;
    private final ArrayList<StringFromDB> QAList;
    private final RandomDigit digit;
    private int nextDigit;

    public NextButton(OutputText output, ArrayList<StringFromDB> list, RandomDigit d, ErrorMassage error) {

        this.outputText = output;
        this.QAList = list;
        this.digit = d;
        this.errorMassage = error;

        this.setText("Next");
        this.setLayoutX(940);
        this.setLayoutY(715);
        this.setPrefSize(80, 50);
    }

    public void buttonAction() {
        this.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                nextDigit = digit.getDigit();
                nextDigit++;

                if (nextDigit > QAList.size() - 1){
                    nextDigit = QAList.size() - 1;
                    errorMassage.setText("This is the last question");
                }
                outputText.setText(QAList.get(nextDigit).getIndex() + " - " +
                        QAList.get(nextDigit).getQuestion());

                digit.setDigit(nextDigit);
            }
        });
    }
}