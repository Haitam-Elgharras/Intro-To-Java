import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit>{
    private List<Produit> produits;

    public MetierProduitImpl() {
        this.produits = new ArrayList<>();
    }

    @Override
    public boolean add(Produit produit) {

        if(findById(produit.getId()) == null) {
            produits.add(produit);
            return true;
        }

        else {
            System.out.println("Produit existe deja");
            return false;
        }
    }

    @Override
    public Produit findById(long id) {

        return produits.stream()
                    .filter(produit -> produit.getId() == id)
                    .findFirst().orElse(null);
    }

    @Override
    public void delete(long id) {
        if (findById(id) != null)
            produits.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Produit> getAll() {
      return produits;
    }
}
