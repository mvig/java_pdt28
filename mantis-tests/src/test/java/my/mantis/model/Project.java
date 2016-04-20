package my.mantis.model;

/**
 * Created by Tirex on 20.04.2016.
 */
public class Project {
    public int getId() {
        return id;
    }

    public Project withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Project withName(String name) {
        this.name = name;
        return this;
    }

    private int id;
    private String name;
}
