import org.ProductEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rasiel on 26.04.16.
 */
public class ProductManager {

    private static SessionFactory factory;

    ProductManager(SessionFactory factory) {
        this.factory = factory;
    }


    public void add(/* params? */) {

    }

    public void remove(/* params? */) {

    }

    public void update(/* params? */) {

    }

    public List<ProductEntity> list() {
        List<ProductEntity> entities = new ArrayList<ProductEntity>();

        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            entities = session.createQuery("FROM ProductEntity").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return entities;
    }
}
