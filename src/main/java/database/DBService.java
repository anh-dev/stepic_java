package database;

import dao.UserDAO;
import dataset.UserDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;


public class DBService {

    private static final String HIBERNATE_SHOW_SQL = "true";
    private static final String HIBERNATE_HBM2DLL_AUTO = "create";

    private final SessionFactory sessionFactory;

    public DBService() {
        Configuration configuration = getH2Configuration();
        this.sessionFactory = createSessionFactory(configuration);
    }

    private Configuration getH2Configuration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(UserDataSet.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:./h2db");
        configuration.setProperty("hibernate.connection.username", "test");
        configuration.setProperty("hibernate.connection.password", "test");
        configuration.setProperty("hibernate.show_sql", HIBERNATE_SHOW_SQL);
        configuration.setProperty("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DLL_AUTO);
        return configuration;
    }


    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public long signUp (String login, String password) throws DBException {
       try {

           Session session = sessionFactory.openSession();
           Transaction transaction = session.beginTransaction();
           UserDAO userDAO = new UserDAO(session);
           long id = userDAO.insertUser(login, password);
           System.out.println(id);
           transaction.commit();
           session.close();
           return id;
       }catch (HibernateException e){
              throw  new DBException(e);
       }
    }

    public UserDataSet signIn(String login, String password) throws DBException {
        try {
            Session session = sessionFactory.openSession();

            UserDAO userDAO = new UserDAO(session);
//            UserDataSet userDataSet = userDAO.getByLogin(login);
            UserDataSet userDataSet = userDAO.getByLogin(login);
            System.out.println(userDataSet);
            session.close();
            return userDataSet;

        }catch (HibernateException e){
            throw new DBException(e);
        }
    }
}
