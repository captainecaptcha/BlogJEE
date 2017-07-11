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
}
