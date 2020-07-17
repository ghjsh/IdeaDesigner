package jsh.item;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

public class ProcessController extends ItemController<Process> {

    @FXML
    private TextField title;
    @FXML
    private TableColumn<Content, String> itemTitle;
    @FXML
    private TableColumn<Content, String> itemContent;
    @FXML
    private TableView<Content> table;

    @FXML
    private void addItem() {
        item.getContents().add(new Content("제목", "내용"));
    }

    @FXML
    private void removeItem() {
        item.getContents().remove(table.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void editItemTitle(TableColumn.CellEditEvent<Content, String> event) {
        table.getItems().get(event.getTablePosition().getRow()).getTitle().set(event.getNewValue());
    }

    @FXML
    private void editItemContent(TableColumn.CellEditEvent<Content, String> event) {
        table.getItems().get(event.getTablePosition().getRow()).getContent().set(event.getNewValue());
    }

    public void initialize_() {
        if (item.getContents() == null) item.setContents(FXCollections.observableArrayList());
        table.setItems(item.getContents());

        itemTitle.setCellValueFactory(cellData -> cellData.getValue().getTitle());
        itemContent.setCellValueFactory(cellData -> cellData.getValue().getContent());
        itemTitle.setCellFactory(TextFieldTableCell.forTableColumn());
        itemContent.setCellFactory(TextFieldTableCell.forTableColumn());

        Bindings.bindBidirectional(title.textProperty(), item.getTitle());
    }
}

