import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MetierProduitImpl metier = new MetierProduitImpl();
        List<Product> products = metier.getAllProducts();
        if(products != null)
            for (Product p : products)
                System.out.println(p);

    }
}