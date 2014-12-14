package models;

import com.avaje.ebean.annotation.EnumValue;
import org.h2.engine.User;
import org.joda.time.DateTime;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aagama on 14-12-2014.
 */
@Entity
public class Chat extends Model {

    @Id
    public Long id;

    @Formats.DateTime(pattern = "yyyy-MM-dd")
    public DateTime createTime;

    @ManyToOne
    public Users user;
    public String title;
    public ChatType type;

    @OneToMany(mappedBy = "chat")
    public List<ChatMessage> messages;

    @Entity
    public class ChatMessage {
        @Id
        public Long id;

        @ManyToOne
        public Chat chat;

        @Required
        public String chatMessage;
        @Formats.DateTime(pattern = "yyyy-MM-dd")
        public DateTime messageTime;
    }

    public enum ChatType {

        @EnumValue("C")
        CHAT,

        @EnumValue("T")
        TASK,

        @EnumValue("M")
        MEETING,

        @EnumValue("F")
        FILE,

        @EnumValue("S")
        SCHEDULE,
    }

}
