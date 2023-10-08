import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var list = new Iterable<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (var item : list)
            System.out.println(item);

        // Collections
        CollectionsDemo.show();

        // List
        ListDemo.show();

        // sorting list
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("b", "e2"));
        customers.add(new Customer("a", "e1"));
        customers.add(new Customer("c", "e3"));
        Collections.sort(customers); // sort by name (Comparable)
        Collections.sort(customers, new CustomerComparator()); // sort by email (Comparator)

        for (var customer : customers)
            System.out.println(customer);


        System.out.println("#######################Set#######################");
        // Set
        SetDemo.show();


        // Maps
        System.out.println("#######################Maps#######################");
        MapDemo.show();
    }
}