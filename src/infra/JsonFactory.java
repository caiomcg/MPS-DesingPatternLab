package infra;

/**
 * Created by wesnydy on 24/04/17.
 */
public class JsonFactory implements PersistenceFactory {
    @Override
    public Persistence makePersistence() {
        System.out.println("Making PersistenceJSONImpl");
        return new PersistenceJSONImpl();
    }
}
