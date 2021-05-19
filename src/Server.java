import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import Interfaces.IServer;
import Log.ILogger;

public class Server extends Thread implements IServer {   

    ILogger log;

    private int port = 13013;
    private Socket clientSocket;
    private ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    @Override
    public void run() {
        try {
            try (ServerSocket server = new ServerSocket(port);)  {
                System.out.println("Сервер запущен!");
                clientSocket = server.accept(); 
                try { 
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String word = in.readLine();
                    System.out.println(word);
                    out.write("Привет, это Сервер! Подтверждаю, вы написали : " + word + "\n");
                    out.flush(); 

                } finally { 
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                    server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }    
        super.run();
    }

    @Override
    public void StartServer() {
        try (ServerSocket server = new ServerSocket(port)) {
            log.WriteLog(Server.class.getName(), "Server is start");
            server.accept();
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
        } catch (Exception e) {
            log.WriteLog(this.getClass().getName(), e.toString());
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
