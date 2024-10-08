Collection Interface:
- All collections implement the Iterable interface. so we can use the for-each loop to iterate over any collection object.
- The Collection interface is the root interface of the Java collections framework. It declares the core methods that all collections will have.


List Interface :

    1- every list is a collection cause it implements the collection interface.
    2- lists support index based access unlike collections.




  *** Comparable vs Comparator ***

  The choice between implementing the `Comparable` interface and using a `Comparator` depends on your specific needs and the flexibility you require in your sorting logic. Let's break down the differences and use cases for both:

  1. **`Comparable` Interface**:
     - When you implement the `Comparable` interface in a class, you define a natural order for instances of that class.
     - The natural order is based on the comparison logic you provide in the `compareTo` method within the class.
     - You use `Collections.sort()` to sort a list of objects of that class, and it will use the natural order defined by `compareTo`.
     - This approach is suitable when you have a single, well-defined way to compare objects of the class.

     public class Person implements Comparable<Person> {
         private String name;
         private int age;

         // ... other fields and methods ...

         @Override
         public int compareTo(Person other) {
             return this.name.compareTo(other.name);
         }
     }
     ```

  2. **`Comparator` Interface**:
     - When you use a `Comparator`, you can define multiple ways to compare objects of a class without modifying the class itself.
     - You create separate `Comparator` implementations for different sorting criteria.
     - This approach is more flexible and allows you to sort objects in various ways based on different criteria.

     public class Person {
         private String name;
         private int age;

         // ... other fields and methods ...
     }

     // Define a comparator for sorting by name
     class NameComparator implements Comparator<Person> {
         @Override
         public int compare(Person p1, Person p2) {
             return p1.getName().compareTo(p2.getName());
         }
     }

     // Define a comparator for sorting by age
     class AgeComparator implements Comparator<Person> {
         @Override
         public int compare(Person p1, Person p2) {
             return Integer.compare(p1.getAge(), p2.getAge());
         }
     }

     - You can use `Collections.sort()` with the appropriate `Comparator` to sort the list based on different criteria.

- In summary, the choice between `Comparable` and `Comparator` depends on whether you want to define a single, natural
     order for your objects (use `Comparable`) or if you need flexibility to define multiple sorting criteria without
     modifying the class itself (use `Comparator`). `Comparator` is more flexible and allows you to adapt your sorting
     logic to different requirements.



     ***Set Interface***

        1- A Set is a Collection that cannot contain duplicate elements.
        2- the Set does not guarantee the order of the elements.


    ***Note*** : if a method accept a collection as a parameter, then it can accept any type sub type of collection.
        and also if the type inside this coll is <? extends String> then it can accept any type of collection that
        contains a sub type of String.


    ***Maps***:
    If you have a list of students and you want to find a student by their name, there are two common ways to do it:
    using a list or using a map.

    1. **Using a List:** If you use a list, you'll need to go through each student in the list one by one until you find
     the student with the desired name. This takes time proportional to the number of students in the list, which is
     represented as O(n) time complexity, where 'n' is the number of students.

    2. **Using a Map:** On the other hand, if you use a map, you can find the student by their name almost instantly.
    Maps, often called HashMaps in Java, work like dictionaries in other programming languages. They associate keys
    (in this case, student names) with values (the corresponding student object). When you want to find a student by
    name, you directly access the student associated with that name in O(1) time complexity, which means it's very
    fast regardless of the number of students.

    * In summary, when you need to quickly find items by a specific identifier (like names in this case),
    using a map (or HashMap) is a much more efficient choice compared to using a list. It's like having
    a super-fast index for your data.

    * Maps are part of the Java Collections Framework(java.util package). but it's not a part of the Iterable subclass
       so it's not a collection.
    * Must of the time we use the HashMap class as an implementation of the Map interface.
