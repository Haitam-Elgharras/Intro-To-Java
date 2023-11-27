public class CompteEpargne extends CompteBancaire {
    private double tauxInteret;

    public CompteEpargne(int numero, double solde, String nomTotulaire, double tauxInteret) {
        super(numero, solde,nomTotulaire);
        this.tauxInteret = tauxInteret;
    }

    public void calculInteret() throws CompteException {
        double solde = getSolde();
        double interet = solde * tauxInteret / 100;
        depot(interet);
    }
}
