package Compulsory;
import java.util.*;

/**
 * interface for storage
 */

public interface Storage {
    public int getStorageCapacity();
    public void setStorageCapacity(int storageCapacity);

    /**
     * A method that can change the unit of measurement for storage capacity
     * @param capacity
     * @param sir
     */
    default void changeUnit(int capacity, String sir)
    {
        if(sir.equals("MB"))
            System.out.println(capacity + " GB = " + capacity*1000L + " MB");
        if(sir.equals("KB"))
            System.out.println(capacity + " GB = " + capacity*1000000L + " KB");
        if(sir.equals("B"))
            System.out.println(capacity + " GB = " + capacity*10000000000L + " KB");
    }
}
