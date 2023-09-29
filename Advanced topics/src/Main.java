import exceptions.Account;
import exceptions.AccountException;
import exceptions.ExceptionsDemo;
import generics.GenericsDemo;
import generics.User;
import generics.Utils;

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
    }
}