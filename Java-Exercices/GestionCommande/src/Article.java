public class Article {
    private long id;
    private String nom;
    private String marque;
    private String description;
    private double prix;
    private int quantiteStock;
    private Categorie categorie;

    public double getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Article: " + this.nom
                    + ", " + this.marque
                    + ", " + this.description
                    + ", " + this.prix
                    + ", " + this.quantiteStock
                    + ", " + this.categorie;
    }
}
