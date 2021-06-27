package View;

import Model.*;

public class GeneralDependence {

    private final DBWorker worker = new DBWorker();
    private final ListIndex listIndex = new ListIndex();

    public DBWorker getWorker() { return worker; }

    public ListIndex getListIndex() { return listIndex; }
}