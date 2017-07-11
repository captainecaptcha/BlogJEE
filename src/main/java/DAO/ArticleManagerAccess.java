package DAO;

import Entities.Article;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class ArticleManagerAccess extends ManagerAccess<Article> {

    @Transactional
    public List<Article> ListFromBlog(int blogId) {
        return em.createQuery("select a from Article a where a.blog.id = " + blogId + " and a.isArchived = false").getResultList();
    }
}