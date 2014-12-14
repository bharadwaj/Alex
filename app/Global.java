import com.avaje.ebean.Ebean;
import controllers.Application;
import models.Users;
import play.GlobalSettings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aagama on 12-12-2014.
 */
public class Global extends GlobalSettings{


    public void onStart(Application app) {
        
        createUsers(app);
    }

    public static void createUsers(Application app){
        List<Users> defaultUsers = new ArrayList<>();

        Users bhargav = new Users(Long.valueOf(1), "bhargav@gmail.com", "bhargav");
        Users dij = new Users(Long.valueOf(2), "bhargav@gmail.com", "dij");
        Users jaya = new Users(Long.valueOf(3), "bhargav@gmail.com", "jaya");

        defaultUsers.add(bhargav);
        defaultUsers.add(dij);
        defaultUsers.add(jaya);

        Ebean.save(defaultUsers);
    }
}
