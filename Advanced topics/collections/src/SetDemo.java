import java.util.*;

public class SetDemo {

    public static void show() {
        // sets doesn't have duplicates or order
        Set<String> set = new HashSet<>();
        set.add("La vie");
        set.add("est");
        set.add("belle");
        set.add("belle");
        System.out.println(set);// [La vie, belle, est]

        // to remove the duplicates from a list
        Collection<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        Set<Integer> set2 = new HashSet<>(list);
        System.out.println(set2);// [1, 2]
        // or
        Set<Integer> set3 = new HashSet<>(Arrays.asList(1, 2, 2));
        System.out.println(set3);// [1, 2]

        // Set operations
        // Union
        Set<Integer> set4 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set5 = new HashSet<>(Arrays.asList(3, 4, 5));
        set4.addAll(set5); // set4 = set4 U set5 {1, 2, 3, 4, 5}

        // Intersection
        Set<Integer> set6 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set7 = new HashSet<>(Arrays.asList(3, 4, 5));
        set6.retainAll(set7); // set6 = set6 ^ set7 {3}

        // Difference
        Set<Integer> set8 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set9 = new HashSet<>(Arrays.asList(3, 4, 5));
        set8.removeAll(set9); // set8 = set8 - set9 {1, 2}

    }
}
