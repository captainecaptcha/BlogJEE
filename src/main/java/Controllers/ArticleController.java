package Controllers;

import Entities.Article;
import Entities.Blog;
import Services.ArticleService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
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

  public Article Add(Blog blog, String name, String content)
  {
    Article article = new Article();
    article.setName(name);
    article.setContent(content);
    article.setBlog(blog);
    this.name = "";
    this.content = "";
    return articleService.Add(article);
  }

  public Article Add(Article obj) {
    return articleService.Add(obj);
  }

  public boolean Update(Article obj) {
    return articleService.Update(obj);
  }

  public List<Article> List() {
    return articleService.List();
  }

  public List<Article> ListFromBlog(int blogId) {
    return articleService.ListFromBlog(blogId);
  }

}
