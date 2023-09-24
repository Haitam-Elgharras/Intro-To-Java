import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortageCalculator {

    static final byte MONTHS_IN_YEAR =12;
    static final byte PERCENT =100;

    public static void main (String[] args) {
        int principal = (int) readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        printMortage(principal, annualInterest, years);
        printPaymentSchedule(principal, annualInterest, years);
    }

    private static void printMortage(int principal, float annualInterest, byte years) {
        double mortage = calculateMortage(principal, annualInterest, years);
        String mortageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortage);
        System.out.println("Mortage: " + mortageFormatted);
    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = balance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(balance));
        }
    }

    public static double balance(int principal,float annualInterest, int years, int numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / (PERCENT * MONTHS_IN_YEAR);
        int numberOfPayments = years * MONTHS_IN_YEAR;
        
        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

     public static double readNumber(String prompt, double min, double max) {
        Scanner scanner =new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if(value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortage(int principal,float annualInterest, int years) {

        final byte MONTHS_IN_YEAR =12;
        final byte PERCENT =100;

        float monthlyInterest = annualInterest / (PERCENT * MONTHS_IN_YEAR);
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortage;
    }
    
}
