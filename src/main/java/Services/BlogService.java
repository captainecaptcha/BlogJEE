package Services;

import DAO.BlogManagerAccess;
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
