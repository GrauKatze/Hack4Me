package Model.Client;
import java.io.*;
import java.net.Socket;

public class Client extends Thread implements IClient {

    private static int port = 4004;
    private static Socket clientSocket;
    private static BufferedReader reader, in;
    private static BufferedWriter out;

    private boolean isActive;

    @Override
    public void run() {
        try {
            try {
                StartClient();
                mail();
            } finally {
                ClouseClient();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    @Override
    public void StartClient() {
        try {
            Client.clientSocket = new Socket("localhost",port);
            this.isActive = true;
            System.out.println("Clent is on");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void mail() throws IOException {
        try {
            Client.reader = new BufferedReader(new InputStreamReader(System.in));
            Client.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Client.out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                
            String clientWord;
            String serverWord;
            while (isActive){
                System.out.print("> ");
                if((clientWord = reader.readLine())!="exit"){
                    out.write(clientWord + "\n");
                    out.flush();
                    serverWord = in.readLine();
                    System.out.println("server: " + serverWord);
                }else{
                    isActive = false;
                }
            }
        } catch (Exception e) {
            System.err.println(e);        
        }
    }

    @Override
    public void ClouseClient() throws IOException{
        Client.clientSocket.close();
        System.out.println("Клиент был закрыт...");
        Client.in.close();
        Client.out.close();
    }
    
    @Override
    public void SaveData() {
        // try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/Users/user"))) {
        //     User user = new User();
        //     objectOutputStream.writeObject(user);
        //     objectOutputStream.close();
        // } catch (Exception e) {
        //     System.err.println(e);
        // }  
    }
    
    @Override
    public void LoadData() {
        // try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/Users/user"))) {
        //     User user = (User) objectInputStream.readObject();
        //     System.out.println(user.name);
        // } catch (Exception e) {
        //     System.err.println(e);
        // }        
    }

    
}
