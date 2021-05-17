import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import Interfaces.IServer;
import Logging.ILogger;

public class Server extends Thread implements IServer {   

    ILogger log;

    private int port = 13013;
    private ServerSocket server;
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
            try{
                clientSocket = server.accept();
                mail();
            } catch (Exception e){
                log.WriteLog(this.getClass().getName(), e.toString());
                System.err.println(e);
            } finally {
                
            }
        }else{
            System.err.println("Server is not startet");
        }

        super.run();
    }

    @Override
    public boolean StartServer() {
        try {
            server = new ServerSocket(port);
            log.WriteLog(this.getClass().getName(),"Server start");
            return true;
        } catch (Exception e) {
            System.err.println(e);
            log.WriteLog(this.getClass().getName(), e.toString());
        return false;
        }
    }

    @Override
    public void mail() throws IOException {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));  
            
            String word = in.readLine();

            System.out.println("Clinet: " + word);

            out.write("Server get: " + word);
            out.flush();
        } catch (Exception e) {
            log.WriteLog(this.getClass().getName(), e.toString());
        }
    }

    @Override
    public void clouseServer() throws IOException {
        clientSocket.close();
        in.close();
        out.close();        
    }
}
