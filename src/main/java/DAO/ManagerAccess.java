package DAO;

import Entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ManagerAccess {
    @PersistenceContext(unitName = "StarBlog")
    private EntityManager em;

    public <T> T Add(T obj)
    {
        return em.merge(obj);
    }

    public <T> boolean Update(T obj)
    {
        try {
            obj = em.merge(obj);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public List<User> List() {
        return null;
    }
}
