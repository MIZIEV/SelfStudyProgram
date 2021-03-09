package View;

import DataBase.RandomDigit;
import DataBase.StringFromDB;
import javafx.event.*;
import javafx.scene.control.*;

import java.util.ArrayList;

public class   QuestionButton extends Button {

    private final OutputText outputText;
    private final ArrayList<StringFromDB> QAList;
    private final RandomDigit digit;
    private int questionDigit;

    public QuestionButton(OutputText output, ArrayList<StringFromDB> list, RandomDigit d) {

        this.outputText = output;
        this.QAList = list;
        this.digit = d;

        this.setText("Question");
        this.setLayoutX(105);
        this.setLayoutY(715);
        this.setPrefSize(89, 50);
    }

    public void buttonAction() {
        this.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                questionDigit = (int) (Math.random() * QAList.size());

                outputText.setText(QAList.get(questionDigit).getIndex() + " - "
                        + QAList.get(questionDigit).getQuestion());

                digit.setDigit(questionDigit);
            }
        });
    }
}