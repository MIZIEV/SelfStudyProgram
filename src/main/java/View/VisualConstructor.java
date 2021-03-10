package View;

import javafx.event.*;
import javafx.scene.effect.*;
import javafx.scene.paint.Color;

public class VisualConstructor {

    private final ButtonsDependence dependence;
    private final OutputText outputText;
    private final ErrorMessage errorMessage;

    private final ButtonsPattern startButton = new ButtonsPattern(475, 715, 80, 50, "Start");
    private final ButtonsPattern nextButton = new ButtonsPattern(940, 715, 80, 50, "Next");
    private final ButtonsPattern previousButton = new ButtonsPattern(15, 715, 80, 50, "Previous");
    private final ButtonsPattern questionButton = new ButtonsPattern(105, 715, 80, 50, "Question");
    private final ButtonsPattern answerButton = new ButtonsPattern(840, 715, 80, 50, "Answer");
    private final ButtonsPattern yesButton = new ButtonsPattern(415, 715, 50, 50, "✓");
    private final ButtonsPattern noButton = new ButtonsPattern(565, 715, 50, 50, "✖");

    private final InnerShadow redEffect = new InnerShadow(20.0, Color.RED);
    private final InnerShadow greenEffect = new InnerShadow(20.0, Color.GREEN);

    public VisualConstructor(OutputText output, ErrorMessage error, ButtonsDependence dependence) {
        this.errorMessage = error;
        this.dependence = dependence;
        this.outputText = output;

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                output.setText(dependence.getStartButtonController().getTextFromList());
            }
        });

        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                output.setText(dependence.getNextButtonController().scrollText());

            }
        });

        previousButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                output.setText(dependence.getPreviousButtonController().scrollText());
            }
        });

        questionButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                output.setText(dependence.getQuestionButtonController().getRandomQuestion());
            }
        });

        answerButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                output.setText(dependence.getAnswerButtonController().getAnswer());
            }
        });

        yesButton.setEffect(greenEffect);
        yesButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                dependence.getYesButtonController().setYesNo();
            }
        });

        noButton.setEffect(redEffect);
        noButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                dependence.getYesButtonController().setYesNo();
            }
        });
    }

    public ButtonsPattern getStartButton() {
        return startButton;
    }

    public ButtonsPattern getNextButton() {
        return nextButton;
    }

    public ButtonsPattern getPreviousButton() {
        return previousButton;
    }

    public ButtonsPattern getQuestionButton() {
        return questionButton;
    }

    public ButtonsPattern getAnswerButton() {
        return answerButton;
    }

    public ButtonsPattern getYesButton() {
        return yesButton;
    }

    public ButtonsPattern getNoButton() {
        return noButton;
    }
}