package prog.controller.TButtonsControllers;

import prog.view.windows.FirstWindow;

public class SelectAllButtonController {

    private final FirstWindow firstWindow;

    public SelectAllButtonController(FirstWindow firstWindow) {
        this.firstWindow = firstWindow;
    }

    public void selectAllOrNothing() {
        if (firstWindow.getSelectAllButton().isSelected()) {

            firstWindow.getCoreButton().setSelected(true);
            firstWindow.getCollectionButton().setSelected(true);
            firstWindow.getJava8Button().setSelected(true);
            firstWindow.getIOandNIOButton().setSelected(true);
            firstWindow.getSerializationButton().setSelected(true);
            firstWindow.getMTButton().setSelected(true);
            firstWindow.getDataBaseButton().setSelected(true);
            firstWindow.getSQLButton().setSelected(true);
            firstWindow.getHTMLButton().setSelected(true);
            firstWindow.getCSSButton().setSelected(true);
            firstWindow.getJDBCButton().setSelected(true);
            firstWindow.getXMLButton().setSelected(true);

        } else if (!firstWindow.getSelectAllButton().isSelected()) {

            firstWindow.getCoreButton().setSelected(false);
            firstWindow.getCollectionButton().setSelected(false);
            firstWindow.getJava8Button().setSelected(false);
            firstWindow.getIOandNIOButton().setSelected(false);
            firstWindow.getSerializationButton().setSelected(false);
            firstWindow.getMTButton().setSelected(false);
            firstWindow.getDataBaseButton().setSelected(false);
            firstWindow.getSQLButton().setSelected(false);
            firstWindow.getHTMLButton().setSelected(false);
            firstWindow.getCSSButton().setSelected(false);
            firstWindow.getJDBCButton().setSelected(false);
            firstWindow.getXMLButton().setSelected(false);
        }
    }
}