package controllers;

import play.mvc.Security;

/**
 * Created by Aagama on 09-11-2014.
 */

@Security.Authenticated(Secured.class)
public class Chats {
}
