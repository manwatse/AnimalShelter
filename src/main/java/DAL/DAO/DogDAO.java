package DAL.DAO;

import DAL.HibernateUtil;

import models.Dog;
import org.hibernate.Session;

import java.util.List;

public class DogDAO  extends AbstractDAO {

    public List<Dog> getDogs(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("From Dog", Dog.class).list();
        }
    }
}
