import exceptions.Account;
import exceptions.AccountException;
import exceptions.ExceptionsDemo;
import generics.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Exceptions
//        try {
//            ExceptionsDemo.show();
//        } catch (Throwable e) {
//            System.out.println("An unexpected error occurred.");
//        }
//
//        Account account = new Account();
//        try {
//            account.deposit(-1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            account.withdraw(10);
//        } catch (AccountException e) {
//            // insufficient funds in your account.
//            System.out.println(e.getCause().getMessage());
//        }





// Generics
        GenericsDemo.show();


        // Comparable Interface
        var user1 = new User(10);
        var user2 = new User(20);

        if (user1.compareTo(user2) < 0)
            System.out.println("user1 < user2");
        else if (user1.compareTo(user2) == 0)
            System.out.println("user1 == user2");
        else
            System.out.println("user1 > user2");


        // Generic methods
        var max = Utils.max(user1, user2);
        System.out.println(max);

        Utils.map("key", 10);


        // Generic classes and Inheritance

        // 1. we can pass the specific class type or any of its derivatives
        var user = new User(10);
        var instructor = new Instructor(20);
        Utils.printUser(user);
        Utils.printUser(instructor);

        // 2. instructor is a subtype of User doesn't mean that List<Instructor> is a subtype of List<User>
        var users = new GenericList<User>();
        Utils.printUsers(users);
        //var instructors = new GenericList<Instructor>();
        // Utils.printUsers(instructors); // compile time error


        // 3. Wildcards
        Utils.printAny(users);
        Utils.printUserOrSub(users);
        Utils.printUserOrPar(users);

//        var instructors = new GenericList<Instructor>();
//        Utils.printAny(instructors); // compile time error
//        Utils.printUserOrSub(instructors);
        //Utils.printUserOrPar(instructors);


    }
}