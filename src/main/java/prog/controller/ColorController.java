package prog.controller;

import prog.model.MainModel;

public class ColorController {
    private final MainModel model;

    public ColorController(MainModel model) {
        this.model=model;
    }

    public String selectTextColor() {
        int index = model.getListIndex().getIndex();

        if (model.getDBWorker().getBufferList().get(index).getYesNo() == 1) return "green-text-area";
        else if (model.getDBWorker().getBufferList().get(index).getYesNo() == -1) return "red-text-area";
        else return "default-text-area";
    }

    public String selectIndicatorColor(double progress) {

        if (progress < 0.3) return "red-progress-indicator";
        else if (progress > 0.3 & progress < 0.8) return "yellow-progress-indicator";
        else return "green-progress-indicator";
    }
}