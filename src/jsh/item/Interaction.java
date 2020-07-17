package jsh.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Interaction extends Item {

    private StringProperty title = new SimpleStringProperty("");
    private Content left;
    private Content right;

    public StringProperty getTitle() {
        return title;
    }

    public void setTitle(StringProperty title) {
        this.title = title;
    }

    public Content getLeft() {
        return left;
    }

    public void setLeft(Content left) {
        this.left = left;
    }

    public Content getRight() {
        return right;
    }

    public void setRight(Content right) {
        this.right = right;
    }
}
