package DAO;

import Entities.Blog;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BlogManagerAccess extends ManagerAccess {

    @Transactional
    public List<Blog> ListFromUser(int userId) {
        return em.createQuery("select b from Blog b where b.user.id = " + userId).getResultList();
    }
}