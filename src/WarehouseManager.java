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


    public void add(/* params? */) {

    }

    public void remove(/* params? */) {

    }

    public void update(/* params? */) {

    }

    public List<WarehouseEntity> list() {

        return null;
    }
}
