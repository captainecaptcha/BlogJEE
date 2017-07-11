package Web;

import Entities.Article;
import Entities.Blog;
import Services.ArticleService;
import Services.BlogService;
import Services.UserService;
import org.codehaus.jackson.map.ObjectMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.ws.rs.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebService
@Path("/")
@Produces("application/json; charset=UTF-8")
@ApplicationScoped
public class APIService {
    @Inject
    private BlogService blogServices;

    @Inject
    private ArticleService articleServices;

    @Inject
    private UserService userServices;

    @GET
    @Path("/blogs")
    public String getBlogs() {
        ObjectMapper mapper = new ObjectMapper();
        List<Blog> blogs = blogServices.List();
        ArrayList res = new ArrayList();
        for (Blog blog : blogs)
            res.add(blog.getName());

        try {
            return mapper.writeValueAsString(res);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }

    @GET
    @Path("/blogs/{id}")
    public String getPosts(@PathParam("id") int id) {
        ObjectMapper mapper = new ObjectMapper();
        List<Article> articles = articleServices.ListFromBlog(id);
        ArrayList res = new ArrayList();
        for (Article article : articles)
            res.add(article.getName());

        try {
            return mapper.writeValueAsString(res);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }
}