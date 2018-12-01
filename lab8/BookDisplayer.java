package lab8;

import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import java.util.LinkedList;
import javafx.scene.control.ScrollPane;

class BookDisplayer{
    private DB db = new DB();
    private final int mode;
    private final String aim;
    ScrollPane content;
    BookDisplayer(int n, String str){
        mode = n;
        aim = str;
        content = get();
    }
    private ScrollPane get() {
        GridPane disp = new GridPane();
        disp.setPadding(new Insets(10, 10, 10, 10));
        disp.setVgap(10);
        disp.setHgap(10);
        ScrollPane root = new ScrollPane();
        root.setFitToWidth(true);
        root.setFitToHeight(true);
        root.setContent(disp);
        try {
            LinkedList<Book> ksiazki = new LinkedList<>();
            switch (mode){
                case 0: ksiazki = db.listNames(); break;
                case 1: ksiazki = db.findByISBN(aim); break;
                case 2: ksiazki = db.findByAuthor(aim); break;
            }
            int i = 0;
            Text dis;
            for (Book b : ksiazki) {
                dis = new Text();
                GridPane.setConstraints(dis, 0, i);
                dis.setText("ISBN: " + b.ISBN + " " + "Title: " + b.title + " " + "Author: " + b.author + " " + "Year: " + b.year + " ");
                disp.getChildren().add(dis);
                ++i;
            }
            if (i == 0){
                dis = new Text();
                GridPane.setConstraints(dis, 0, i);
                dis.setText("Did not find any book");
                disp.getChildren().add(dis);
            }
        }
        catch (NotConnected e){
            Text dis = new Text();
            GridPane.setConstraints(dis, 0, 0);
            dis.setText("Cannot connect to the database");
            disp.getChildren().add(dis);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }
}
