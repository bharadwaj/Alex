package controllers;

import com.avaje.ebean.Ebean;
import models.Users;
import views.html.home;
import play.data.Form;
import play.mvc.*;

import views.html.login.login;
import views.html.login.signup;

import java.util.ArrayList;
import java.util.List;


public class Application extends Controller {

    private static Form userForm = Form.form(Users.class);

    @Security.Authenticated(Secured.class)
    public static Result index() {
        return ok(home.render());
    }

    public static Result authenticate(){
        Form<Users> loginForm = userForm.bindFromRequest();

        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("user", loginForm.get().userName);
            return redirect("/");
        }
    }

    public static Result login(){
        return ok(login.render(userForm));
    }

    public static Result logout(){
        session().clear();
        flash("success", "You've been logged out");
        return redirect("/login");
    }

    public static Result signup(){
        return ok(signup.render(userForm));
    }

    public static Result createUser(){
        Form<Users> boundForm = userForm.bindFromRequest();
        Users user = boundForm.get();
        Ebean.save(user);
        return ok();
    }

    //TODO Make YAML File for this.
    public static Result createUsers(){
        List<Users> defaultUsers = new ArrayList<>();

        Users bhargav = new Users(Long.valueOf(1), "bhargav@gmail.com", "bhargav");
        Users dij = new Users(Long.valueOf(2), "bhargav@gmail.com", "dij");
        Users jaya = new Users(Long.valueOf(3), "bhargav@gmail.com", "jaya");

        defaultUsers.add(bhargav);
        defaultUsers.add(dij);
        defaultUsers.add(jaya);

        Ebean.save(defaultUsers);

        return ok();
    }
}
