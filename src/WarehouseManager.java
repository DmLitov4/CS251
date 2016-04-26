import org.AgentEntity;
import org.WarehouseEntity;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by rasiel on 26.04.16.
 */
public class WarehouseManager {

    private static SessionFactory factory;

    WarehouseManager(SessionFactory factory) {
        this.factory = factory;
    }


    void add(/* params? */) {

    }

    void remove(/* params? */) {

    }

    void update(/* params? */) {

    }

    List<WarehouseEntity> list() {

        return null;
    }
}
