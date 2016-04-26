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


    void add(/* params? */) {

    }

    void remove(/* params? */) {

    }

    void update(/* params? */) {

    }

    List<ProductEntity> list() {

        return null;
    }
}
