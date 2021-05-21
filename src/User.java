import java.io.Serializable;

import Interfaces.IUser;

public class User implements Serializable, IUser {
        String name;
        int lvl, score;

    void ParsInJSON(){
        
    }
    void ParcOutJSON(){

    }

    User(String name, int lvl, int score){
        this.name = name;
        this.lvl=lvl;
        this.score=score;
    }
}
