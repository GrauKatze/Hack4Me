import Interfaces.IClient;
import Interfaces.IServer;
import Log.*;

public class Program {
    // TODO: добавить связь между сервером и клиентом
    public static void main(String[] args) throws Exception {

        ILogger Log = new Logger();
        // IClient clnt = new Client();
        // IServer srv = new Server();

        // srv.StartServer();
        // clnt.StartClient();

        // Server server = new Server();
        // server.start();

        // Client client = new Client();
        // client.start();

        Client client = new Client();
        client.LoadData();  
    }
}