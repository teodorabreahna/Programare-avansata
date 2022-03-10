package Compulsory;

import java.util.HashMap;

public class Computer extends Node implements Identifiable, Storage{
    private String IP;
    private int storageCapacity;

    public Computer(String name, String location, String IP, int storageCapacity) {
        super(name, location);
        this.IP = IP;
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String getAddress() {
        return IP;
    }

    @Override
    public void setAddress(String IP) {
        this.IP = IP;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }

    @Override
    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }


}
