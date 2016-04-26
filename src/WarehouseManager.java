import org.WarehouseEntity;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by rasiel on 26.04.16.
 */
public class WarehouseManager extends EntityManager<WarehouseEntity> {

    WarehouseManager(SessionFactory factory) {
        super(factory);
    }

    public List<WarehouseEntity> list() {
        return list(WarehouseEntity.class);
    }
}