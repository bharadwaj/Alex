import com.avaje.ebean.Ebean;
import models.Finisher;
import play.Application;
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

        if(Ebean.find(Finisher.class).findRowCount()==0) {
            //TODO Make YAML File for this.
            //Map<String, List<Object>> defaultUsers = (Map<String, List<Object>>) Yaml.load("initial-data");

            List<Finisher> defaultFinishers = new ArrayList<Finisher>();

            Finisher bhargav = new Finisher(Long.valueOf(1), "bhargav","bhargavtrunks@gmail.com");
            Finisher dij = new Finisher(Long.valueOf(2), "dij", "dijayaratna@gmail.com");
            Finisher jaya = new Finisher(Long.valueOf(3), "jaya", "bharadwaj.j@gmail.com");

            defaultFinishers.add(bhargav);
            defaultFinishers.add(dij);
            defaultFinishers.add(jaya);

            Ebean.save(defaultFinishers);

        }
    }
}
