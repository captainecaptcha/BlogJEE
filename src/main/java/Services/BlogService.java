package Services;

import DAO.ManagerAccess;
import Entities.Blog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Yassine on 10/07/2017.
 */
@ApplicationScoped
public class BlogService {

  @Inject
  private ManagerAccess managerAccess;

  public Blog Add(Blog obj)
  {
    return managerAccess.Add(obj);
  }

  public boolean Update(Blog obj)
  {
    return managerAccess.Update(obj);
  }

  public List<Blog> List() {
    return managerAccess.getList(Blog.class);
  }
}
