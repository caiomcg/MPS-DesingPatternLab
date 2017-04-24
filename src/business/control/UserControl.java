package business.control;

import business.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caiomcg on 24/04/17.
 */
public class UserControl implements UserManager {
    private Map<String, User> users;

    public UserControl() {
        users = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    @Override
    public void removeUser(String id) {
        users.remove(id);
    }

    @Override
    public Map<String, User> getUsers() {
        return users;
    }
}
