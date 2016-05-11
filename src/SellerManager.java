import org.ProductEntity;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by rasiel on 11.05.16.
 */
public class SellerManager extends EntityManager<ProductEntity> {

    SellerManager(SessionFactory factory) {
        super(factory);
    }

    public List<ProductEntity> list() {
        return list(ProductEntity.class);
    }
}
