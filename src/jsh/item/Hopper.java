package jsh.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Hopper extends Item {

    private StringProperty title = new SimpleStringProperty("");
    private ObservableList<Content> contents;
    private Content result;

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

    public Content getResult() {
        return result;
    }

    public void setResult(Content result) {
        this.result = result;
    }
}
