package generics;

public class Utils {
    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) < 0) ? second : first;
    }

    public static <K,V> void map(K key, V value) {
        System.out.println(key + "=" + value);
    }

    public static void printUser(User user) {
        System.out.println(user);
    }

    // with this implementation, we can pass just GenericList<User> and non of its derivatives
    public static void printUsers(GenericList<User> users) {
        users.add(new User(10));
        users.get(0);
    }

    // with this implementation, we can pass any GenericList<T> with any type of T
    public static void printAny(GenericList<?> users) {
        Object x = users.get(0);
        System.out.println("in the printAny method "+x);
//        users.add(new User(10)); // compile time error
    }

    // We can pass the GenericList<User> or any class that is a subtype of User (Instructor in this case)
    // the extents give us the ability to read from the list
    public static void printUserOrSub(GenericList<? extends User> users) {
        User x = users.get(0);

        // compile time error because we don't know what type of object is in the list just we know that it's a child of User
        // users.add(new User(10));
    }

    // We can pass the GenericList<User> or any class that is a supertype of User (Object in this case)
    // the super give us the ability to write to the list
     public static void printUserOrPar(GenericList<? super User> users) {

        users.add(new User(10));
        // but if we try to read from the list, we need to read it as an Object cause we don't know what type of object is in the list
         // but we are sure that it's child of the Object class so :
         Object x = users.get(0);
    }
}
