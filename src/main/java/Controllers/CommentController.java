package Controllers;

import Entities.Article;
import Entities.Comment;
import Entities.User;
import Services.CommentService;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Maximilien on 10/07/2017.
 */
@SessionScoped
@Named("commentController")
public class CommentController implements Serializable{
  @Inject
  CommentService commentService;

  private String content;

  private String name;

  public String getContent() {
    return content;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Comment Add(Article article, User user, String name)
  {
    Comment comment = new Comment();
    comment.setContent(name);
    comment.setArticle(article);
    comment.setUser(user);
    this.content = "";
    return commentService.Add(comment);
  }



  /*public void AddComment()
  {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    Comment comment = new Comment();
    comment.setArticle((Article) session.getAttribute('article'));
    comment.setUser((Article) session.getAttribute('user'));
    comment.setContent(content);
    comment.setTitle(name);
  }*/

  public Comment Add(Comment obj) {
    return commentService.Add(obj);
  }

  public boolean Update(Comment obj) {
    return commentService.Update(obj);
  }

  public List<Comment> List() {
    return commentService.List();
  }

  public List<Comment> ListFromArticle(int articleId) {
    return commentService.ListFromArticle(articleId);
  }
}
