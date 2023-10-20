public class LigneCommande {
    private long id;
    private int quantite;

    private Article article;
    private Commande commande;

    @Override
    public String toString() {
        return "LigneCommande: "
                + this.quantite
                + ", "
                + this.article
                + ", "
                + this.commande;
    }
}
