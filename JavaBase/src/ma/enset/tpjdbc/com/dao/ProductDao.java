package ma.enset.tpjdbc.com.dao;

import ma.enset.tpjdbc.com.dao.entities.Product;

import java.util.List;

public interface ProductDao extends Dao<Product,Integer> {
    List<Product> searchProductByQuery(String query);
}
