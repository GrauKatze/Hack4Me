import java.io.*;
import java.net.Socket;
import Interfaces.IClient;

public class Client extends Thread implements IClient {

    private static int port = 13013;
    private static Socket clientSocket;
    private static BufferedReader reader, in;
    private static BufferedWriter out;

    @Override
    public void run() {
        if (StartClient()) {
            try {
               mail();
            } catch (Exception exception) {
                System.err.println(exception);
            }
        }
        super.run();
    }

    @Override
    public boolean StartClient() {
        try {
            clientSocket = new Socket("localhost",port);

        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    @Override
    public void mail() throws IOException {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            while(true){
                System.out.print("> ");

                String clietnWord = reader.readLine();

                out.write(clietnWord + "\n");
                out.flush();

                String serverWord = in.readLine();
                System.out.println("server: " + serverWord);
            }
        } catch (Exception e) {
            System.err.println(e);        }
    }
    
    @Override
    public void SaveData() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/Users/user"))) {
            User user = new User();
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (Exception e) {
            System.err.println(e);
        }  
    }
    
    @Override
    public void LoadData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/Users/user"))) {
            User user = (User) objectInputStream.readObject();
            System.out.println(user.name);
        } catch (Exception e) {
            System.err.println(e);
        }        
    }
}
