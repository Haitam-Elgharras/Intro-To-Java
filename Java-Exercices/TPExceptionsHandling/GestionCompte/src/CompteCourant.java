public class CompteCourant extends CompteBancaire{
    private double decouvertLimite;
    public CompteCourant(int numero, double solde, String nomTotulaire, double decouvertLimite) {
        super(numero, solde, nomTotulaire);
        this.decouvertLimite = decouvertLimite;
    }

    @Override
    public void retraitArgent(double montant) throws CompteException {
       if (getSolde() - montant >= - decouvertLimite)
           super.retraitArgent(montant);
       else
           throw new CompteException(new FondsInsuffisantsException());
    }
}
