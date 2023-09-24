import java.text.NumberFormat;
import java.util.Locale;

public class MortgageCalculator {
    private final byte MONTHS_IN_YEAR =12;
    private final byte PERCENT =100;

    private byte years;
    private int principal;
    private float annualInterest;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.years = years;
        this.annualInterest = annualInterest;
    }

    public double calculateMortage() {
        double mortage = principal
                * (getMonthlyInterest() * Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()))
                / (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) - 1);

        return mortage;
    }
    private double balance(int numberOfPaymentsMade) {
        double balance = principal
                * (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) - Math.pow(1 + getMonthlyInterest(), numberOfPaymentsMade))
                / (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) - 1);

        return balance;
    }
    public void getPaymentSchedule() {
        for (short month = 1; month <= getNumberOfPayments(); month++) {
            double balance = balance(month);
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(balance));
        }
    }    
    
     private int getNumberOfPayments() {
        return  years * MONTHS_IN_YEAR;
    }
    private float getMonthlyInterest() {
        return annualInterest / (PERCENT * MONTHS_IN_YEAR);
    }

}

