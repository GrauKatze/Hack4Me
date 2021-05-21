package Log;
import java.io.FileReader;
import java.io.FileWriter;

public class Logger implements ILogger{
    
    @Override
    public void WriteLog(String className ,String message) {
        try (FileWriter fos = new FileWriter("src/Log/"+className+".txt",true)){
            String logMessage = "\n["+className+"]\t{"+message+"}";
            fos.append(logMessage);
        } catch (Exception e) {
           System.err.println(e);
        }
    }
    // TODO: Настроить чтение логов
    // FIXME: А нужно ли их читать?
    @Override
    public void ReadLog(String str) {
        try (FileReader fis = new FileReader("src/Log/Log.txt")) {
            // fis.read()
        } catch (Exception e) {
           System.err.println(e);
        }
        
    }

    public Logger(){
        WriteLog(this.getClass().getName(), "Старт записи");
    }

    
}