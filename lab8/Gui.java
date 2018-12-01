package lab8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.layout.ColumnConstraints;
import javafx.geometry.HPos;


public class Gui extends Application {

    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.setVgap(10);
        grid.setHgap(10);

        Text text = new Text();
        GridPane.setConstraints(text, 0, 0);
        text.setText("What do you want to do?");

        GridPane.setHalignment(text, HPos.CENTER);
        grid.getChildren().add(text);

        Button display = new Button("Display all books");
        GridPane.setConstraints(display, 0, 1);
        display.setMinWidth(150);
        GridPane.setHalignment(display, HPos.CENTER);
        grid.getChildren().add(display);

        Button si = new Button("Search by ISBN");
        GridPane.setConstraints(si, 0, 2);
        si.setMinWidth(150);
        GridPane.setHalignment(si, HPos.CENTER);
        grid.getChildren().add(si);

        Button au = new Button("Search by Author");
        GridPane.setConstraints(au, 0, 3);
        au.setMinWidth(150);
        GridPane.setHalignment(au, HPos.CENTER);
        grid.getChildren().add(au);

        Button add = new Button("Add new book");
        GridPane.setConstraints(add, 0, 4);
        add.setMinWidth(150);
        GridPane.setHalignment(add, HPos.CENTER);
        grid.getChildren().add(add);

        Scene scene = new Scene(grid, grid.getMinHeight(), grid.getMinWidth());
        stage.setScene(scene);
        stage.setX(500);
        stage.setY(300);
        stage.show();

        display.setOnAction(action -> {
            BookDisplayer disp = new BookDisplayer(0,"");
            Stage second_stage = new Stage();
            second_stage.setX(500);
            second_stage.setY(300);
            Scene second_scene = new Scene(disp.content,disp.content.getMinWidth(),disp.content.getMinHeight());
            second_stage.setScene(second_scene);
            second_stage.show();
        });

        si.setOnAction(action -> {
            Gettinger geto = new Gettinger(1);
            Stage second_stage = new Stage();
            Scene second_scene = new Scene(geto.content,geto.content.getMinWidth(),geto.content.getMinHeight());
            second_stage.setX(500);
            second_stage.setY(300);
            second_stage.setScene(second_scene);
            second_stage.show();
            geto.button.setOnAction(action2 ->{
                String str = geto.range.getText();
                BookDisplayer disp = new BookDisplayer(1, str);
                Scene third_scene = new Scene(disp.content,disp.content.getMinWidth(),disp.content.getMinHeight());
                second_stage.setScene(third_scene);
            });
        });

        au.setOnAction(action -> {
            Gettinger geto = new Gettinger(2);
            Stage second_stage = new Stage();
            Scene second_scene = new Scene(geto.content,geto.content.getMinWidth(),geto.content.getMinHeight());
            second_stage.setX(500);
            second_stage.setY(300);
            second_stage.setScene(second_scene);
            second_stage.show();
            geto.button.setOnAction(action2 ->{
                String str = geto.range.getText();
                BookDisplayer disp = new BookDisplayer(2, str);
                Scene third_scene = new Scene(disp.content,disp.content.getMinWidth(),disp.content.getMinHeight());
                second_stage.setScene(third_scene);
            });
        });

        add.setOnAction(action ->{
            Adder adder = new Adder();
            Stage second_stage = new Stage();
            Scene second_scene = new Scene(adder.content,adder.content.getMinWidth(),adder.content.getMinHeight());
            second_stage.setX(500);
            second_stage.setY(300);
            second_stage.setScene(second_scene);
            second_stage.show();
        });
    }


    public static void main(String[] args) {
        Gui.launch(args);
    }
}