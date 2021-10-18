package helpers.EmailHelpers;

/**
 * Created by tdatta on 7/10/17.
 */
import java.util.List;



/**
 * This class shows how to use the MailTrap classes,
 * Just update the apiToken & inboxId, then give it a try.
 *
 * @author jxc876
 */
public class MailTrapDemo
{
    public void checkMessage()
    {
        // insert your token & inbox id
        String apiToken = "cf5baf72998a2f2796aae2312a10dee3";
        String inboxId = "229659";

        Mailtrap mailtrap = new Mailtrap(apiToken);
        Inbox inbox = mailtrap.getInbox(inboxId);

        System.out.println("unread messages = " + inbox.getEmailsUnreadCount());

        List<Message> messages = mailtrap.getMessages(inbox);

        if (messages.size() > 0){
            Message msg = messages.get(0);
            String html = msg.getHtml();
            mailtrap.deleteMessage(inbox, msg);
        }
        else{
            System.out.println("No messages found");
        }
    }
}