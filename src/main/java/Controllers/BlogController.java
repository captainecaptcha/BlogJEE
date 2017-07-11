package Controllers;

import Entities.Blog;
import Services.BlogService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.List;

@ApplicationScoped
@Named("BlogController")
public class BlogController {
    @Inject
    BlogService blogService;

    private Blog currentBlog;

    public void setCurrentBlog(Blog blog) {
        this.currentBlog = blog;
    }

    public Blog getCurrentBlog() {
        return currentBlog;
    }

    public void showBlogs(Blog blog)
    {
        currentBlog = blog;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("articles.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Blog Add(Blog obj) {
        return blogService.Add(obj);
    }

    public boolean Update(Blog obj) {
        return blogService.Update(obj);
    }

    public List<Blog> List() {
        return blogService.List();
    }

    public List<Blog> ListFromUser(int userId) {
        return blogService.ListFromUser(userId);
    }
}
