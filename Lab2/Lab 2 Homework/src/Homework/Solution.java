package Homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that stores all the allocations of the events to the rooms.
 */

public class Solution {
    List<Event> eventsSol = new ArrayList<>();
    List<Room> roomsSol = new ArrayList<>();

    public void addEvent(Event name){
        eventsSol.add(name);
    }
    public void addRoom(Room name){
        roomsSol.add(name);
    }
    public void printSolution()
    {
        System.out.println("Solution:");
        for(int i=0;i<eventsSol.size();i++)
            System.out.println(eventsSol.get(i).getName() + " -> " + roomsSol.get(i).getName());
    }
}
