package Logging;

public interface ILogger {
    public void WriteLog(String className ,String message);
    public void ReadLog(String str);
    public void OpenWriteFile();
    public void OpenReadFile();
}
