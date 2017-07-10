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
import javax.servlet.http.HttpSession;

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

    public User getUserFromLogin(String username) {return userService.getUserFromLogin(username);}

    private String username;

    private String password;

    private String repassword;
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


    public String getRepassword() {
        return password;
    }

    public void setRepassword(String password) {
        this.password = password;
    }

    public void register() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;

        if (username == null || password == null)
        {
            System.out.println("user ou mdp vide");
            try {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Registration error", "Invalid credentials");
                FacesContext.getCurrentInstance().addMessage(null, message);
                FacesContext.getCurrentInstance().getExternalContext().redirect("register.xhtml");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        User user = getUserFromLogin(username);

        if (user != null) {
            System.out.println("user déja existant");
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("register.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        else {
            System.out.println("user non existant");
            loggedIn = true;
            User newUser = new User(username, password, User.Roles.Admin);

            User addeduser = Add(newUser);
            //HttpSession session = request.getSession();
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Registration Error", "Invalid credentials");
        }
        try {

            FacesContext.getCurrentInstance().getExternalContext().redirect("profile.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //FacesContext.getCurrentInstance().addMessage(null, message);
        //context.addCallbackParam("loggedIn", loggedIn);
    }
}
