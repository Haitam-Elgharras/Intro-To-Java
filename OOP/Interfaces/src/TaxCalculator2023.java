public class TaxCalculator2023 implements TaxCalculator {
    private double taxableIncome;

    public TaxCalculator2023(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }
// it's a good practice to add the @Override annotation at the methods overridden from the interface
    @Override
    public double calculateTax() {
        return taxableIncome * 0.3;
    }
}
