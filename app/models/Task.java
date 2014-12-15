package models;

import com.avaje.ebean.Ebean;
import org.joda.time.DateTime;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Shwaunk on 29-11-2014.
 */
@Entity
public class Task extends Model {

    @Id
    public Long id;

    @Required
    public String task;
    public String createdTime;
    @Required
    @Formats.DateTime(pattern = "yyyy-MM-dd")
    public Date dueDate;
    public Long authorId;
    @ManyToMany
    List<Finisher> assigneeIds;
    public Boolean taskDone;
    public Boolean taskPriority;

    @OneToOne
    public Chat chat;

    
    public static Finder<Long, Task> find = new Finder<Long, Task>(
            Long.class, Task.class
    );

    public static Boolean saveTask(Task task){
        Ebean.save(task);
        return true;
    }

}
