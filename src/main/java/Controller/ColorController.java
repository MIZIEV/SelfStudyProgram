package Controller;

import Model.DBWorker;
import Model.ListIndex;

public class ColorController {
    private final DBWorker dbWorker;
    private final ListIndex listIndex;

    public ColorController(DBWorker worker, ListIndex index) {
        this.dbWorker = worker;
        this.listIndex = index;
    }

    public String selectTextColor() {
        int index = listIndex.getIndex();

        if (dbWorker.getBufferList().get(index).getYesNo() == 1) return "green-text-area";
        else if (dbWorker.getBufferList().get(index).getYesNo() == -1) return "red-text-area";
        else return "default-text-area";
    }

    public String selectIndicatorColor(double progress) {

        if (progress < 0.3) return "red-progress-indicator";
        else if (progress > 0.3 & progress < 0.8) return "yellow-progress-indicator";
        else return "green-progress-indicator";
    }
}