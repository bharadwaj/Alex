package controllers;

import com.avaje.ebean.Ebean;
import models.Task;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.tasks.task_by_id;
import views.html.tasks.tasks_home;
import views.html.tasks.tasks_form;
import views.html.tasks.tasks_list;

import java.util.List;

/**
 * Created by Shwaunk on 29-11-2014.
 */
@Security.Authenticated(Secured.class)
public class Tasks extends Controller {

    private static final Form<Task> taskForm = Form.form(Task.class);

    public static Result saveTask() {
        Form<Task> boundForm = taskForm.bindFromRequest();
        if (boundForm.hasErrors()) {
            return badRequest(tasks_form.render(taskForm));
        } else {
            Task task = boundForm.get();
            task.authorId = Long.MIN_VALUE;
            Ebean.save(task);
        }
        return redirect("/tasks");
    }

    public static Result formTask() {
        return ok(tasks_form.render(taskForm));
    }

    public static Result all() {
        List<Task> allTasks = Task.find.all();
        return ok(tasks_home.render(allTasks, taskForm, null));
    }

    public static Result byId(Long id) {
        Task task = Task.find.byId(id);
        List<Task> allTasks = Task.find.all();
        return ok(tasks_home.render(allTasks, taskForm, task));
    }

    public static Result find() {
        return TODO;
    }

    public static Result doneTask() {
        return TODO;
    }

    public static Result deleteTask(Long id) {
        return TODO;
    }
}
