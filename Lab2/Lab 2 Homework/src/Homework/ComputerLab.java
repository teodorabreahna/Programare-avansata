package Homework;

/**
 * A class that represents a specific type of room
 */

public class ComputerLab extends Room{
    private String so;

    public ComputerLab(String name, int capacity, String so) {
        super(name, capacity);
        this.so = so;
    }
    public String getSo() {
        return so;
    }
}
