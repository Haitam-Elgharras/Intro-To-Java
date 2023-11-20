package ma.enset.tpjdbc.com.dao;

import ma.enset.tpjdbc.com.dao.entities.Product;

import java.util.List;

public class ProductDao implements Dao<Product,Integer> {
    @Override
    public void create(Product product) {


    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Integer id) {

    }
}
