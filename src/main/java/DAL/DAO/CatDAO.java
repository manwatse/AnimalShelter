package DAL.DAO;

import DAL.HibernateUtil;
import models.Cat;
import org.hibernate.Session;

import java.util.List;

public class CatDAO extends AbstractDAO {

    public List<Cat> getCats(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("From Cat", Cat.class).list();
        }
    }

}
