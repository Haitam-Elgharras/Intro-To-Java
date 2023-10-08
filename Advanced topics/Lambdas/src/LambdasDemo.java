import java.util.Objects;

public class LambdasDemo {
    public LambdasDemo(String message) {
        if(!message.isEmpty())
        System.out.println(message+ " from Constructor");
    }
    public static void print(String message) {
        System.out.println(message+ " from Method Reference");
    }
    public void printFromInstance(String message) {
        System.out.println(message+ " from Instance Method Reference");
    }
    public static void show() {
        // using a class implementation
        greet(new ConsolePrinter());

        // using an anonymous inner class
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message+ " from anonymous Inner class");
            }
        });

        // using a lambda expression
        greet(message -> System.out.println(message+ " from Lambda expression"));


        //Method Reference: Class/Object::method################

        // using system.out.println
        greet(System.out::println);// the exact same result

        // using a static method
        greet(message -> print(message));
        greet(LambdasDemo::print);// the same

        // using an instance method
        var demo = new LambdasDemo("");
        greet(message -> demo.printFromInstance(message));
        greet(demo::printFromInstance);// the same

        //using constructor
        greet(message -> new LambdasDemo(message));
        greet(LambdasDemo::new);// the same


    }

    private static void greet(Printer printer) {
        printer.print("Hello World!");
    }
}