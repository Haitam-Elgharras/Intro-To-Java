import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Number: ");
        int number = scanner.nextInt();

        if(number%5==0&&number%3==0)
            System.out.print("FizzBuzz");
        else if(number%5==0)
            System.out.print("Fizz");
        else if(number%3==0)
            System.out.print("Buzz");
        else 
            System.out.print(number);




    }
    
}
