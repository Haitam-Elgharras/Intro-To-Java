import exceptions.Account;
import exceptions.AccountException;
import exceptions.ExceptionsDemo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ExceptionsDemo.show();
        } catch (Throwable e) {
            System.out.println("An unexpected error occurred.");
        }

        Account account = new Account();
        try {
            account.deposit(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            account.withdraw(10);
        } catch (AccountException e) {
            // insufficient funds in your account.
            System.out.println(e.getCause().getMessage());
        }

    }
}