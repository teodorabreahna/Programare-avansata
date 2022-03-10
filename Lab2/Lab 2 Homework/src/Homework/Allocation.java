package Homework;

import java.util.Collections;

/**
 * A helping class that has methods for making a timetable in a greedy style.
 */

public class Allocation {

    /**
     * A method that sorts the list of events starting from the one with the most participants
     * @param instanta
     */
    public void sortEvents(Problem instanta){

        for(int i = 0; i<instanta.getEvents().size()-1; i++)
            for(int j=i+1;j<instanta.getEvents().size();j++)
                if(instanta.getEvents().get(j).getCapacity()>instanta.getEvents().get(i).getCapacity())
                    Collections.swap(instanta.getEvents(), i, j);
    }

    /**
     * Method that checks if the room is free in a given interval
     * @param name
     * @param start
     * @param end
     * @return
     */
    public boolean liber(Room name, int start, int end)
    {
        for(int i=start;i<end;i++)
            if(name.getOcupat()[i]) return false;
        return true;
    }

    /**
     * Method that allocates a room to an event, based on the number of participants to the event, capacity and disponibility of rooms
     * @param instanta
     * @param solution
     */
    public void allocate(Problem instanta, Solution solution){

        for(int i=0;i<instanta.getEvents().size();i++)
            for(int j=0;j<instanta.getRooms().size();j++)
            {
                if(instanta.getEvents().get(i).getCapacity()<=instanta.getRooms().get(j).getCapacity() && liber(instanta.getRooms().get(j),instanta.getEvents().get(i).getStart(),instanta.getEvents().get(i).getEnd()))
                {
                    solution.addRoom(instanta.getRooms().get(j));
                    solution.addEvent(instanta.getEvents().get(i));
                    instanta.getRooms().get(j).setOcupat(instanta.getEvents().get(i).getStart(),instanta.getEvents().get(i).getEnd());
                    break;
                }
            }
    }
}
