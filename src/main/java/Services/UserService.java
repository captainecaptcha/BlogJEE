package Services;

import DAO.UserManagerAccess;
import Entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Yassine on 10/07/2017.
 */
@ApplicationScoped
public class UserService {

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

  public User getUserFromLogin(String username) {return userManagerAccess.getUserFromLogin(User.class, username); }
}
