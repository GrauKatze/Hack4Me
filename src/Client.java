import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;
import java.nio.Buffer;

import Interfaces.IClient;

public class Client extends Thread implements IClient {

    private static int port = 13013;
    private static Socket clientSocket;
    private static BufferedReader reader, in;
    private static BufferedWriter out;

    public String send(String str){
        return str;
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public boolean StartClient() {
        try {
            clientSocket = new Socket();
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }
}
