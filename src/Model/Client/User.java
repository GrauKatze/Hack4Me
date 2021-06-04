package Model.Client;

public class User implements IUser {
        String name;
        int score;

    void ParsInJSON(){
        
    }
    void ParcOutJSON(){

    }

    public String getName() {return name;}
    public int getScore() {return score;}

    public User(String name){
        this.name = name;
    }

    public User(){};
}
