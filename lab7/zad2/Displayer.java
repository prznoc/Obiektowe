package lab7.zad2;

import java.io.File;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.FileInputStream;
import javafx.stage.Screen;

public class Displayer extends Application {

    public void start(Stage stage) throws Exception {
        final DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select directory with photos");
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File dir = directoryChooser.showDialog(stage);
        File[] files = dir.listFiles();

        FlowPane tile = new FlowPane();
        tile.setHgap(10);
        tile.setVgap(10);

        boolean empty_flag = false;
        for (File file : files) {
            if (isPhoto(file)) {
                empty_flag = true;
                Image image = new Image(new FileInputStream(file));
                ImageView iv = new ImageView();
                iv.setImage(image);
                iv.setFitWidth(200);
                iv.setPreserveRatio(true);
                tile.getChildren().add(iv);
                iv.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent event) {
                        VBox box = new VBox();
                        ImageView iv2 = new ImageView();
                        iv2.setImage(image);
                        iv2.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
                        iv2.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight()-30);
                        iv2.setPreserveRatio(true);
                        box.getChildren().addAll(iv2);
                        Stage sec = new Stage();
                        Scene addid = new Scene(box);
                        sec.setScene(addid);
                        sec.show();
                    }
                });
            }
        }

        ScrollPane root = new ScrollPane();
        root.setFitToWidth(true);
        root.setFitToHeight(true);
        root.setContent(tile);
        Scene scene = new Scene(root, 1500, 800);
        stage.setTitle("Displayer");
        stage.setScene(scene);
        stage.show();
        if (!empty_flag){
            System.out.println("Choose directory with photos");
            stage.close();
        }
    }

    private boolean isPhoto(File file){
        if(!file.isFile()) return false;
        String[] extension = {"jpg","bmp","png","jpeg","gif"};
        String name = file.getName();
        String ext = name.substring(name.lastIndexOf(".")+1, file.getName().length());
        for (String s: extension){
            if (s.equals(ext)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}