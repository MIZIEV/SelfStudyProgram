package Controller.TButtonsControllers;

import View.FirstWindowConstructor;

public class SABController {
   FirstWindowConstructor firstWindowConstructor;

    public SABController(FirstWindowConstructor firstWindow) {
        this.firstWindowConstructor = firstWindow;


        if (firstWindow.getSelectAllButton().isSelected()) {

            firstWindow.getCoreButton().setSelected(true);
            firstWindow.getCollectionButton().setSelected(true);
            firstWindow.getJava8Button().setSelected(true);
            firstWindow.getIOandNIOButton().setSelected(true);
            firstWindow.getSerializationButton().setSelected(true);
            firstWindow.getEmpty1Button1().setSelected(true);
            firstWindow.getEmpty1Button2().setSelected(true);
            firstWindow.getEmpty1Button3().setSelected(true);
            firstWindow.getEmpty1Button4().setSelected(true);
            firstWindow.getEmpty1Button5().setSelected(true);
            firstWindow.getEmpty1Button6().setSelected(true);
            firstWindow.getEmpty1Button7().setSelected(true);

        } else if (!firstWindow.getSelectAllButton().isSelected()) {

            firstWindow.getCoreButton().setSelected(false);
            firstWindow.getCollectionButton().setSelected(false);
            firstWindow.getJava8Button().setSelected(false);
            firstWindow.getIOandNIOButton().setSelected(false);
            firstWindow.getSerializationButton().setSelected(false);
            firstWindow.getEmpty1Button1().setSelected(false);
            firstWindow.getEmpty1Button2().setSelected(false);
            firstWindow.getEmpty1Button3().setSelected(false);
            firstWindow.getEmpty1Button4().setSelected(false);
            firstWindow.getEmpty1Button5().setSelected(false);
            firstWindow.getEmpty1Button6().setSelected(false);
            firstWindow.getEmpty1Button7().setSelected(false);
        }
    }
}