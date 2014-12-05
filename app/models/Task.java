package models;

import org.joda.time.DateTime;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by Shwaunk on 29-11-2014.
 */
@Entity
public class Task extends Model {

    @Id
    public Long id;

    public String task;
    public String createdTime;
    public String dueDate;
    public Long authorId;
    @ManyToOne
    List<Long> assigneeIds;

    public static Finder<Long, Task> find = new Finder<Long, Task>(
            Long.class, Task.class
    );

}
