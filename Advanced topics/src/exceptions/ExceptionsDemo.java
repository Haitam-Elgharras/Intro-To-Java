package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsDemo {
    public static void show() throws IOException {
        // checked exceptions: IOException, ParseException,
        // any exception that inherits from Exception except RuntimeException
        try {
            var reader = new FileReader("file.txt");
            System.out.println("File opened");
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        System.out.println("Other work 1...");

        // sometimes the order of exceptions matters
        try {
            var reader = new FileReader("file.txt");
            var value = reader.read();
        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist.");
        } catch (IOException ex) {
            System.out.println("Could not read data.");
        }

        // to treat many exceptions in a generic way
        // the first exception in the try block will be thrown
        try {
            var reader = new FileReader("file.txt");
            var value = reader.read();
            new SimpleDateFormat().parse("");
        } catch (IOException | ParseException ex) {
            System.out.println("an error occurred");
        }

        // Resource Management
        FileReader reader = null;
        try {
            reader = new FileReader("file.txt");
            var value = reader.read();
        } catch (IOException ex) {
            System.out.println("could not read data");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    System.out.println("could not close file");
                }
            }
        }
        // to avoid the ugly code above 
        // try with Resources: auto closeable
        try (
                var reader2 = new FileReader("file.txt");
                var writer = new FileReader("text.txt")
        ) {
            var value = reader2.read();
        } catch (IOException ex) {
            System.out.println("could not read data");
        }

        // Re-throwing Exceptions
        var account = new Account();
        try {
            account.deposit(-1);
        } catch (IOException e) {
            System.out.println("Logging");
            throw e;
        }

        // Custom Exceptions
//        try {
//            account.withdraw(10);
//        } catch (InsufficientFundsException e) {
//            System.out.println(e.getMessage());
//        }

        // Exception Chaining
        try {
            account.withdraw(10);
        } catch (AccountException e) {
            var cause = e.getCause();
            System.out.println(cause.getMessage());
        }
    }
    public static void sayHello(String name) {
        System.out.println(name.toUpperCase());
    }
}
