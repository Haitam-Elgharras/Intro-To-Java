public class Main {
    public static void main(String[] args) {

        Ingenieur in1= new Ingenieur("Mouad", "Mouad", "jdjdhdhd@email", "062524545454", 1000, "Java");
        Manager m1 = new Manager("Mohamed","Ahmed","ahmed@gmail","062545454", 1000, "IT");

        System.out.println("###############Ingenieur###############");
        in1.afficher();
        System.out.println("###############Manager###############");
        m1.afficher();

    }

}