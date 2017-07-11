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
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
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

  public void Add(Article article, User user, String name, String content)
  {
    Comment comment = new Comment();
    comment.setTitle(name);
    comment.setContent(content);
    comment.setDate(java.util.Date.from(Instant.now()));
    comment.setArticle(article);
    comment.setUser(user);
    this.name = "";
    this.content = "";
    commentService.Add(comment);
    try {
      FacesContext.getCurrentInstance().getExternalContext().redirect("article.xhtml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

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
