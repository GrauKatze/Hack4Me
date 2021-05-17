import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Interfaces.IServer;

public class Server extends Thread implements IServer {   

    private int port = 13013;
    private ServerSocket ss;
    private Socket clientSocket;
    private static BufferedReader in;
    private static BufferedWriter out;

    @Override
    public void print(String str) {
        System.out.println("Я получил"+str);
    }

    @Override
    public void run() {
        if(StartServer()){
            System.out.println("Server is started");
        }else{
            System.err.println("Server is not startet");
        }

        super.run();
    }

    @Override
    public boolean StartServer() {
        try {
            ss = new ServerSocket(port);
            return true;
        } catch (Exception e) {
            System.err.println(e);
        return false;
        }
    }
}
