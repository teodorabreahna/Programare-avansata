package Compulsory;

import java.util.Arrays;
import java.util.HashMap;

public class Node {
    private String name;
    private String location;
    private String address;
    private HashMap<Node, Integer> timeCost = new HashMap<>();


    public Node(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    /***
     * Method that adds cost from this node to another one
     * @param node
     * @param cost
     */
    public void addCost(Node node, Integer cost) {
        this.timeCost.put(node, cost);
    }

    /**
     * Method that gets the cost from this node to its neighbours
     */
    public void getCost()
    {
        for(Node i: timeCost.keySet())
        {
            System.out.println(i.getLocation() + " " + timeCost.get(i));
        }
    }

    @Override
    public String toString() {
        return  location + '(' +name +')';
    }
}
