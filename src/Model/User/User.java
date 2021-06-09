package Model.User;

public class User implements IUser {
    private String name;
    private int score = 0;
    private int dataResources = 1000;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void setName(String name) {
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
    }
}
