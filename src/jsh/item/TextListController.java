package jsh.item;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;

public class TextListController extends ItemController<TextList> {

    @FXML
    private TextField title;
    @FXML
    private ListView<String> list;

    @FXML
    private void addItem() {
        item.getContents().add("");
    }

    @FXML
    private void removeItem() {
        item.getContents().remove(list.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void editItem(ListView.EditEvent<String> event) {
        list.getItems().set(event.getIndex(), event.getNewValue());
    }

    public void initialize_() {
        if (item.getContents() == null) item.setContents(FXCollections.observableArrayList());
        list.setItems(item.getContents());

        list.setCellFactory(TextFieldListCell.forListView()); //TODO Line wrap

        Bindings.bindBidirectional(title.textProperty(), item.getTitle());
    }
}