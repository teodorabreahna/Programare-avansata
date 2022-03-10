package Compulsory;

import java.util.HashMap;

public class Switch extends Node implements Identifiable{
    private String address;

    public Switch(String name, String location, String address) {
        super(name, location);
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }


}
