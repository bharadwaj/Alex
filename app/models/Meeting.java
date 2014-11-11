package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Created by Aagama on 09-11-2014.
 */

//TODO Create a Database table
// 1. Extend a class to Model
// 2. To make a table @Entity annotation
@Entity
public class Meeting extends Model {

    @Id
    public Long id;

    public String planTime;
    public String agenda;
    public String notes;
    public int remarks;

    //3. Add a finder method.
    public static Finder<Long, Meeting> find = new Finder<Long, Meeting>(
            Long.class, Meeting.class
    );
}
