package Services;

import Controllers.UserController;
import DAO.ManagerAccess;
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
  private ManagerAccess managerAccess;

  public User Add(User obj)
  {
    return managerAccess.Add(obj);
  }

  public boolean Update(User obj)
  {
    return managerAccess.Update(obj);
  }

  public List<User> List() {
    return managerAccess.List();
  }
}
