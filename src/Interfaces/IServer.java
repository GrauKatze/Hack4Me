package Interfaces;

import java.io.IOException;

public interface IServer {
    public void print(String str);
    public boolean StartServer();
    public void mail() throws IOException;
    public void clouseServer() throws IOException;
}
