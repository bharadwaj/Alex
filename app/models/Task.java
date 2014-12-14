package models;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;
import java.time.LocalDate;
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
    public LocalDate dueDate;
    public Long authorId;
    @ManyToMany
    List<Users> assigneeIds;
    public Boolean taskDone;
    public Boolean taskPriority;

    @OneToOne
    public Chat chat;

    
    public static Finder<Long, Task> find = new Finder<Long, Task>(
            Long.class, Task.class
    );

}
