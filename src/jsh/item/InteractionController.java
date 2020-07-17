package jsh.item;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InteractionController extends ItemController<Interaction> {

    @FXML
    private TextField title;
    @FXML
    private TextField leftTitle;
    @FXML
    private TextArea leftContent;
    @FXML
    private TextField rightTitle;
    @FXML
    private TextArea rightContent;

    public void initialize_() {
        Bindings.bindBidirectional(title.textProperty(), item.getTitle());

        if (item.getLeft() == null) item.setLeft(new Content("제목", "내용"));
        Bindings.bindBidirectional(leftTitle.textProperty(), item.getLeft().getTitle());
        Bindings.bindBidirectional(leftContent.textProperty(), item.getLeft().getContent());

        if (item.getRight() == null) item.setRight(new Content("제목", "내용"));
        Bindings.bindBidirectional(rightTitle.textProperty(), item.getRight().getTitle());
        Bindings.bindBidirectional(rightContent.textProperty(), item.getRight().getContent());
    }
}

