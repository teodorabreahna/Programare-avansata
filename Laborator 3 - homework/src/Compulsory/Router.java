package Compulsory;

import java.util.HashMap;

/**
 * A class that represents a specific type of node
 */
public class Router extends Node implements Identifiable{
    private String IP;

    public Router(String name, String location, String IP) {
        super(name, location);
        this.IP = IP;
    }

    @Override
    public String getAddress() {
        return IP;
    }

    @Override
    public void setAddress(String IP) {
        this.IP = IP;
    }

}
