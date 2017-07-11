package Controllers;

import Entities.Blog;
import Entities.User;
import Services.BlogService;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named("blogController")
public class BlogController implements Serializable {
    @Inject
    BlogService blogService;

    public Blog Add(User user, String name)
    {
        Blog blog = new Blog();
        blog.setName(name);
        blog.setUser(user);
        this.name = "";
        return blogService.Add(blog);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void archive(Blog blog)
    {
        blog.setArchived(true);
        blogService.Update(blog);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("blogs.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showArticlesFromBlog(Blog blog)
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("blog", blog);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("articles.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Blog Add(Blog obj) {
        return blogService.Add(obj);
    }

    public List<Blog> List() {
        return blogService.List();
    }

    public List<Blog> ListFromUser(int userId) {
        return blogService.ListFromUser(userId);
    }
}
