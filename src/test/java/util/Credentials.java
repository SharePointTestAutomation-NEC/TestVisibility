package util;
import pageobjects.HomePage;
import step_definitions.BaseClass;
import java.util.logging.Level;

public class Credentials extends BaseClass {
    private final HomePage loginPage = new HomePage();
    public void getCredentials() {

        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        String cred = System.getProperty("CRED");
        if (cred == null) {
            cred = System.getenv("CRED");
            if (cred == null) {
                cred = "SharePoint";
            }
        }
        System.out.println("The test is running on " + cred.toUpperCase() + " Credentials");
        switch (cred.toLowerCase()) {
            case "SharePointQA":

                break;

            case "SharePointDev":

                break;

            case "SharePointTest":

                break;

            case "SharePointQAAdmin":

                break;

            case "editor":

                break;

            case "SharePointQAClient":

                break;
        }
    }
}


