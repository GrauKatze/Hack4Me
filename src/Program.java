import Interfaces.IClient;
import Interfaces.IServer;
import Log.*;

public class Program {
    // TODO: добавить связь между сервером и клиентом
    public static void main(String[] args) throws Exception {

        ILogger Log = new Logger();
        
        Server server = new Server();
        server.start();
        
        Client client = new Client();
        client.start();
        
        IClient clnt = client;
        IServer srv = server;

    }
}