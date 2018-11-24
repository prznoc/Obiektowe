package lab7.zad1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.text.Text;


public class Gui extends Application {
    public void start(Stage stage){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(0, 0, 0, 0));
        grid.setVgap(5);
        grid.setHgap(5);

        final TextField name = new TextField();
        name.setPromptText("Współczynniki wielomianów oddzielone przecinkami");
        name.setPrefWidth(400);
        GridPane.setConstraints(name, 0, 0);
        grid.getChildren().add(name);

        final TextField range = new TextField();
        range.setPromptText("Zakres osi X (np.'-10-10)");
        GridPane.setConstraints(range, 0, 1);
        grid.getChildren().add(range);

        final TextField comment = new TextField();
        comment.setPromptText("Częstotliwość próbkowania");
        GridPane.setConstraints(comment, 0, 2);
        grid.getChildren().add(comment);

        Text text = new Text();
        GridPane.setConstraints(text, 0, 3);
        grid.getChildren().add(text);

        Button draw = new Button("Draw");
        GridPane.setConstraints(draw, 0, 4);
        grid.getChildren().add(draw);

        Scene scene = new Scene(grid, grid.getMinHeight(), grid.getMinWidth());
        stage.setScene(scene);
        stage.setX(100);
        stage.setY(100);
        stage.show();

        draw.setOnAction(action -> {
            String str1, str2, str3;
            str1 = name.getText();
            str2 = range.getText();
            str3 = comment.getText();
            try{
                Drawer dr = createDrawing(str1, str2, str3);
                dr.start(stage);
            }
            catch (IllegalArgumentException e){
                text.setText("  Złe argumenty, spróbuj ponownie");
            }
            catch(Exception e){
                e.printStackTrace();
                stage.close();
            }
        });
    }
    private Drawer createDrawing(String str1, String str2, String str3) throws Exception{
        String[] s1 = str1.split(",");
        String[] s2 = str2.split(",");
        if (s2.length != 2) throw new IllegalArgumentException();
        int[] wspol = new int[s1.length];
        double[] zakres = new double[2];
        for (int i = s1.length; i>0; --i){
            try {
                wspol[i-1] = Integer.parseInt(s1[s1.length - i]);
            }
            catch (Exception e){
                throw new IllegalArgumentException();
            }
        }
        for (int i = 0; i<2; ++i){
            try {
                zakres[i]=Double.parseDouble(s2[i]);
            }
            catch(Exception e){
                throw new IllegalArgumentException();
            }
        }
        double hz;
        try{
            hz = Double.parseDouble(str3);
        }
        catch(Exception e){
            throw new IllegalArgumentException();
        }
        Poly poly = new Poly(wspol, zakres, hz);
        return new Drawer(poly);
    }

    public static void main(String[] args) {
        Gui.launch(args);
    }
}

