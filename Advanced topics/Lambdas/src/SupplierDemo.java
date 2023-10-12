import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class SupplierDemo {
    public static void show() {
        Supplier<Double> getRand = () -> Math.random() * 10;
        System.out.println(getRand.get());

        DoubleSupplier sup = () -> Math.random();
        System.out.println(sup.getAsDouble());

        System.out.println("########### Function Interface ###########");
        Function<String, Integer> spaceCount = str -> str.length() - str.replaceAll(" ", "").length();
        System.out.println(spaceCount.apply("Hello World "));

        System.out.println("########### Composing Function ###########");

        List<String> map = new ArrayList<>();
        map.add("key1:value1");
        map.add("key2:value2");
        map.add("key3:value3");
        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addCurlyBraces = str -> "{" + str + "}";

        // Using andThen method
        Function<String, String> replaceColonAndBraces = replaceColon.andThen(addCurlyBraces);
        for (var item : map)
            System.out.println(replaceColonAndBraces.apply(item));
        // Using compose method: it do the same thing as andThen but in reverse order
        Function<String, String> replaceColonAndBraces2 = addCurlyBraces.compose(replaceColon);
        for (var item : map)
            System.out.println(replaceColonAndBraces2.apply(item));


        // Predicate
        System.out.println("########### Predicate Interface ###########");
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        System.out.println(isLongerThan5.test("Hello World"));

        // Combining Predicates
        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");
        // and == &&, or == ||, negate == !
        Predicate<String> hasLeftAndRightBraces = hasLeftBrace.and(hasRightBrace);
        System.out.println(hasLeftAndRightBraces.test("{Hello World}"));// true

        Predicate<String> hasLeftOrRightBraces = hasLeftBrace.or(hasRightBrace);
        System.out.println(hasLeftOrRightBraces.test("Hello World"));// false

        Predicate<String> notHasLeftBrace = hasLeftBrace.negate();
        System.out.println(notHasLeftBrace.test("{Hello World}"));// false


        // BinaryOperator
        System.out.println("########### BinaryOperator Interface ###########");
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(1, 2));

        // combing BinaryOperator
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        Function<Integer, Integer> square = a -> a * a;
        System.out.println(multiply.andThen(square).apply(3, 2));

        // UnaryOperator
        System.out.println("########### UnaryOperator Interface ###########");
        UnaryOperator<Integer> square2 = a -> a * a;
        System.out.println(square2.apply(5));

    }
}