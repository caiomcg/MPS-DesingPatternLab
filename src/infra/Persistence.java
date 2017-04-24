package infra;

import model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marcelo on 11/04/2017.
 */
public interface Persistence {

    void saveOnDatabase(Map<String, User> data) throws PersistenceException;
    HashMap<String, User> loadFromDatabase();

}
