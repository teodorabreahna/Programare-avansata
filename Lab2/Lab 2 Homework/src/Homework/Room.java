package Homework;

import java.util.Objects;

/**
 * Abstract class that has constructors, getters, setters and  function equals overwritten.
 */

abstract class Room {

    /**
     * Each room has a name, capacity and a vector that represents whether the room is free or occupied at a certain hour.
     * If an event takes place in the room between 10 and 12, that means that in the vector there will be true,
     * meaning occupied, on positions 10 and 11.
     */

    private String name;
    private int capacity;
    private boolean ocupat[];


    public void Room(){}
    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        ocupat = new boolean[24];
        for(int i=0;i<24;i++) ocupat[i]=false;
    }

    public String getName() {
        return name;
    }
    public int getCapacity() {
        return capacity;
    }
    public boolean[] getOcupat() {
        return ocupat;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setOcupat(int i, int j){
        for(int x=i;x<j;x++) ocupat[x]=true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return getName().equals(room.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
