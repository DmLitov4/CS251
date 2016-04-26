import org.ProductEntity;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by rasiel on 26.04.16.
 */
public class ProductManager {

    private static SessionFactory factory;

    ProductManager(SessionFactory factory) {
        this.factory = factory;
    }


    public void add(/* params? */) {

    }

    public void remove(/* params? */) {

    }

    public void update(/* params? */) {

    }

    public List<ProductEntity> list() {

        return null;
    }
}
