package jsh.item;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class BodyController extends ItemController<Body> {

    @FXML
    private TextField title;
    @FXML
    private TextArea content;

    public void initialize_() {
        Bindings.bindBidirectional(title.textProperty(), item.getTitle());

        Bindings.bindBidirectional(content.textProperty(), item.getContent());
    }
}
