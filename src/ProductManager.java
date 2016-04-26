import org.ProductEntity;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by rasiel on 26.04.16.
 */
public class ProductManager extends EntityManager<ProductEntity> {

    ProductManager(SessionFactory factory) {
        super(factory);
    }

    public List<ProductEntity> list() {
        return list(ProductEntity.class);
    }
}