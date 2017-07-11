package Controllers;

import Entities.Article;
import Entities.Blog;
import Services.ArticleService;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Maximilien on 10/07/2017.
 */
@SessionScoped
@Named("articleController")
public class ArticleController implements Serializable{
  @Inject
  ArticleService articleService;

  private String name;

  private String content;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void archive(Article article)
  {
    article.setArchived(true);
    articleService.Update(article);
    try {
      FacesContext.getCurrentInstance().getExternalContext().redirect("articles.xhtml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void Add(Blog blog, String name, String content)
  {
    Article article = new Article();
    article.setName(name);
    article.setContent(content);
    article.setBlog(blog);
    this.name = "";
    this.content = "";
    articleService.Add(article);
    try {
      FacesContext.getCurrentInstance().getExternalContext().redirect("articles.xhtml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Article Add(Article obj) {
    return articleService.Add(obj);
  }

  public boolean Update(Article obj) {
    return articleService.Update(obj);
  }

  public void ShowArticle(Article obj)
  {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    session.setAttribute("article", obj);

    try {
      FacesContext.getCurrentInstance().getExternalContext().redirect("article.xhtml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String goedit()
  {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    Article article = (Article) session.getAttribute("article");
    name = article.getName();
    content = article.getContent();
    return "editarticle";
  }

  public String edit()
  {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    Article article = (Article) session.getAttribute("article");
    article.setContent(content);
    article.setName(name);
    articleService.Update(article);
    content = null;
    name = null;
    return "articles";
  }

  public String cancel()
  {
     content = null;
     name = null;
     return "articles";
  }

  public List<Article> List() {
    return articleService.List();
  }

  public List<Article> ListFromBlog(int blogId) {
    return articleService.ListFromBlog(blogId);
  }

}
