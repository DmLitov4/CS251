import org.AgentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rasiel on 26.04.16.
 */
public class AgentManager {

    private static SessionFactory factory;

    AgentManager(SessionFactory factory) {
        this.factory = factory;
    }

    public void add(/* params? */) {

    }

    public void remove(/* params? */) {

    }

    public void update(/* params? */) {

    }

    public List<AgentEntity> list() {
        List<AgentEntity> agents = new ArrayList<AgentEntity>();

        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            agents = session.createQuery("FROM AgentEntity").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return agents;
    }
}
