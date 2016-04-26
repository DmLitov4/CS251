import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rasiel on 27.04.16.
 */
public class EntityManager<EntityType> {
    private static SessionFactory factory;

    EntityManager(SessionFactory factory) {
        this.factory = factory;
    }

    public Integer add(EntityType entity) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer entityID = null;
        try {
            tx = session.beginTransaction();
            entityID = (Integer) session.save(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return entityID;
    }

    public void remove(EntityType entity) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void update(EntityType entity) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    protected List<EntityType> list(Class<EntityType> clazz) {
        List<EntityType> entities = new ArrayList<EntityType>();

        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            entities = session.createCriteria(clazz).list();
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