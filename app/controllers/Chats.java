package controllers;

import play.mvc.Security;

/**
 * Created by Aagama on 09-11-2014.
 */

@Security.Authenticated(Secured.class)
public class Chats extends Controller{

    public static Form<Chat> chatForm = Form.form(Chat.Class);

    public static Result index(){
        return ok();
    }

    public static Result saveTask() {

        return TODO;
    }
}
