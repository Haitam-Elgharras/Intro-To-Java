import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {

    public static void show() {
        Collection<String> collection = new ArrayList<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");
        // or
        Collections.addAll(collection, "a", "b", "c");

        collection.remove("a");
        collection.contains("a");
        collection.size();
        collection.clear();
        collection.isEmpty();

        var objectArray = collection.toArray();
        // 0 is a convention to tell toArray to create a new array with the same size as the collection
        var stringArray = collection.toArray(new String[0]);

        // we can't use var here if we need a collection of strings cause with var it will be an arrayList.
        Collection<String> other = new ArrayList<>();
        other.addAll(collection);

        System.out.println(collection==other); // false
        System.out.println(collection.equals(other)); // true
    }
}
