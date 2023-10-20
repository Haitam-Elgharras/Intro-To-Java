public abstract class Employee  {
    private String name;
    private String prenom;
    private String email;
    private String phone;
    private double salaire;

    public Employee(String name, String prenom, String email, String phone, double salaire) {
        this.name = name;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.salaire = salaire;
    }

    public abstract double calculerSalaire();
    public void afficher(){
        System.out.println("Name: "+name
        +"\nPrenom: "+prenom
        +"\nEmail: "+email
        +"\nPhone: "+phone);
    }


    public double getSalaire() {
        return salaire;
    }


}
