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

    public String getAccessToken() {
        return accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
