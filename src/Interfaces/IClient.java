package Interfaces;

import java.io.IOException;

public interface IClient {
    public boolean StartClient();
    public void mail() throws IOException;

    public void SaveData();
    public void LoadData();
}