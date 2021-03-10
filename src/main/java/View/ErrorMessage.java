package View;

import javafx.scene.control.*;

public class ErrorMessage extends TextArea {

     public ErrorMessage(){

         this.setLayoutX(885);
         this.setLayoutY(50);
         this.setPrefSize(135, 135);
         this.setEditable(false);
         this.setWrapText(true);
     }
}