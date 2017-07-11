package DAO;

import Entities.Article;
import Entities.Blog;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ArticleManagerAccess extends ManagerAccess {

    @Transactional
    public List<Article> getListOf(int blogId) {
        return em.createQuery("select a from Article a where a.blog.id = " + blogId).getResultList();
    }
}