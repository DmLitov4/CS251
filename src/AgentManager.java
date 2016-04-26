import org.AgentEntity;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by rasiel on 26.04.16.
 */
public class AgentManager {

    private static SessionFactory factory;

    AgentManager(SessionFactory factory) {
        this.factory = factory;
    }

    void add(/* params? */) {

    }

    void remove(/* params? */) {

    }

    void update(/* params? */) {

    }

    List<AgentEntity> list() {

        return null;
    }
}
