package kolokwium;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    static DB db;
    public static void main(String[] args)  {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(3456);
            createTable();
        } catch (IOException e) {
            System.err.println("Could not listen on port: 3456");
            System.exit(1);
        }
        catch(Exception e){
            System.err.println("cannot connect to database");
            System.exit(1);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(6);

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
            String inputLine = in.readLine();
                out.println(inputLine);
                Result result = new Result(inputLine);
                try {
                    EchoServer.db.addResult(result);
                }
                catch (Exception e){
                    System.out.println("Cannot add result");
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





