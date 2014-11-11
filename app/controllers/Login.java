package controllers;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

/**
 * Created by Aagama on 11-11-2014.
 */
public class Login extends Controller{

    public static Result login(String paramUser){

        String loggedUser = request().cookies().get("user").value();

        if(loggedUser != null) {
            return redirect("/");
        }
        response().setCookie("login", paramUser);

        return ok();
    }

    public static Result logout(){

        response().discardCookie("login");

        return redirect("/login");
    }
}
