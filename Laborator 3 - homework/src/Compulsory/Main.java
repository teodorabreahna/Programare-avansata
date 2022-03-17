package Compulsory;
/**
 * @author Teodora Breahna
 */

public class Main {
    public static void main(String[] args) {
        Network network = new Network();

        Computer cA = new Computer("Computer A", "v1", "123.22.03", 50);
        Router rA = new Router("Router A","v2","534.75.087");
        Switch sA = new Switch("Switch A", "v3", "63.53.62");
        Computer cB = new Computer("Computer B","v6","65.852.073",100);
        Router rB = new Router("Router B", "v5", "38.628.3");
        Switch sB = new Switch("Switch B", "v4", "84.36.4");

        network.addNode(cA);
        network.addNode(rA);
        network.addNode(sA);
        network.addNode(sB);
        network.addNode(rB);
        network.addNode(cB);

        System.out.println("Compulsory:");
        network.printList();

        System.out.println("Homework:");
        cA.addCost(rA,10);
        cA.addCost(sA,50);
        rA.addCost(sA,20);
        rA.addCost(sB,20);
        rA.addCost(rB,20);
        sA.addCost(sB,10);
        sB.addCost(rB,30);
        sB.addCost(cB,10);
        rB.addCost(cB,20);
        network.printCost();
        System.out.println();

        cA.changeUnit(cA.getStorageCapacity(), "MB");
        network.identifiable();
    }
}
