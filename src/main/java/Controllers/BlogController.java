package Controllers;

import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Maximilien on 10/07/2017.
 */
public class BlogController {
    public void register(String username, String password) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        System.out.print("LOGLOGLOG");

        if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Registration Error", "Invalid credentials");
        }

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("helloworld.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //FacesContext.getCurrentInstance().addMessage(null, message);
        //context.addCallbackParam("loggedIn", loggedIn);
    }
}
