public class Employee {

    private int baseSalary;
    private int hourlyRate;
    public static int numberOfEmployees;

    public static void printNumberOfEmployees() {
        System.out.println(numberOfEmployees);
    }

    public Employee(int baseSalary, int hourlyRate) {
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++;
    }
    public Employee(int baseSalary) {
        // using this to call the other constructor
        this(baseSalary,0);
    }

    public int calculateWage(int extraHours) {
        return baseSalary + (hourlyRate * extraHours);
    }
    public int calculateWage() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        if (baseSalary <= 0)
            throw new IllegalArgumentException("Salary cannot be 0 or less.");
        this.baseSalary = baseSalary;
    }
    private int getBaseSalary() {
        return baseSalary;
    }

    public void setHourlyRate(int hourlyRate) {
        if(hourlyRate <0)
            throw new IllegalArgumentException("Hourly rate cannot be 0 or negative.");
        this.hourlyRate = hourlyRate;
    }
    private int getHourlyRate() {
        return hourlyRate;
    }
    
}
