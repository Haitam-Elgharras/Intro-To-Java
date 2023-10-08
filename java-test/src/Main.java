import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Generic<String> generic = new Generic<>();
        generic.setItem(0, "Hello");
        generic.setItem(1, "World");
        generic.setItem(2, "Java");
        generic.setItem(3, "Kotlin");
        generic.setItem(4, "C++");
        generic.setItem(5, "C#");
        generic.setItem(6, "Python");
        generic.setItem(7, "JavaScript");
        generic.setItem(8, "PHP");
        generic.setItem(9, "Go");
        // method 1
        var iterator = generic.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // method 2: internally the java will use the iterator(next,hasNext).
        for (String item : generic) {
            System.out.println(item);
        }
    }
}