public class CompteBancaire {
    private int numero;
    private double solde;
    private String nomTotulaire;

    public CompteBancaire(int numero, double solde, String nomTotulaire) {
        this.numero = numero;
        this.solde = solde;
        this.nomTotulaire = nomTotulaire;
    }


    public void depot(double montant) throws CompteException {
        if (montant <0)
            throw new CompteException(new IllegalArgumentException("Montant doit etre positif"));
        this.solde += montant;
    }

    public void retraitArgent(double montant) throws CompteException {
        if(this.solde < montant)
            throw new CompteException(new FondsInsuffisantsException());
        this.solde -= montant;
    }

    @Override
    public String toString() {
        return "Les informations du compte bancaire: \n" +
                "Nom: " + nomTotulaire+ "\n" +
                "Numero: " + numero + "\n" +
                "Solde: " + solde + "\n" ;
    }

    public void transfertArgent(CompteBancaire destinataire, double montant) throws CompteException {
        // check if the account exists
        if (destinataire == null)
            throw new CompteException(new CompteInexistantException());

        // check if the amount is less than the current solde
        if (this.solde < montant)
            throw new CompteException(new FondsInsuffisantsException());

        retraitArgent(montant);
        destinataire.depot(montant);
    }


    public int getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public String getNom() {
        return nomTotulaire;
    }

}
