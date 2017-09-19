package connectToDatabase;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private SessionFactory sessionFactory = buildSessionFactory();

    private SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void exitSessionFactory(){
        sessionFactory.close();
    }

}
