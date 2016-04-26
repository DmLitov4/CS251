import org.WarehouseEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rasiel on 26.04.16.
 */
public class WarehouseManager {

    private static SessionFactory factory;

    WarehouseManager(SessionFactory factory) {
        this.factory = factory;
    }


    public void add(/* params? */) {

    }

    public void remove(/* params? */) {

    }

    public void update(/* params? */) {

    }

    public List<WarehouseEntity> list() {
        List<WarehouseEntity> entities = new ArrayList<WarehouseEntity>();

        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            entities = session.createQuery("FROM WarehouseEntity").list();
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
