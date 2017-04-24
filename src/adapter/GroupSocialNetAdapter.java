package adapter;

import adapter.SocialNetTarget;

public class GroupSocialNetAdapter /*extends GSNManager*/ implements SocialNetTarget {
    @override
    public String getAccessToken() {
        System.out.println("Token from group social network obtained");
    }
}