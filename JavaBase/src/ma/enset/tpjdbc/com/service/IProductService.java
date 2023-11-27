package ma.enset.tpjdbc.com.service;

import ma.enset.tpjdbc.com.dao.ProductDao;
import ma.enset.tpjdbc.com.dao.entities.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    void deleteProductById(int id);
    List<Product> getAllProducts();
    void updateProduct(Product product);
    List<Product> searchProductByQuery(String query);
}
