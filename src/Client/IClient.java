package Client;

import java.io.IOException;

public interface IClient {
    public void StartClient();
    public void mail() throws IOException;

    public void SaveData();
    public void LoadData();

    public void ClouseClient() throws IOException;
}