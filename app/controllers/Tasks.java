package controllers;

import com.avaje.ebean.Ebean;
import models.Task;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.tasks.task_by_id;
import views.html.tasks.tasksform;
import views.html.tasks.taskslist;

import java.util.List;

/**
 * Created by Shwaunk on 29-11-2014.
 */
@Security.Authenticated(Secured.class)
public class Tasks extends Controller {

    private static final Form<Task> taskForm = Form.form(Task.class);

    public static Result saveTask(){
        Form<Task> boundForm = taskForm.bindFromRequest();
        Task task = boundForm.get();
        task.authorId = Long.MIN_VALUE;
        Ebean.save(task);
        return redirect("/tasks");
    }

    public static Result formTask(){
        return ok(tasksform.render(taskForm));
    }

    public static Result all(){
        List<Task> allTasks = Task.find.all();
        return ok(taskslist.render(allTasks));
    }

    public static Result byId(Long id){
        Task task = Task.find.byId(id);
        return ok(task_by_id.render(task));
    }

    public static Result find(){
        return TODO;
    }

    public static Result doneTask(){
        return TODO;
    }

    public static Result deleteTask(Long id){
        return TODO;
    }
}
