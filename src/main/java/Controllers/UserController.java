package Controllers;

import Entities.User;
import Services.UserService;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yassine on 10/07/2017.
 */
@ApplicationScoped
@Named("userController")
public class UserController {


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

  public boolean UpdateUser(Class<User> type, int id, String username, String password) { return userService.UpdateUser(id, username, password);}

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
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
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
      User newUser = new User(username, password, 0);

      User addeduser = Add(newUser);
      session.setAttribute("user_id", addeduser.Getid());
      session.setAttribute("user_login", addeduser.Getlogin());
      session.setAttribute("user_role", addeduser.Getrole());
      session.setAttribute("user_password", addeduser.GetPassword());
      session.setAttribute("user", addeduser);
      message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Registration Error", "Invalid credentials");
      try {

        FacesContext.getCurrentInstance().getExternalContext().redirect("profile.xhtml");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    //FacesContext.getCurrentInstance().addMessage(null, message);
    //context.addCallbackParam("loggedIn", loggedIn);
  }

  public void login() {
    RequestContext context = RequestContext.getCurrentInstance();
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    FacesMessage message = null;
    boolean loggedIn = false;

    if (username == null || password == null)
    {
      try {
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Connection error", "Invalid credentials");
        FacesContext.getCurrentInstance().addMessage(null, message);
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        return;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    User user = getUserFromLogin(username);

    if (user != null) {
      System.out.println("user déja existant");
      loggedIn = true;
      User userconnected = getUserFromLogin(username);
      session.setAttribute("user_id", userconnected.Getid());
      session.setAttribute("user_login", userconnected.Getlogin());
      session.setAttribute("user_role", userconnected.Getrole());
      session.setAttribute("user_password", userconnected.GetPassword());
      session.setAttribute("user", userconnected);
      message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
      try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("profile.xhtml");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    else {
      System.out.println("user non existant");
      loggedIn = false;
      message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Connection Error", "Invalid credentials");
      try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    //FacesContext.getCurrentInstance().addMessage(null, message);
    //context.addCallbackParam("loggedIn", loggedIn);
  }

  public void goRegister()
  {
    try {
      FacesContext.getCurrentInstance().getExternalContext().redirect("register.xhtml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void goLogin()
  {
    try {
      FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void EditProfile()
  {
    try {
      FacesContext.getCurrentInstance().getExternalContext().redirect("editProfile.xhtml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void edit() {

    RequestContext context = RequestContext.getCurrentInstance();
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    FacesMessage message = null;

    if (username == null || password == null)
    {
      try {
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid informations", "Invalid credentials");
        FacesContext.getCurrentInstance().addMessage(null, message);
        FacesContext.getCurrentInstance().getExternalContext().redirect("editProfile.xhtml");
        return;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    User user = getUserFromLogin(
            (String)session.getAttribute("user_login"));

    if (user != null) {
      message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
      session.setAttribute("user_id", user.Getid());
      session.setAttribute("user_login", user.Getlogin());
      session.setAttribute("user_role", user.Getrole());
      session.setAttribute("user_password", user.GetPassword());
      session.setAttribute("user", user);

      try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("register.xhtml");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    else {

      message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Registration Error", "Invalid credentials");
      try {

        FacesContext.getCurrentInstance().getExternalContext().redirect("profile.xhtml");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    //FacesContext.getCurrentInstance().addMessage(null, message);
    //context.addCallbackParam("loggedIn", loggedIn);
  }
}
