package jsh.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Body extends Item {

    private StringProperty title = new SimpleStringProperty("");
    private StringProperty content = new SimpleStringProperty("");

    public StringProperty getTitle() {
        return title;
    }

    public void setTitle(StringProperty title) {
        this.title = title;
    }

    public StringProperty getContent() {
        return content;
    }

    public void setContent(StringProperty content) {
        this.content = content;
    }
}
