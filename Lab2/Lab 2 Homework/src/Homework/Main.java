package Homework;

/**
 * @author Teodora Breahna
 */

public class Main {

    public static void main(String[] args) {
        Problem instanta = new Problem();
        Event C1 = new Event("C1",100,8,10);
        Event C2 = new Event("C2",100,10,12);
        Event L1 = new Event("L1",30,8,10);
        Event L2 = new Event("L2",30,8,10);
        Event L3 = new Event("L3",30,10,12);
        Event C3 = new Event("C1",100,8,10);

        instanta.addEvent(C1);
        instanta.addEvent(C2);
        instanta.addEvent(L1);
        instanta.addEvent(L2);
        instanta.addEvent(L3);
        instanta.addEvent(C3);

        ComputerLab r1 = new ComputerLab("401", 30, "Windows");
        ComputerLab r2 = new ComputerLab("403", 30, "Linux");
        ComputerLab r3 = new ComputerLab("405", 30, "Windows");
        LectureHall r4 = new LectureHall("309", 100, true);
        LectureHall r5 = new LectureHall("309", 40, true);

        instanta.addRoom(r1);
        instanta.addRoom(r2);
        instanta.addRoom(r3);
        instanta.addRoom(r4);
        instanta.addRoom(r5);

        Allocation repartizare = new Allocation();
        Solution solution = new Solution();
        repartizare.sortEvents(instanta);
        repartizare.allocate(instanta,solution);
        solution.printSolution();
    }
}
