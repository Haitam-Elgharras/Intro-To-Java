public class Main {

    public static void main(String[] args) {
        // the entierNatrul will null
        EntierNaturel entierNaturel = null;
        try {
             entierNaturel = new EntierNaturel(-1);
        } catch (NegatifNumberException e) {
            System.out.println(e.getMessage());
        }

        try {
             entierNaturel = new EntierNaturel(0);
            entierNaturel.decrement();
        } catch (NegatifNumberException e) {
            System.out.println(e.getMessage());
        }

        try {
             entierNaturel = new EntierNaturel(1);
            entierNaturel.setValue(-1);
        } catch (NegatifNumberException e) {
            System.out.println(e.getMessage());
        }

        try {
            entierNaturel = new EntierNaturel(2);
            entierNaturel.setValue(4);
            entierNaturel.decrement();
        } catch (NegatifNumberException e) {
            System.out.println(e.getMessage());
        }

        NegatifNumberException.notAcceptedValues.forEach((value) -> {
            System.out.println("Valeur non acceptée: " + value + "\n");
        });

        System.out.println("Fin du programme");

    }
}