package Controllers;

import Entities.User;
import Services.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
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
}
