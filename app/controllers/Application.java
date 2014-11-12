package controllers;

import com.avaje.ebean.Ebean;
import models.Users;
import play.data.Form;
import play.mvc.*;

import views.html.*;
import views.html.login.login;
import views.html.login.signup;



public class Application extends Controller {

    private static Form userForm = Form.form(Users.class);

    @Security.Authenticated(Secured.class)
    public static Result index() {
        return ok(index.render("Your new application is ready."));
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

}
