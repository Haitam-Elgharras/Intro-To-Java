import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void show(){
        var c1 = new Customer("ahmed", "ahmed@gmail.com");
        var c2 = new Customer("ali", "ali@gmail.com");

        Map<String,Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);

        var customer = map.get("ali@gmail.com");
        System.out.println(customer);

       var UnknownCustomer = new Customer("Unknown", "");
       // if the key is not found, return the default value
        var customer2 = map.getOrDefault("Unknown", UnknownCustomer);

        // check if the key exists: return true or false
        var exists = map.containsKey("Unknown");

        // replace a customer with a new one
        // we cannot replace the key, only the value ??
        map.replace("ali@gmail.com", new Customer("alo", ""));
        System.out.println(map);

        // iterate over the map
        for (var key : map.keySet()) {
            System.out.println(key);
            // or
            System.out.println(map.get(key));
        }

        // returns a collection of values
        for (var customeR: map.values())
            System.out.println(customeR);

        // or iterate over the map using entrySet which returns a set of key-value pairs
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey());
            // or
            System.out.println(entry.getValue());
        }
    }
}
