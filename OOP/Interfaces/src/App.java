public class App {
    public static void main(String[] args) {
//      to avoid creating many objects to pass them to the constructors
//      of our classes, we use a framework like spring
        var calculator = new TaxCalculator2023(100_000);
        var report = new TaxReport(calculator);
        report.show();

//      setter injection
        report.setCalculator(new TaxCalculator2022());
        report.show();

//      method injection : we pass the dependency to the method that needs it
//        report.show(new TaxCalculator2022());

    }

}