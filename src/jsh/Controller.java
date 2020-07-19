package jsh;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import jsh.item.*;
import jsh.item.Image;
import jsh.item.Process;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {

    @FXML
    private TreeView<String> itemList;
    @FXML
    private VBox content;
    @FXML
    private Label title;

    private Main main;

    @SuppressWarnings("unchecked")
    @FXML
    private void initialize() {
        TreeItem<String> root = new TreeItem<>("사용할 수 있는 아이템");
        TreeItem<String> text = new TreeItem<>("텍스트");
        TreeItem<String> title = new TreeItem<>("제목");
        TreeItem<String> body = new TreeItem<>("본문");
        TreeItem<String> textList = new TreeItem<>("목록");
        TreeItem<String> image = new TreeItem<>("사진");
        TreeItem<String> graphic = new TreeItem<>("그래픽");
        TreeItem<String> interaction = new TreeItem<>("상호작용");
        TreeItem<String> hopper = new TreeItem<>("깔때기");
        TreeItem<String> process = new TreeItem<>("과정");
        TreeItem<String> block = new TreeItem<>("블럭");

        root.getChildren().addAll(text, image, graphic);
        root.setExpanded(true);
        text.getChildren().addAll(title, body, textList);
        text.setExpanded(true);
        graphic.getChildren().addAll(interaction, hopper, process, block);
        graphic.setExpanded(true);

        itemList.setRoot(root);
    }

    @FXML
    private File export() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File directory = directoryChooser.showDialog(main.getStage());
        main.compileHTML(directory);
        return directory;
    }

    @FXML
    private void exportOpen() {
    }

    @FXML
    private void addItem(MouseEvent event) {
        String selected = itemList.getSelectionModel().getSelectedItem().getValue();
        if (event.getClickCount() != 2) {
            return;
        } else if (selected.equals("사용할 수 있는 아이템") || selected.equals("텍스트") || selected.equals("그래픽")) {
            return;
        }

        main.addItem(selected);
    }

    @FXML
    private void deleteItem() {

    }

    @FXML
    private void design() {

    }

    @FXML
    private void moveItemUp() {

    }

    @FXML
    private void moveItemDown() {

    }

    public void setMain(Main main) {
        this.main = main;
    }


    //TODO Keep the content's folding state
    public void syncContent(List<Item> list) {
        List<Node> contentChildren = content.getChildren();
        contentChildren.clear();

        for (Item i : list) {
            if (i instanceof Block) contentChildren.add(generateItem(i, "/jfx/block.fxml", "그래픽 : 블럭", main));
            else if (i instanceof Body) contentChildren.add(generateItem(i, "/jfx/body.fxml", "텍스트 : 본문", main));
            else if (i instanceof Hopper) contentChildren.add(generateItem(i, "/jfx/hopper.fxml", "그래픽 : 깔때기", main));
            else if (i instanceof Image) contentChildren.add(generateItem(i, "/jfx/image.fxml", "사진", main));
            else if (i instanceof Interaction) contentChildren.add(generateItem(i, "/jfx/interaction.fxml", "그래픽 : 상호작용", main));
            else if (i instanceof TextList) contentChildren.add(generateItem(i, "/jfx/text_list.fxml", "텍스트 : 목록", main));
            else if (i instanceof Process) contentChildren.add(generateItem(i, "/jfx/process.fxml", "그래픽 : 과정", main));
            else if (i instanceof Title) contentChildren.add(generateItem(i, "/jfx/title.fxml", "텍스트 : 제목", main));
        }
    }

    private <T extends Item> TitledPane generateItem(T item, String resourceURL, String title, Main main) {
        try {
            TitledPane titledPane = new TitledPane();
            FXMLLoader fxmlLoader = new FXMLLoader();
            GridPane root;

            titledPane.setText(title);
            fxmlLoader.setLocation(Controller.class.getResource(resourceURL));
            root = fxmlLoader.load();
            fxmlLoader.<ItemController<T>>getController().setItem(item);
            fxmlLoader.<ItemController<T>>getController().setMain(main);
            fxmlLoader.<ItemController<T>>getController().setParent(titledPane);
            titledPane.setContent(root);
            fxmlLoader.<ItemController<T>>getController().initialize_();

            root.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
            root.prefWidthProperty().bind(titledPane.widthProperty().multiply(0.9f));
            return titledPane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
