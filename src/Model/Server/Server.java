package Model.Server;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends Thread implements IServer {   

    private int port = 4004;
    private Socket clientSocket;
    private ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    private static boolean isActive;

    public Server(){
        isActive = true;
    }

    public void disable(){
        isActive = false;
    }

    @Override
    public void run() {
        try {
            try  {
                StartServer();
                clientSocket = server.accept();
                try {
                    mail();
                } finally {
                    ClouseServer();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                    server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public void StartServer() {
        try {
            this.server = new ServerSocket(port);
            System.out.println("Сервер запущен!");
        } catch (Exception e) {
            System.out.println("Сервер not запущен!");
                }
    }

    @Override
    public void mail() throws IOException {
        try {
            Server.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Server.out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));  
            String word;
            while(true){
                word = in.readLine();
                System.out.println("Clinet: " + word);
                //Так как клиент ждет поток от сервера
                out.write("\n");
                out.flush();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void ClouseServer() throws IOException {
        this.clientSocket.close();
        Server.in.close();
        Server.out.close();        
    }

    @Override
    public void UsersSkan() {
        
    }
}
