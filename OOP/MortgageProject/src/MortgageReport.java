import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    final static byte MONTHS_IN_YEAR = 12;
    private MortgageCalculator calculator;

    
    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printMortage() {
        double mortage = calculator.calculateMortage();
        String mortageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortage);
        System.out.println("Mortage: " + mortageFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        calculator.getPaymentSchedule();
    } 
}
