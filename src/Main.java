import adapter.*;
import infra.*;

public class Main {
    public static void main(String[] args) {

        // Adapter pattern test
        SocialNetTarget adpt1 = new GroupSocialNetAdapter();
        SocialNetTarget adpt2 = new MusicSocialNetAdapter();

        adpt1.getAccessToken();
        adpt2.getAccessToken();

        PersistenceFactory pf = new JsonFactory();
        Persistence per = pf.makePersistence();

        return;
    }
}