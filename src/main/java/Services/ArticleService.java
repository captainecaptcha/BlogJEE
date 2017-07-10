package Services;

import DAO.ManagerAccess;
import Entities.Article;
import Entities.Blog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Yassine on 10/07/2017.
 */
@ApplicationScoped
public class ArticleService {

  @Inject
  private ManagerAccess managerAccess;

  public Article Add(Article obj)
  {
    return managerAccess.Add(obj);
  }

  public boolean Update(Article obj)
  {
    return managerAccess.Update(obj);
  }

  public List<Article> List() {
    return managerAccess.getList(Article.class);
  }
}
