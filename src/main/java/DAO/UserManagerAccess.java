package DAO;

import Entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserManagerAccess extends ManagerAccess {


    @Transactional
    public <T> User getUserFromLogin(Class<T> type, String username)
    {
        String sql = "select a from User a WHERE a.login = " + "\'" + username + "\'";
        Query query = em.createQuery(sql);
        List<User> list = (List<User>) query.getResultList();
        if (list.size() > 0)
            return list.get(0);
        return null;
    }
}
