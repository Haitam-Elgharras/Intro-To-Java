public class Ingenieur extends Employee{
    private String specialite;
    private double facteurAugmentation = 1.15;

    public Ingenieur(String name, String prenom, String email, String phone, double salaire, String specialite) {
        super(name, prenom, email, phone, salaire);
        this.specialite = specialite;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Salaire: "+calculerSalaire());
        System.out.println("Specialite: "+specialite);
    }

    @Override
    public double calculerSalaire() {
        return getSalaire() * facteurAugmentation;
    }


}
