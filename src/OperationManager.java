import org.AgentEntity;
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


//    List<AgentEntity> list() {
//
//        return null;
//    }
}
