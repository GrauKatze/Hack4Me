package Model.User;

import Controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class User extends Thread implements IUser {


    private String name = "user";
    private int score = 0;
    private int dataResources = 1000;
    private int dataMAX = 1500;
    public int dataUp = 0;


    @Override
    public void run() {
        while (true) {
            changeDataResource(dataUp);
            System.out.println(dataResources);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getUserName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void setUserName(String name) {
        this.name = name;

    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int getDataResources() {
        return dataResources;
    }

    @Override
    public void setDataResources(int dataResources) {
        this.dataResources = dataResources;
    }

    public User() {
        start();
    }

    @Override
    public void changeDataResource(int dataResources) {
        if((this.dataResources += dataResources)<=dataMAX){
            this.dataResources += dataResources;
        }else{
            this.dataResources = dataMAX;
        }
    }

    @Override
    public void changeDataMax(int dataMAX) {
        this.dataMAX += dataMAX;
        
    }
}
