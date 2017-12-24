package dao;

import dataset.UserDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class UserDAO {

    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public long insertUser (String login, String password) throws HibernateException{
        return (Long) session.save(new UserDataSet(login,password));
    }



    public UserDataSet getByLogin(String login) throws HibernateException {

         Query query = session.createQuery("FROM UserDataSet WHERE login = :login");
        query.setString("login", login);
        UserDataSet user = (UserDataSet) query.uniqueResult();



      return user;
    }


}
