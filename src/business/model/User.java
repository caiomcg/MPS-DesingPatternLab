package business.model;

/**
 * Created by caiomcg on 24/04/17.
 */
public class User {
    private String userId;
    private String username;
    private String accessToken;

    public User(String userId, String accessToken) {
        this.userId = userId;
        this.accessToken = accessToken;
    }

    String getAccessToken() {
        return accessToken;
    }

    String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }
}
