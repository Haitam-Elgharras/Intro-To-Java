import java.io.Serializable;
import java.util.List;

public interface IProductMetier {
    public void addProduct(Product p);
    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public void removeProduct(int id);
    public void saveAllProducts();
}
