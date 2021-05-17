import Interfaces.IClient;
import Interfaces.IServer;

public class Program {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        IClient clnt = new Client();
        IServer srv = new Server();

        srv.print(clnt.send("ghjk"));
    }
}