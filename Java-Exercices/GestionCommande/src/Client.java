import java.util.List;

public class Client {
    private long id;
    private String nom;
    private String prenom;
    private String ville;
    private String adresse;
    private String telephone;
    private String email;

    // uni-directional association
    // we have the direction of the association from Client to Command,
    // so from a client we can get the list of his commands,
    // but from a command we can't get his client
    private List<Commande> commandes;

    // if the association was bidirectional,
    // we can get the client from a command
    // for this we add a field client in Command class


    public void addCommande(Commande commande) {
        this.commandes.add(commande);
    }

    public void removeCommande(Commande commande) {
        this.commandes.remove(commande);
    }

    @Override
    public String toString() {
        return "Client: "
                + this.nom
                + " "
                + this.prenom
                + ", "
                + this.ville
                + ", "
                + this.adresse
                + ", "
                + this.telephone
                + ", "
                + this.email;
    }
}
