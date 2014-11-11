package controllers;

import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result authenticate(){
        return TODO;
    }

    public static Result login(){
        return ok(login.render());
    }

    public static Result logout(){

        response().discardCookie("login");

        return redirect("/login");
    }


}
