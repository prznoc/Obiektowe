package lab8;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import java.sql.SQLException;
import javafx.scene.control.ScrollPane;

class Adder {
    ScrollPane content;
    Adder(){
        content = get();
    }
    private ScrollPane get(){
        GridPane disp = new GridPane();
        disp.setPadding(new Insets(10, 10, 10, 10));
        disp.setVgap(10);
        disp.setHgap(10);

        Text text = new Text();
        GridPane.setConstraints(text, 0, 0);
        text.setText("Fill fields about new book:");
        disp.getChildren().add(text);

        Text text1 = new Text();
        GridPane.setConstraints(text1, 0, 1);
        text1.setText("ISBN:");
        disp.getChildren().add(text1);

        TextField isbn = new TextField();
        isbn.setPromptText("");
        GridPane.setConstraints(isbn, 1, 1);
        disp.getChildren().add(isbn);

        Text text2 = new Text();
        GridPane.setConstraints(text2, 0, 2);
        text2.setText("Title:");
        disp.getChildren().add(text2);

        TextField title = new TextField();
        title.setPromptText("");
        GridPane.setConstraints(title, 1, 2);
        disp.getChildren().add(title);

        Text text3 = new Text();
        GridPane.setConstraints(text3, 0, 3);
        text3.setText("Author:");
        disp.getChildren().add(text3);

        TextField author = new TextField();
        author.setPromptText("");
        GridPane.setConstraints(author, 1, 3);
        disp.getChildren().add(author);

        Text text4 = new Text();
        GridPane.setConstraints(text4, 0, 4);
        text4.setText("Year:");
        disp.getChildren().add(text4);

        TextField year = new TextField();
        year.setPromptText("");
        GridPane.setConstraints(year, 1, 4);
        disp.getChildren().add(year);

        Text text5 = new Text();
        GridPane.setConstraints(text5, 0, 5);
        text5.setText("");
        disp.getChildren().add(text5);

        Button button = new Button("Add");
        GridPane.setConstraints(button, 0, 6);
        disp.getChildren().add(button);

        Button restart = new Button("Restart");
        GridPane.setConstraints(restart, 0, 6);

        button.setOnAction(action->{
            String str1,str2,str3,str4;
            str1 = isbn.getText();
            str2 = title.getText();
            str3 = author.getText();
            str4 = year.getText();
            DB db = new DB();
            Book book = new Book(str1,str2,str3,str4);
            try {
                db.addBook(book);
                text5.setText("Added");
                disp.getChildren().remove(button);
                disp.getChildren().add(restart);
            }
            catch(NotConnected e){
                text5.setText("Cannot connect to database");
            }
            catch(SQLException ex){
                text5.setText("Invalid data");
            }
            catch(Exception e){
                text5.setText("Unknown error");
            }
        });

        restart.setOnAction(action ->{
            isbn.setText("");
            title.setText("");
            author.setText("");
            year.setText("");
            disp.getChildren().remove(restart);
            disp.getChildren().add(button);
        });

        ScrollPane root = new ScrollPane();
        root.setFitToWidth(true);
        root.setFitToHeight(true);
        root.setContent(disp);
        return root;
    }
}
