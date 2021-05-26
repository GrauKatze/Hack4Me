package Server;

import java.io.IOException;

public interface IServer {
    public void StartServer();
    public void mail() throws IOException;
    public void ClouseServer() throws IOException;
    public void UsersSkan();
}
