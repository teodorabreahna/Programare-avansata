package Homework;

import java.util.Objects;

/**
 * Class event that has constructors, getters, setters and the equals function overwritten.
 */

public class Event {
    /**
     * Each event has a name, number of participants, a start time and an end time.
     */
    private String name;
    private int capacity, start, end;

    public Event(){}
    public Event(String name, int capacity, int start, int end) {
        this.name = name;
        this.capacity = capacity;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getName().equals(event.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
