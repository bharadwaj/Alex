package controllers;

import com.avaje.ebean.Ebean;
import models.Finisher;
import views.html.home;
import play.data.Form;
import play.mvc.*;

import views.html.login.login;
import views.html.login.signup;


public class Application extends Controller {

    private static Form userForm = Form.form(Finisher.class);

    @Security.Authenticated(Secured.class)
    public static Result index() {
        return ok(home.render());
    }

    public static Result authenticate(){
        Form<Finisher> loginForm = userForm.bindFromRequest();

        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("user", loginForm.get().username);
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
        Form<Finisher> boundForm = userForm.bindFromRequest();
        Finisher finisher = boundForm.get();
        Ebean.save(finisher);
        return ok();
    }

}
