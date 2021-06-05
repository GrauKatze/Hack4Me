package Model.Building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Build implements Ibuild {
    
    String name;
    double buildX, buildY;
    ImageView iView;
    int ID = 0;

    @Override
    public double getX() {
        return buildX;
    }

    @Override
    public double getY() {
        return buildY;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setImageView(String path) {
       iView = new ImageView( new Image(getClass().getResourceAsStream(path)));        
    }

    @Override
    public ImageView getImageView() {
        return iView;
    }

    @Override
    public void setX(Double X) {
        this.buildX = X;        
    }

    @Override
    public void setY(Double Y) {
        this.buildY = Y;        
    }

    @Override
    public void setName(String name) {
        this.name=name;        
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;        
    }

    public Build(String name, int ID, String path, Double X, Double Y){
        setName(name);
        setID(ID);
        setImageView(path);
        setX(X);
        setY(Y);
    }
    
}
