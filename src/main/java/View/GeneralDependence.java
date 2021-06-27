package View;

import Model.*;

public class GeneralDependence {
    private final DBConnector connector = new DBConnector();
    private final DBWorker worker = new DBWorker(connector);
    private final ListIndex listIndex = new ListIndex();

    public DBWorker getWorker() { return worker; }

    public ListIndex getListIndex() { return listIndex; }
}