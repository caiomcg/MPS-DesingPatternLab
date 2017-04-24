package business.control;

import business.model.User;

/**
 * Created by caiomcg on 24/04/17.
 */
public class UserControl implements UserManager {
    private User user;

    public UserControl(String userID, String accessToken) {
        user = new User(userID, accessToken);
    }


    @Override
    public String fetchUsername() {
        return "";
    }
}
