package business.control;

import business.model.User;

import java.util.Map;

/**
 * Created by caiomcg on 24/04/17.
 */

public interface UserManager {
    void addUser(User user);
    void removeUser(String id);

    Map<String, User> getUsers();
}
