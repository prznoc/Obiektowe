package kolokwium;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    static DB db;
    public static String current = "";
    public static void main(String[] args)  {
        try{
            createTable();
        }
        catch(Exception e){
            return;
        }
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(3456);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 3456");
            System.exit(1);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        while (true) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("Accept failed: 3456");
                System.exit(-1);
            }
            ClientThread client = new ClientThread(clientSocket);
            executorService.submit(client);
        }
    }
    private static void createTable()throws Exception{
        db = new DB();
        db.createTable();

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
                    Result result = new Result(inputLine);
                    try {
                        addToDatabase(result);
                    }
                    catch (Exception e){
                    }
                }
                out.close();
                in.close();
                clientSocket.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    private void addToDatabase(Result result)throws Exception{
        EchoServer.db.addResult(result);
    }
}

class Result{
    String player1;
    String player2;
    String result;
    Result(String got){
        String[] temp = got.split(";");
        player1 = temp[0];
        player2 = temp[1];
        result = temp[2];
    }
}



