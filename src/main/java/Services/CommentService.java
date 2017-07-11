package Services;

import DAO.CommentManagerAccess;
import Entities.Comment;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Yassine on 10/07/2017.
 */
@SessionScoped
public class CommentService implements Serializable {

  @Inject
  private CommentManagerAccess commentManagerAccess;

  public Comment Add(Comment obj)
  {
    return commentManagerAccess.Add(obj);
  }

  public boolean Update(Comment obj)
  {
    return commentManagerAccess.Update(obj);
  }

  public List<Comment> List() {
    return commentManagerAccess.getList(Comment.class);
  }

  public List<Comment> ListFromArticle(int articleId) {
    return commentManagerAccess.ListFromArticle(articleId);
  }
}
