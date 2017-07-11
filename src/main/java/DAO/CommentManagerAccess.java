package DAO;

import Entities.Comment;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class CommentManagerAccess extends ManagerAccess<Comment> {

    @Transactional
    public List<Comment> ListFromArticle(int articleId) {
        return em.createQuery("select a from Comment a where a.article.id = " + articleId).getResultList();
    }
}