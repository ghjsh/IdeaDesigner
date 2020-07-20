package jsh;

import freemarker.core.HTMLOutputFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jsh.item.*;
import jsh.item.Process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.*;

public class Main extends Application {

    private final String APP_NAME = "IdeaDesigner";
    private final String APP_VERSION = "0.1.0";

    private final List<Item> itemList = new ArrayList<>();

    private Controller controller;
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/jfx/main.fxml"));
        BorderPane root = loader.load();
        controller = loader.getController();
        controller.setMain(this);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle(String.format("%s %s", APP_NAME, APP_VERSION));
        primaryStage.show();
    }

    public void addItem(String type) {
        switch (type) {
            case "제목":
                itemList.add(new Title());
                break;
            case "본문":
                itemList.add(new Body());
                break;
            case "목록":
                itemList.add(new TextList());
                break;
            case "사진":
                itemList.add(new Image());
                break;
            case "상호작용":
                itemList.add(new Interaction());
                break;
            case "깔때기":
                itemList.add(new Hopper());
                break;
            case "과정":
                itemList.add(new Process());
                break;
            case "블럭":
                itemList.add(new Block());
                break;
        }

        controller.syncContent(itemList);
    }

    //TODO convert \n to <br>
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void compileHTML(File directory) {
        try {
            directory.mkdirs();
            Files.copy(new File(Main.class.getResource("/image/down_arrow.svg").toURI()).toPath(), new File(directory, "down_arrow.svg").toPath());
            Files.copy(new File(Main.class.getResource("/image/right_arrow.svg").toURI()).toPath(), new File(directory, "right_arrow.svg").toPath());
            Files.copy(new File(Main.class.getResource("/image/hopper.svg").toURI()).toPath(), new File(directory, "hopper.svg").toPath());
            Files.copy(new File(Main.class.getResource("/html/master.css").toURI()).toPath(), new File(directory, "master.css").toPath());
            Files.copy(new File(Main.class.getResource("/html/jquery.js").toURI()).toPath(), new File(directory, "jquery.js").toPath());
            Files.copy(new File(Main.class.getResource("/font/a.ttf").toURI()).toPath(), new File(directory, "a.ttf").toPath());
            Files.copy(new File(Main.class.getResource("/font/b.ttf").toURI()).toPath(), new File(directory, "b.ttf").toPath());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        int i = 0;
        Configuration config = new Configuration(Configuration.VERSION_2_3_30);
        config.setOutputFormat(HTMLOutputFormat.INSTANCE);
        config.setDefaultEncoding("UTF-8");
        config.setClassForTemplateLoading(Main.class, "/");
        try {
            for (Item item : itemList) {
                Template template;
                Map<String, Object> data = new HashMap<>();
                FileWriter writer = new FileWriter(new File(directory, i + ".html"));

                if (item instanceof Title) {
                    template = config.getTemplate("/html/title.ftl");
                    data.put("title", ((Title) item).getTitle().get());
                    data.put("subtitle", "");
                } else if (item instanceof Body) {
                    template = config.getTemplate("/html/body.ftl");
                    data.put("title", ((Body) item).getTitle().get());
                    data.put("content", ((Body) item).getContent().get());
                } else if (item instanceof TextList) {
                    template = config.getTemplate("/html/text_list.ftl");
                    data.put("title", ((TextList) item).getTitle().get());
                    data.put("contents", ((TextList) item).getContents());
                } else if (item instanceof Hopper) {
                    template = config.getTemplate("/html/hopper.ftl");
                    data.put("title", ((Hopper) item).getTitle().get());
//                    Map<String, String> contents = new LinkedHashMap<>();
//                    for (Content content : ((Hopper) item).getContents()) contents.put(content.getTitle().get(), content.getContent().get());
                    data.put("contents", ((Hopper) item).getContents());
                    data.put("result_title", ((Hopper) item).getResult().getTitle().get());
                    data.put("result_content", ((Hopper) item).getResult().getContent().get());
                } else if (item instanceof Interaction) {
                    template = config.getTemplate("/html/interaction.ftl");
                    data.put("title", ((Interaction) item).getTitle().get());
                    data.put("left_title", ((Interaction) item).getLeft().getTitle().get());
                    data.put("right_title", ((Interaction) item).getRight().getTitle().get());
                    data.put("left_content", ((Interaction) item).getLeft().getContent().get());
                    data.put("right_content", ((Interaction) item).getRight().getContent().get());
                } else if (item instanceof Process) {
                    template = config.getTemplate("/html/process.ftl");
                    data.put("title", ((Process) item).getTitle().get());
                    Map<String, String> contents = new LinkedHashMap<>();
                    for (Content content : ((Process) item).getContents()) contents.put(content.getTitle().get(), content.getContent().get());
                    data.put("contents", contents);
//                } else if (item instanceof Image) {
                } else if (item instanceof Block) {
                    template = config.getTemplate("/html/block.ftl");
                    data.put("title", ((Block) item).getTitle().get());
                    Map<String, String> contents = new HashMap<>();
                    for (Content content : ((Block) item).getContents()) contents.put(content.getTitle().get(), content.getContent().get());
                    data.put("contents", contents);
                } else {
                    System.out.println("ERROR: item");
                    return;
                }

                template.process(data, writer);
                writer.flush();
                i++;
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public Stage getStage() {
        return stage;
    }
}
