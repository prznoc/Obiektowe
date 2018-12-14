package lab9;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

    public static void main(String[] args)  {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(3456);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 3456");
            System.exit(1);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        while (true) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("Accept failed: 6666");
                System.exit(-1);
            }
            ClientThread client = new ClientThread(clientSocket);
            executorService.submit(client);
        }
    }
}
class ClientThread implements Runnable{
        private Socket clientSocket;
        ClientThread(Socket _clientSocket){
            clientSocket = _clientSocket;
        }
        public void run(){
            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    out.println(inputLine);
                }
                out.close();
                in.close();
                clientSocket.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
}



