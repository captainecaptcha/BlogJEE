package Services;

import DAO.UserManagerAccess;
import Entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Yassine on 10/07/2017.
 */
@SessionScoped
public class UserService implements Serializable {

  @Inject
  private UserManagerAccess userManagerAccess;

  public User Add(User obj)
  {
    return userManagerAccess.Add(obj);
  }

  public boolean Update(User obj)
  {
    return userManagerAccess.Update(obj);
  }

  public List<User> List() {
    return userManagerAccess.getList(User.class);
  }

  public User getUserFromLogin(String username) {return userManagerAccess.getUserFromLogin(username); }
}
