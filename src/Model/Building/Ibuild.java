package Model.Building;

import javafx.scene.image.ImageView;

public interface Ibuild {
    public double getX();
    public void setX(Double X);
    public double getY();
    public void setY(Double Y);
    public String getName();
    public void setName(String name);
    public ImageView getImageView();
    public void setImageView(String path);
    public int getID();
    public void setID(int ID);
}
