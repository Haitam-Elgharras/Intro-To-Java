import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombreEnStock;

    private  static  int  count = 0;

    public Product( String nom, String marque, double prix, String description, int nombreEnStock) {
        this.id = count++;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombreEnStock = nombreEnStock;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product:\n"+
                "id=" + id +
                ",\n nom='" + nom +
                ",\n marque='" + marque +
                "\n, prix=" + prix +
                ",\n description='" + description +
                ",\n nombreEnStock=" + nombreEnStock +
                "\n";
    }
}
