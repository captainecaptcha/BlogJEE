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

public abstract class ManagerAccess<T> {
    @PersistenceContext(unitName = "StarBlog")
    protected EntityManager em;

    @Transactional
    public T Add(T obj)
    {
        //return em.merge(obj);
        em.persist(obj);
        return obj;
    }
    @Transactional
    public boolean Update(T obj)
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
    public List getList(Class<T> type)
    {
        return em.createQuery("select a from " + type.getSimpleName() + " a").getResultList();
    }
}
