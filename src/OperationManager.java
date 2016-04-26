import org.AgentEntity;
import org.OperationEntity;
import org.hibernate.SessionFactory;

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

        return null;
    }
}
