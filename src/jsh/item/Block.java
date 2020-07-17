package jsh.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Block extends Item {

    private StringProperty title = new SimpleStringProperty("");
    private ObservableList<Content> contents;

    public void setTitle(StringProperty title) {
        this.title = title;
    }

    public StringProperty getTitle() {
        return title;
    }

    public ObservableList<Content> getContents() {
        return contents;
    }

    public void setContents(ObservableList<Content> contents) {
        this.contents = contents;
    }
}
