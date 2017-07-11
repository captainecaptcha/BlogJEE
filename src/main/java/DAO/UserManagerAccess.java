package DAO;

import Entities.User;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class UserManagerAccess extends ManagerAccess<User> {

    @Transactional
    public User getUserFromLogin(String username)
    {
        String sql = "select a from User a WHERE a.login = " + "\'" + username + "\'";
        Query query = em.createQuery(sql);
        List<User> list = (List<User>) query.getResultList();
        if (list.size() > 0)
            return list.get(0);
        return null;
    }
}
