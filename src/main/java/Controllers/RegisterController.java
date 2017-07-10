package Controllers;

import Entities.User;
import Services.UserService;
import Views.HelloWorld;
import jdk.nashorn.internal.runtime.Debug;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import org.primefaces.context.RequestContext;
import static org.primefaces.component.keyboard.Keyboard.PropertyKeys.password;
import javax.faces.context.FacesContext;
/**
 * Created by Maximilien on 10/07/2017.
 */
@ApplicationScoped
@Named("RegisterController")
public class RegisterController {
    @Inject
    UserService userService;
    public User Add(User obj)
    {
        return userService.Add(obj);
    }

    public List<User> List() {
        return userService.List();
    }

    public boolean Update(User obj)
    {
        return userService.Update(obj);
    }

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
