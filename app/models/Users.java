package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Aagama on 11-11-2014.
 */

@Entity
public class Users extends Model {

    @Id
    Long id;

    public String userName;

    public String email;

    public Users(Long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public static Finder<Long, Users> find = new Finder<Long, Users>(
            Long.class, Users.class
    );

}
