import java.util.Scanner;

public class ControlFlow {
    


    public static void main(String[] args){
        // comparison operators
        int x= 10;
        int y= 20;
        System.out.println(x==y);//false
        System.out.println(x!=y);//true
        System.out.println(x>y);//false
        System.out.println(x<y);//true

        // logical operators
        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        boolean hasCriminalRecord = false;
        boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord; // true

        // if statement
        int temp = 32;
        if (temp > 30) {
            System.out.println("It's a hot day");
            System.out.println("Drink water");
        } 
        else if (temp > 20) 
            System.out.println("Beautiful day");
         else 
            System.out.println("Cold day");

        // for boolean
        int income = 120_000;
        hasHighIncome = (income > 100_000);
        System.out.println(hasHighIncome);//true

        // ternary operator
        String className = income > 100_000 ? "First" : "Economy";
        System.out.println(className);//First


        String role = "admin";

        switch (role) {
            case "admin":
                System.out.println("You're an admin");
                break;
            case "moderator":
                System.out.println("You're a moderator");
                break;
            default:
                System.out.println("You're a guest");
        }


        // for loop
        for (int i = 0; i < 5; i++)
            System.out.println("Hello World " + i);
        //or
        for(int i=5; i>0; i--)
            System.out.println("Hello World " + i);

        // while loop
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.print("Input: ");
            input = scanner.next().toLowerCase();
            if(input.equals("pass"))
                continue;
            if(input.equals("quit"))
                break;
            System.out.println(input);
        }

        // foreach loop: one direction only, doesn't have index
        String[] fruits = {"Apple", "Mango", "Orange"};
        for (String fruit : fruits)
            System.out.println(fruit);
        
        
        
        

    }
}
