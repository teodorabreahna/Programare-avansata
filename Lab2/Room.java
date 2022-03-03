package Lab2;

public class Room {
    private String name;
    private int capacity;
    private RoomType type;

    //constructori
    public Room(){}
    public Room(String name, int capacity, RoomType type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }
    //settere
    public void setName(String name) {
        this.name = name;
    }
    public void setType(RoomType type) {
        this.type = type;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    //gettere
    public String getName() {
        return name;
    }
    public RoomType getType() {
        return type;
    }
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name +
                "(capacity=" + capacity +
                ", type=" + type +
                ')';
    }
}
