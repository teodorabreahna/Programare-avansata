package Compulsory;

import java.util.LinkedList;

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

}
