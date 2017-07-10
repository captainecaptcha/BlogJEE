package DAO;

import Entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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

    @Transactional
    public <T> List getList(Class<T> type)
    {
        return em.createQuery("select a from " + type.getSimpleName() + " a").getResultList();
    }
}
