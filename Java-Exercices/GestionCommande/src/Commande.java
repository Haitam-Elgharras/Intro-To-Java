import java.util.Date;
import java.util.List;

public class Commande {
    private long id;
    private Date date;
    private Etat etatCommande;

    // bidirectional association from Command to Client and from Client to Command
    private  List<LigneCommande> ligneCommandes;

}
