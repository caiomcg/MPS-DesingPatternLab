package adapter;

import adapter.SocialNetTarget;

public class MusicSocialNetAdapter /*extends MSNManager*/ implements SocialNetTarget {
    @Override
    public String getAccessToken() {
        System.out.println("Token from music social network obtained");
        return "";
    }
}