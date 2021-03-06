package Controllers;

import Entities.User;
import Services.UserService;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Yassine on 10/07/2017.
 */
@SessionScoped
@Named("userController")
public class UserController implements Serializable {


    @Inject
    UserService userService;

    public User Add(User obj) {
        return userService.Add(obj);
    }

    public List<User> List() {
        return userService.List();
    }

    public User getUserFromLogin(String username) {
        return userService.getUserFromLogin(username);
    }

    public User getUserById(int userId) {
        return userService.getUserById(userId);
    }

    private String username;

    private String password;

    private boolean loggedIn;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

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
        return repassword;
    }

    public void setRepassword(String password) {
        this.repassword = password;
    }


    public void register() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (username == null || password == null || (!password.equals(repassword))) {
            loggedIn = false;
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("register.xhtml");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        User user = getUserFromLogin(username);

        if (user != null) {
            loggedIn = false;
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("register.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            loggedIn = true;
            User newUser = new User(username, password, 0);
            session.setAttribute("user", Add(newUser));
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("profile.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String login() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (username == null || password == null) {
            return "login";
        }

        User user = getUserFromLogin(username);

        if (user != null) {
            if (password.equals(user.getPassword())) {
                this.loggedIn = true;
                session.setAttribute("user", getUserFromLogin(username));
                return "profile";
            }
                return "login";
        } else

        {
            this.loggedIn = false;
            return "login";
        }
    }

    public void goRegister() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("register.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goLogin() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goProfile() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("profile.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void EditProfile() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("editProfile.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void edit() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (username == null || password == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("editProfile.xhtml");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        User user = (User) session.getAttribute("user");

        if (user != null) {
            user.setLogin(username);
            user.setPassword(password);
            userService.Update(user);
            user = getUserFromLogin(username);
            session.setAttribute("user", user);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("profile.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void disconnect() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
