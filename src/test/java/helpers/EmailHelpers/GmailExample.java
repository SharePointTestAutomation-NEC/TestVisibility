package helpers.EmailHelpers;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * Created by tdatta on 7/11/17.
 */
public class GmailExample {


    public void sendEmail() throws EmailException {

        Email email = new SimpleEmail();
//        smtp.host=smtp.gmail.com
//        smtp.port=587
//        smtp.ssl=yes
//        smtp.user="me@gmail.com"
//        smtp.password="myPassword"

        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
//        email.setHostName("smtp.googlemail.com");
//        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator
                ("example@gmail.com", "password"));
        email.setSSLOnConnect(true);
        email.setFrom("user@gmail.com");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("foo@bar.com");
        email.send();
    }
}
