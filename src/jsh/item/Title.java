package jsh.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Title extends Item {

    private StringProperty title = new SimpleStringProperty("");
    private StringProperty subtitle = new SimpleStringProperty("");

    public void setTitle(StringProperty title) {
        this.title = title;
    }

    public StringProperty getTitle() {
        return title;
    }

    public StringProperty getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(StringProperty subtitle) {
        this.subtitle = subtitle;
    }
}
