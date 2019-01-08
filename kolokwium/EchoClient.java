package kolokwium;

import java.io.*;
        import java.net.*;
        class EchoClient{

    static void send(String message)throws IOException{
        int num = 0;
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try{
            echoSocket = new Socket("localhost", 3456);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        }
        catch(UnknownHostException e){
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        }
        catch(IOException e){
            System.err.println("Couldn't get I/O for " + "the connection to: localhost.");
            System.exit(1);
        }
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        out.println(message);
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}