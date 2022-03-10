package Homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents an instance of the problem.
 * It contains an array of events and rooms.
 */

public class Problem {
    List<Event> events = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();

    public Problem(){}
    public Problem(List<Event> events, List<Room> rooms) {
        this.events = events;
        this.rooms = rooms;
    }

    public List<Event> getEvents() {
        return events;
    }
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Method that checks if the event already exists
     * @param event
     * @return
     */
    boolean checkEvent(Event event) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).equals(event))
                return true;
        }
        return false;
    }

    /**
     * Method that checks if the room already exists
     * @param room
     * @return
     */
    boolean checkRoom(Room room) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).equals(room))
                return true;
        }
        return false;
    }

    /**
     * Methods that add an event or a room to the list
     */
    public void addEvent(Event event) {
        if (!checkEvent(event)) {
            events.add(event);
            System.out.print("The event " + event.getName() + " was added successfully!\n");
        } else {
            System.out.print("The event " + event.getName() + " already exists!\n");
        }
    }
    public void addRoom(Room room) {
        if (!checkRoom(room)) {
            rooms.add(room);
            System.out.print("The room "+ room.getName() + " was added successfully!\n");
        } else {
            System.out.print("Room "+ room.getName() + " already exists!\n");
        }
    }

    public void printEvents(){
        for(Event value: events)
            System.out.println(value.getName());
    }
}
