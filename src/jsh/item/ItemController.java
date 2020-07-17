package jsh.item;

import javafx.scene.control.TitledPane;
import jsh.Main;

public class ItemController<T extends Item> {

    protected Main main;
    protected T item;
    protected TitledPane parent;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setParent(TitledPane parent) {
        this.parent = parent;
    }

    public void initialize_() {

    }
}
