package Logging;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;

public class Logger implements ILogger{
    
    @Override
    public void WriteLog(String className ,String message) {
        try (FileWriter fos = new FileWriter("src/Logging/Log.txt",true)){
            String logMessage = "\n["+className+"]\t{"+message+"}";
            fos.append(logMessage);
        } catch (Exception e) {
           System.err.println(e);
        }
    }

    @Override
    public void ReadLog(String str) {
        try (FileReader fis = new FileReader("src/Logging/Log.txt")) {
            // fis.read()
        } catch (Exception e) {
           System.err.println(e);
        }
        
    }

    @Override
    public void OpenWriteFile() {};

    @Override
    public void OpenReadFile() {};

    
}