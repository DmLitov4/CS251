import org.OperationEntity;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by rasiel on 26.04.16.
 */

public class OperationManager extends EntityManager<OperationEntity> {

    OperationManager(SessionFactory factory) {
        super(factory);
    }

    public List<OperationEntity> list() {
        return list(OperationEntity.class);
    }
}