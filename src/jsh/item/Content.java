package jsh.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Content {

    private StringProperty title;
    private StringProperty content;

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

    public Content(String title, String content) {
        this.title = new SimpleStringProperty(title);
        this.content = new SimpleStringProperty(content);
    }
}
