package DAL.DAO;

import DAL.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class AbstractDAO {

    public void saveObject(Object object){
        Transaction transaction =null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(object);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
