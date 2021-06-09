package Model.Building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Build implements Ibuild {
    
    String name;
    ImageView iView;
    int ID = 0;
    int dataResources;

    private enum Buildes{
        dataCraftBuild,
        dataSaveBuild,
        protector;
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

    public Build(String name, int ID, String path){
        setName(name);
        setID(ID);
        setImageView(path);
    }

    @Override
    public int getDataResources() {
        return dataResources;
    }

    @Override
    public void setDataResources(int dataResources) {
        this.dataResources = dataResources;      
    }
    
}
