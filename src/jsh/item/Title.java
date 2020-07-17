package jsh.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Title extends Item {

    private StringProperty title = new SimpleStringProperty("");

    public void setTitle(StringProperty title) {
        this.title = title;
    }

    public StringProperty getTitle() {
        return title;
    }
}
