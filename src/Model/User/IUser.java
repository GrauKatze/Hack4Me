package Model.User;

public interface IUser {
    public String getUserName();
    public void setUserName(String name);
    public int getScore();
    public void setScore(int score);
    public int getDataResources();
    public void setDataResources(int dataResources);
    public void changeDataResource(int dataResources);
    
}
