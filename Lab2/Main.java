package Lab2;

import java.util.ArrayList;



public class Main {

    public static void main(String args[])
    {
        ArrayList<Event> events = new ArrayList<Event>();
        ArrayList<Room> rooms = new ArrayList<Room>();

        Event C1 = new Event("C1",100,8,10);
        events.add(C1);

        Event C2 = new Event("C2",100,10,12);
        events.add(C2);

        Event L1 = new Event("L1",30,8,10);
        events.add(L1);

        Event L2 = new Event("L2",30,8,10);
        events.add(L2);

        Event L3 = new Event("L3",30,10,12);
        events.add(L3);

        Room room401 = new Room("401", 30, RoomType.computerLab);
        rooms.add(room401);

        Room room403 = new Room("403", 30, RoomType.computerLab);
        rooms.add(room403);

        Room room405 = new Room("405", 30, RoomType.computerLab);
        rooms.add(room405);

        Room room309 = new Room("309", 100, RoomType.lectureHall);
        rooms.add(room309);

        System.out.print("Events: ");
        for(int i=0;i<events.size();i++)
        {
            System.out.print(events.get(i).toString()+", ");
        }
        System.out.println();

        System.out.print("Rooms: ");
        for(int i=0;i<rooms.size();i++)
        {
            System.out.print(rooms.get(i).toString()+", ");
        }
        System.out.println();

    }
}
