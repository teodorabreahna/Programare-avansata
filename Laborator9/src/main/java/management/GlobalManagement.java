package management;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * global management for EntityManagerFactory
 */
public class GlobalManagement {
    private static EntityManagerFactory emf = null;

    /**
     * creating the EntityManagerFactory
     *
     */
    public static void initializeEntityManagerFactory() {
        GlobalManagement.emf = Persistence.createEntityManagerFactory("ExamplePU");
    }

    /**
     * retunrning a reference for an EntityManagerFactory already created
     *
     * @return reference
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        return GlobalManagement.emf;
    }

    /**
     * this method closes the connection for the running EntityManagerFactory
     */
    public static void closeEntityManagerFactory() {
        GlobalManagement.emf.close();
    }
}
