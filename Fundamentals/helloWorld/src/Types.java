import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.awt.Point;
import java.text.NumberFormat;

public class Types {
    public static void main(String[] args) throws Exception {
        // we have 8 primitive types in java
        byte age = 30;
        // we add L cause without it the java compiler will think it's an int
        long viewsCount = 3_123_456_789L;
        // java sees numbers with decimal points as doubles so we add F(float)
        float price = 10.99F;
        char letter = 'A';
        boolean isEligible = false;

        // all the other types are reference types(other than the 8 primitive types)

        // we have to allocate memory for referenced types
        // we don't need to free the space it's done by java
        Date now = new Date();
        System.out.println(now);

        // primitive types are copied by their value
        int x = 1;
        int y = x;
        x = 2;
        System.out.println(y);// y is still 1

        // reference types are copied by their reference
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2;
        System.out.println(point2);// point2.x is 2

        // About Strings:
        // strings are reference types but they are immutable (for the String class)
        // we have other classes that are mutable like StringBuilder and StringBuffer
        // the difference between them is that StringBuffer is thread safe

        // String message = new String("Hello World"); but we use a shortcut
        // Note for string : if we declare two vars with the shortcut with the same value
        // they will have the same memory location
        // but if we change one of them they will be diff ( learn string pool)
        String message = "Hello World";
        message=message+"!!"; // this creates a new string

        // any method that seems to change a string actually returns a new string
        String[] str =message.split(" "); // ["Hello","world"]
        message.endsWith("!!");// returns true
        message.startsWith("!!");// returns false
        message.length();// returns 13
        message.indexOf("e");// returns 1
        message.indexOf("sky");// returns -1
        message.replace("!", "*");// returns Hello World**
        message.toLowerCase();// returns hello world!!
        message.toUpperCase();// returns HELLO WORLD!!
        message.trim();// deletes the white spaces at the beginning and the end of the string
        message.substring(1,4);// 4 not included

        // escape sequences
        String escape = "Hello \"Haitam\""; // returns Hello "Haitam"
        String escape2 = "c:\\Windows\\..."; // returns c:\Windows\...
        String escape3 = "c:\nWindows\\..."; // returns c: and then a new line and then Windows\...
        String escape4 = "c:\tWindows\\..."; // returns c: and then a tab and then Windows\...

        // arrays: in java have a fixed length
        // int[] numbers = new int[5]; old way
        int[] numbers = { 2, 3, 5, 1, 4 };
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        // multidimensional arrays
        // int[][] numbers2 = new int[2][3]; old way
        int[][] numbers2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(Arrays.deepToString(numbers2));

        // constants: once we initialize a constant we can't change it
        final float PI = 3.14F;
        // PI=1; this will give an error

        // arithmetic expressions
        int result = 10 / 3; // returns 3
        double result2 = (double) 10 / (double) 3; // returns 3.3333333333333335
        System.out.println(result2);

        // increment and decrement operators
        int x2 = 1;
        x2++; // returns 2
        ++x2; // returns 3


        // Casting

        // implicit casting(auto casting)
        // byte > short > int > long > float > double
        short x3 = 1;
        int y3 = x3 + 2; // returns 3
        double d = 1.1 + 2; // returns 3.1 (auto catsting 2 to 2.0)

        // explicit casting: when we have data loss
        double x4 = 1.1;
        int y4 = (int) x4 + 2; // returns 3

        // parsing
        String x5 = "1";
        int y5 = Integer.parseInt(x5) + 2; // returns 3
        // String x =Integer.toString("1.1"); throws an exception
        double y6 = Double.parseDouble("1.1") + 2; // returns 3.1

        // Math class
        int result3 = Math.round(1.5F); // returns 2
        int result4 = (int) Math.ceil(1.1F); // returns 2
        int result5 = (int) Math.floor(1.9F); // returns 1
        int result6 = Math.max(1, 2); // returns 2
        int result7 = Math.min(1, 2); // returns 1
        double result8 = Math.random(); // returns a random number between 0 and 1
        double result9 = Math.random() * 100; // returns a random number between 0 and 100
        int result10 = (int) (Math.random() * 100); // returns a random number between 0 and 100


        // Formatting numbers
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result11 = currency.format(1234567.891); // returns $1,234,567.89
       String result12 = NumberFormat.getPercentInstance().format(0.1); // returns 10%


       //  inputs
        //reading numbers
         Scanner scanner = new Scanner(System.in);
         //print allows us to print without a new line
         System.out.print("Age: ");// 
        byte age2 = scanner.nextByte();
        System.out.println("You are " + age2);

        //reading strings
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner2.nextLine().trim();
        System.out.println("You are " + name);






        




    }
}
