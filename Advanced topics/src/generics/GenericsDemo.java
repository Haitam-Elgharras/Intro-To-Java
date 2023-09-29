package generics;

import java.util.ArrayList;

public class GenericsDemo {

    public static void show() {
        var list = new List();
        // we can pass any reference it will be casted to Object with Integer.valueOf(1)...
        list.add(1);
        list.add("a");

        // what happens at runtime ???
        var number = list.get(0);
        System.out.println(number);
        System.out.println(number.getClass());
        var string = list.get(1);
        System.out.println(string);
        System.out.println(string.getClass());

        // boxing and unboxing
        var IntList = new GenericList<Integer>();
        IntList.add(1); // boxing -> Integer.valueOf(1)
        int number2 = IntList.get(0); // unboxing -> number2 = IntList.get(0).intValue();

        // Generic Constraints: when we've added the constraint <T extends Comparable> we can pass just the types that
        // implements the Comparable interface
        var comparableList1 = new GenericList<Integer>();
        var comparableList2 = new GenericList<String>();
//         var ComparableList3 = new GenericList<Account>(); // Account doesn't implement Comparable interface
        comparableList1.add(1000);
        System.out.println(comparableList1.get(0));

    }
}
