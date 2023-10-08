import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void show() {
        List<Integer> list = List.of(10, 20, 30);

        // Imperative Programming (for, if, switch, etc.)
        for (var item : list)
            System.out.println(item);

        // Declarative Programming (What to do, not how to do it)
        // the forEach method takes a Consumer interface

        // creating a class that implements the Consumer interface
        Consumer<Integer> consume = new ConsumerInteger();
        list.forEach(consume);

        // with lambda expression to creat a Consumer object
        Consumer<Integer> consume2 = item -> System.out.println(item);
        list.forEach(consume2);

        // with lambda expression and method reference
        list.forEach(System.out::println);


        // Chain Consumers ###########
        List<String> list2 = List.of("baby","shark","doo");
        Consumer<String> print = item -> System.out.println(item);
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());
        list2.forEach(print.andThen(printUpperCase));

        // under the hood it's converting the above to one lambda expression
         list2.forEach(item -> { print.accept(item); printUpperCase.accept(item); });

    }
}
