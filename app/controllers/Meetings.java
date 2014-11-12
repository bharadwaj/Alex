package controllers;

import com.avaje.ebean.Ebean;
import models.Meeting;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.meetings.list;
import views.html.meetings.schedulemeeting;

import java.util.List;

/**
 * Place to Plan, Organize, and Fix Meetings.
 * Created by Aagama on 09-11-2014.
 */

@Security.Authenticated(Secured.class)
public class Meetings extends Controller {

    private static final Form<Meeting> meetingForm = Form.form(Meeting.class);

    public static Result all() {
        List<Meeting> allMeetings = Meeting.find.all();
        return ok(list.render(allMeetings));
    }

    public static Result fix() {
        return ok(schedulemeeting.render(meetingForm));
    }

    public static Result save() {
        Form<Meeting> boundForm = meetingForm.bindFromRequest();

        Meeting meeting = boundForm.get();
        Ebean.save(meeting);
        return redirect("/meets");
    }

    public static Result delete(Long id) {
        Meeting.find.ref(id).delete();
        return ok("Successfully Deleted");
    }

    //TODO See how easy it is to set default values of a form!
    public static Result edit(Long id) {
        final Meeting meeting = Meeting.find.byId(id);

        if (meeting == null) {
            return notFound("Meeting Doesn't exist");
        }

        Form<Meeting> filledForm = meetingForm.fill(meeting);
        return ok(schedulemeeting.render(filledForm));
    }

    public static Result byId(Long id) {
        final Meeting foundMeeting = Meeting.find.byId(id);
        return ok();
    }


}
