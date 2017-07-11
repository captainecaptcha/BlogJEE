package Services;

import DAO.ArticleManagerAccess;
import Entities.Article;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Yassine on 10/07/2017.
 */
@SessionScoped
public class ArticleService implements Serializable {

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

  public List<Article> ListFromBlog(int blogId) {
    return articleManagerAccess.ListFromBlog(blogId);
  }
}
