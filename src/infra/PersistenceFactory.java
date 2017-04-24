package infra;

/**
 * Created by wesnydy on 24/04/17.
 */
public class PersistenceFactory {

    public Persistence getPersistence(String type) {
        if (type.equalsIgnoreCase("json")) {
            System.out.println("Making PersistenceJSONImpl");
            return new PersistenceJSONImpl();
        } else {
            return null;
        }
    }
}
