import org.AgentEntity;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by rasiel on 26.04.16.
 */
public class AgentManager extends EntityManager<AgentEntity> {

    AgentManager(SessionFactory factory) {
        super(factory);
    }

    public List<AgentEntity> list() {
        return list(AgentEntity.class);
    }
}
