package DAO;

import Entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

import static org.primefaces.component.autocomplete.AutoComplete.PropertyKeys.type;
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

    @Transactional
    public <T> User getUserFromLogin(Class<T> type, String username)
    {
        //String sql = "select a from User where User.login = " + "\'" + username + "\'";
        String sql = "select a from " + type.getSimpleName() + " a " + "WHERE login = " + "\'" + username + "\'";
        Query query = em.createQuery(sql);
        List<User> list = (List<User>) query.getResultList();
        if (list.size() > 0)
            return list.get(0);
        return null;

    }
}
