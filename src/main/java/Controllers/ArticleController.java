package Controllers;

import Entities.Article;
import Entities.Blog;
import Entities.User;
import Services.ArticleService;
import Services.BlogService;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.List;

/**
 * Created by Maximilien on 10/07/2017.
 */
@ApplicationScoped
@Named("articleController")
public class ArticleController {
  @Inject
  ArticleService articleService;

  public Article Add(Article obj) {
    return articleService.Add(obj);
  }

  public boolean Update(Article obj) {
    return articleService.Update(obj);
  }

  public List<Article> List() {
    return articleService.List();
  }
}
