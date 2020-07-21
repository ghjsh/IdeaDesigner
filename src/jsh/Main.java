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
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import jsh.item.*;
import jsh.item.Process;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.*;

public class Main extends Application {

    public final String APP_NAME = "IdeaDesigner";
    public final String APP_VERSION = "0.2.1";

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
        controller.initialize_();

        Scene scene = new Scene(root);
        JMetro jMetro = new JMetro(scene, Style.DARK);
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
            OutputStream writer1 = new FileOutputStream(new File(directory, "master.css"));
            OutputStream writer2 = new FileOutputStream(new File(directory, "jquery.js"));
            OutputStream writer3 = new FileOutputStream(new File(directory, "a.ttf"));
            OutputStream writer4 = new FileOutputStream(new File(directory, "b.ttf"));
            IOUtils.copyLarge(Main.class.getResourceAsStream("/html/master.css"), writer1);
            IOUtils.copyLarge(Main.class.getResourceAsStream("/html/jquery.js"), writer2);
            IOUtils.copyLarge(Main.class.getResourceAsStream("/font/a.ttf"), writer3);
            IOUtils.copyLarge(Main.class.getResourceAsStream("/font/b.ttf"), writer4);
            writer1.flush();
            writer2.flush();
            writer3.flush();
            writer4.flush();
        } catch (IOException e) {
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
                    data.put("subtitle", ((Title) item).getSubtitle().get());
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
                    data.put("contents", ((Process) item).getContents());
//                } else if (item instanceof Image) {
                } else if (item instanceof Block) {
                    template = config.getTemplate("/html/block.ftl");
                    data.put("title", ((Block) item).getTitle().get());
                    data.put("contents", ((Block) item).getContents());
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
