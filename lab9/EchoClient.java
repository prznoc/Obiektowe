package lab9;

import java.io.*;
import java.net.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import java.io.IOException;



public class EchoClient extends Application{

    public void start(Stage stage) throws IOException {
        Drawer drawer = new Drawer();
        StackPane root = drawer.content;
        int portNumber = 2222;
        String host = "localhost";
        System.out.println("Usage: java MultiThreadChatClient <host> <portNumber>\n" + "Now using host=" + host + ", portNumber=" + portNumber);
        Socket clientSocket = new Socket(host, portNumber);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        while (true) {

            if ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
            }
            System.out.println("echo: " + in.readLine());
            Scene scene = new Scene(root, root.getMinHeight(), root.getMinWidth());
            stage.setScene(scene);
            stage.setX(500);
            stage.setY(300);
            stage.show();
        }
    }

    public static void main(String[] args)throws IOException{
        launch();
    }
}