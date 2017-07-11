package Services;

import DAO.BlogManagerAccess;
import Entities.Blog;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Yassine on 10/07/2017.
 */
@SessionScoped
public class BlogService implements Serializable {

  @Inject
  private BlogManagerAccess blogManagerAccess;

  public Blog Add(Blog obj)
  {
    return blogManagerAccess.Add(obj);
  }

  public boolean Update(Blog obj)
  {
    return blogManagerAccess.Update(obj);
  }

  public List<Blog> List() {
    return blogManagerAccess.getList(Blog.class);
  }

  public List<Blog> ListFromUser(int userId) {
    return blogManagerAccess.ListFromUser(userId);
  }
}
