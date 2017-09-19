package connectToDatabase;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class SessionUnit {
    private Session session;
    private Transaction transaction;

    HibernateUtil hibernateUtil = new HibernateUtil();

    public Session getSession() {
        return session;
    }

    public void setSession() {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Session openSession(){
        return hibernateUtil.getSessionFactory().openSession();
    }

    public Transaction openTransaction(){
        session = openSession();
        transaction = session.beginTransaction();
        return transaction;
    }

    public void closeSession(){
        session.close();
    }

    public void closeTransaction(){
        transaction.commit();
        closeSession();
        hibernateUtil.exitSessionFactory();
    }
}
