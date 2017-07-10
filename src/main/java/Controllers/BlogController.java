package Controllers;

import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;
import Entities.Blog;
import Entities.User;
import Services.BlogService;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Maximilien on 10/07/2017.
 */
@ApplicationScoped
@Named("BlogController")
public class BlogController {
    @Inject
    BlogService blogService;

    public Blog Add(Blog obj) {
        return blogService.Add(obj);
    }

    public boolean Update(Blog obj) {
        return blogService.Update(obj);
    }

    public List<Blog> List() {
        return blogService.List();
    }
}
