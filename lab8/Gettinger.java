package lab8;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.layout.ColumnConstraints;
import javafx.geometry.HPos;

class Gettinger {
    private final int mode;
    GridPane content;
    Button button;
    TextField range;

    Gettinger(int m){
        mode = m;
        content = getString();
    }
    private GridPane getString(){
        GridPane disp = new GridPane();
        disp.setPadding(new Insets(10, 10, 10, 10));
        disp.getColumnConstraints().add(new ColumnConstraints(200));
        disp.setVgap(10);
        disp.setHgap(10);

        Text text = new Text();
        GridPane.setConstraints(text, 0, 0);
        if (mode == 1)text.setText("Type desired ISBN");
        else if(mode == 2)text.setText("Type desired author");
        disp.getChildren().add(text);

        range = new TextField();
        range.setPromptText("");
        GridPane.setConstraints(range, 0, 1);
        disp.getChildren().add(range);

        button = new Button("Search");
        GridPane.setConstraints(button, 0, 2);
        GridPane.setHalignment(button, HPos.CENTER);
        disp.getChildren().add(button);

        return disp;
    }
}
