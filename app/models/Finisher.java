package models;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Aagama on 11-11-2014.
 */

@Entity
public class Finisher extends Model {

    @Id
    public Long id;

    public String username;

    public String email;

    public Finisher(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public static Finder<Long, Finisher> find = new Finder<Long, Finisher>(
            Long.class, Finisher.class
    );

}
