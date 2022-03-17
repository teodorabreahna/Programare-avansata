package Compulsory;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.lang.String;

/**
 * A class that describes a network containing multiple nodes and edges
 */
public class Network {
    LinkedList<Node> nodes;

    public Network() {
        nodes = new LinkedList<>();
    }


    public LinkedList<Node> getNodes() {
        return nodes;
    }
    public void setNodes(LinkedList<Node> nodes) {
        this.nodes = nodes;
    }
    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public void printList()
    {
        for(Node n : nodes)
            System.out.print(n.toString()+" ");
    }

    public void printCost()
    {
        for(int i=0;i<nodes.size();i++)
        {
            System.out.println("Pentru nodul " + nodes.get(i).getLocation() + " avem costurile:");
            nodes.get(i).getCost();
        }
    }

    public void identifiable()
    {
        LinkedList<Identifiable> temp = new LinkedList();
        Iterator var2 = this.nodes.iterator();

        while(var2.hasNext()) {
            Node n = (Node)var2.next();
            if (n instanceof Identifiable) {
                temp.add((Identifiable)n);
            }
        }

        System.out.println("--------------Before sorting: ");
        var2 = temp.iterator();

        String var10001;
        Node n;
        while(var2.hasNext()) {
            n = (Node) var2.next();
            var10001 = ((Node)n).getName();
            System.out.println(var10001 + " " + n.getAddress());
        }

        System.out.println("\n\n--------------After sorting: ");

    }

}
