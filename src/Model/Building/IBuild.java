package Model.Building;

import javafx.scene.image.ImageView;

public interface IBuild {

    public String getName();
    public void setName(String name);
    public ImageView getImageView();
    public void setImageView(String path);
    public int getID();
    public void setID(int ID);
    public int getDataResources();
    public void setDataResources(int dataResources);
}
