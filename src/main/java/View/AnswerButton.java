package View;

import DataBase.RandomDigit;
import DataBase.StringFromDB;
import javafx.event.*;
import javafx.scene.control.*;

import java.util.ArrayList;

public class AnswerButton extends Button {

    private ArrayList<StringFromDB> QAList;
    private OutputText outputText;
    private RandomDigit digit;
    private int answerDigit;

    public AnswerButton(OutputText output, ArrayList<StringFromDB> list, RandomDigit d) {
        this.outputText = output;
        this.QAList = list;
        this.digit = d;

        this.setText("Answer");
        this.setLayoutX(840);
        this.setLayoutY(715);
        this.setPrefSize(89, 50);
    }

    public void buttonAction() {
        this.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                answerDigit = digit.getDigit();
                outputText.setText(QAList.get(answerDigit).getIndex() + " - " +
                        QAList.get(answerDigit).getAnswer());
            }
        });
    }
}