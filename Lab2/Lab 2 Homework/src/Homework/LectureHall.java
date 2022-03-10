package Homework;

/**
 * A class that represents a specific type of room
 */

public class LectureHall extends Room {
    private boolean projector;

    public LectureHall(String name, int capacity,boolean projector) {
        super(name, capacity);
        this.projector = projector;
    }
    public boolean isProjector() {
        return projector;
    }
}
