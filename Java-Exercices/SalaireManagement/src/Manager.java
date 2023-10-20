public class Manager extends  Employee{

    private String service;
    private double facteurAugmentation = 1.2;
    public Manager(String name, String prenom, String email, String phone, double salaire, String service) {
        super(name, prenom, email, phone, salaire);
        this.service = service;
    }

    @Override
    public double calculerSalaire() {
        return getSalaire() * facteurAugmentation;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Salaire: "+calculerSalaire());
        System.out.println("Service: "+service);
    }
}
