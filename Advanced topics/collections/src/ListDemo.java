import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {

    public static void show() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add(list.size(), "c"); // add at last index+1

        list.clear();
        Collections.addAll(list, "a", "b", "c","a");
        list.indexOf("a");//0
        list.lastIndexOf("a");//3
        list.get(0);//a

        // the diff between set and add is that set replaces the item at the specified index
        list.set(0,"A");//A

        // subList returns a new list.
        var newList = list.subList(0, 2);//[a,b]

        // all lists are collections and collections are iterable so lists are iterable
        for (var item : list)
            System.out.println(item);


    }
}
