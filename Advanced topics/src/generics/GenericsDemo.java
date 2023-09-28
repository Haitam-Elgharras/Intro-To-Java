package generics;

public class GenericsDemo {

    public static void show() {
        var list = new List();
        // we can pass any reference it will be casted to Object with Integer.valueOf(1)...
        list.add(1);
        list.add("a");

        // what happens at runtime ???
//        var number = list.get(0);
//        System.out.println(number);
//        System.out.println(number.getClass());
//        var string = list.get(1);
//        System.out.println(string);
//        System.out.println(string.getClass());
    }
}
