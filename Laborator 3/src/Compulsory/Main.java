package Compulsory;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();

        Computer cA = new Computer("Computer A", "v1", "123:22:03", 50);
        Router rA = new Router("Router A","v2","534.75.087");
        Switch sA = new Switch("Switch A", "v3", "63e5362");
        Computer cB = new Computer("Computer B","v6","65.852.073",100);
        Router rB = new Router("Router B", "v5", "386283");
        Switch sB = new Switch("Switch B", "v4", "84364");

        network.addNode(cA);
        network.addNode(rA);
        network.addNode(sA);
        network.addNode(sB);
        network.addNode(rB);
        network.addNode(cB);

        network.printList();
    }
}
