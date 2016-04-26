import org.OperationEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rasiel on 26.04.16.
 */
public class OperationManager {

    private static SessionFactory factory;

    OperationManager(SessionFactory factory) {
        this.factory = factory;
    }

    public void makeOperation(/* params? */) {

    }

    public List<OperationEntity> list() {
        List<OperationEntity> entities = new ArrayList<OperationEntity>();

        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            entities = session.createQuery("FROM OperationEntity").list();
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
