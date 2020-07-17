package jsh.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class TextList extends Item {

    private StringProperty title = new SimpleStringProperty("");
    private ObservableList<String> contents;

    public void setTitle(StringProperty title) {
        this.title = title;
    }

    public StringProperty getTitle() {
        return title;
    }

    public ObservableList<String> getContents() {
        return contents;
    }

    public void setContents(ObservableList<String> contents) {
        this.contents = contents;
    }
}
