import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class MetierProduitImpl implements IProductMetier{
    private List<Product> products;
    private String fileName = "products.dat";


    public MetierProduitImpl() {
        products = new ArrayList<>();
        this.fileName = fileName;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getAllProducts() {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Product> products = (List<Product>) ois.readObject();
            ois.close();
            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public Product getProductById(int id) {
        for (Product p : products)
            if (p.getId() == id)
                return p;

        return null;
    }

    public void removeProduct(int id) {
        Product p = getProductById(id);
        if (p != null)
            products.remove(p);
    }

    public void saveAllProducts() {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }








}
