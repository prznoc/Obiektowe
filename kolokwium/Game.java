package kolokwium;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;

public class Game extends Application {
    private boolean gameOver = false;
    private int filled = 0;
    private char[] turn = {'X','O'}; //turn[0] wskazuje aktualnego gracza
    private Box[][] board = new Box[3][3];
    private Label statusLabel = new Label("X's turn to play");

    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                pane.add(board[i][j] = new Box(), j, i);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(statusLabel);

        Scene scene = new Scene(borderPane, 600.0, 600.0);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class Box extends Pane {
        private char current = 'E';
        private Box() {
            setStyle("-fx-border-color: black");
            setPrefSize(200.0, 200.0);
            setOnMouseClicked(e -> handleMouseClick());
        }

        void drawX() {
            double w = getWidth(), h = getHeight();
            Line line1 = new Line(10.0, 10.0, w - 10.0, h - 10.0);
            Line line2 = new Line(10.0, h - 10.0, w - 10.0, 10.0);
            getChildren().addAll(line1, line2);
        }

        void drawO() {
            double w = getWidth(), h = getHeight();
            Ellipse ellipse = new Ellipse(w / 2, h / 2, w / 2 - 10.0, h / 2 - 10.0);
            ellipse.setStroke(Color.BLACK);
            ellipse.setFill(Color.WHITE);
            getChildren().add(ellipse);
        }

        void move(char c) {
            if (c == 'X')
                drawX();
            else
                drawO();
            current = c;
            filled++;
        }

        private void handleMouseClick() {
            if (current != 'E' || gameOver) {
                return;
            }
            move(turn[0]);
            char temp = turn[0];
            turn [0] = turn [1];
            turn [1] = temp;
            checkWin(turn[1]);
            if (!gameOver){
                String s = turn[0] + "'s turn to play";
                statusLabel.setText(s);
            }
        }
        char getCurrent() {
            return current;
        }
    }
    private void checkWin(char tkn){
        if (filled < 5) return;
            for (int i = 0; i < 3; i++)
                if (board[i][0].getCurrent() == tkn &&
                        board[i][1].getCurrent() == tkn &&
                        board[i][2].getCurrent() == tkn)
                    endgame(tkn);
            for (int j = 0; j < 3; j++)
                if (board[0][j].getCurrent() == tkn &&
                        board[1][j].getCurrent() == tkn &&
                        board[2][j].getCurrent() == tkn)
                    endgame(tkn);
            if (board[0][0].getCurrent() == tkn &&
                    board[1][1].getCurrent() == tkn &&
                    board[2][2].getCurrent() == tkn)
                endgame(tkn);
            if (board[0][2].getCurrent() == tkn &&
                    board[1][1].getCurrent() == tkn &&
                    board[2][0].getCurrent() == tkn)
                endgame(tkn);
            if (filled == 9) endgame('E');
    }
    private void endgame(char c){
        String p1 = "player1";
        String p2 = "player2";
        String result;
        String s = "";
        if (c == 'X') {
            result = "win";
            s = "Player X won";
        }
        else if (c == 'O') {
            result = "lose";
            s = "Player O won";
        }
        else {
            result = "draw";
            s = "Draw";
        }
        gameOver = true;
        statusLabel.setText(s);
        result = "player1"+";"+result+";"+"player2";
        try {
            EchoClient.send(result);
        }
        catch(Exception e){
            statusLabel.setText("Cannot send result to database");
        }
    }
}
