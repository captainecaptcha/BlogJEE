package Services;

import Controllers.ArticleController;
import DAO.ArticleManagerAccess;
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
  private ArticleManagerAccess articleManagerAccess;

  public Article Add(Article obj)
  {
    return articleManagerAccess.Add(obj);
  }

  public boolean Update(Article obj)
  {
    return articleManagerAccess.Update(obj);
  }

  public List<Article> List() {
    return articleManagerAccess.getList(Article.class);
  }
}
