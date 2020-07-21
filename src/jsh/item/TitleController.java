package jsh.item;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class TitleController extends ItemController<Title> {

    @FXML
    private TextField title;
    @FXML
    private TextField subtitle;

    public void initialize_() {
        Bindings.bindBidirectional(title.textProperty(), item.getTitle());
        Bindings.bindBidirectional(subtitle.textProperty(), item.getSubtitle());
    }
}
