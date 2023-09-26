public class TaxReport {

    // our class is tightly coupled to TaxCalculator
    private TaxCalculator calculator;

//    this is called constructor injection
    public TaxReport(TaxCalculator calculator) {
        this.calculator = calculator;
    }
    public void show() {
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }

    public void setCalculator(TaxCalculator calculator) {
        this.calculator = calculator;
    }
}
