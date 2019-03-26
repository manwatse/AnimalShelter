package DAL.DAO;

import DAL.HibernateUtil;
import models.Product;
import org.hibernate.Session;

import java.util.List;

public class ProductDAO extends AbstractDAO {

    public List<Product> getProducts(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("From Product", Product.class).list();
        }
    }

}
