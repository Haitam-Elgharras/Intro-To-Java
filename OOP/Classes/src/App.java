public class App {
    public static void main(String[] args) throws Exception {
        TextBox textBox1 = new TextBox();
        textBox1.setText("Box 1");
        System.out.println(textBox1.text.toUpperCase());

        TextBox textBox2 = new TextBox();
        textBox2.setText("Box 2");
        System.out.println(textBox2.text);

        // in java all the objects we declare are in the heap (not like C++)
        // and the variables are in the stack holding the reference to the object
        textBox2=textBox1;
        textBox1.setText("Box 3");
        System.out.println(textBox1.text);//Box 3
        System.out.println(textBox2.text);//Box 3


        // Encapsulation
        var employee = new Employee(1,1);
        employee.setBaseSalary(50_000);
        employee.setHourlyRate(20);
        int wage = employee.calculateWage(10);
        System.out.println(wage);


        // Abstraction : reducing coupling by hiding the unnecessary details
        // we see just one field (simple remote) .
        var browser = new Browser();
        browser.navigate("http://google.com");


        // constructors
        var employee2 = new Employee(50_000,20);
        int wage2 = employee2.calculateWage(10);
        System.out.println(wage2);// 50_200


        // method overloading
        var employee3 = new Employee(50_000,20);
        int wage3 = employee3.calculateWage();
        System.out.println(wage3);// 50_000

        // constructor overloading
        var employee4 = new Employee(50_000);


        // static members : They are the members which are not tied to a specific object(class level)
        // we can access them without creating an object
        Employee.printNumberOfEmployees(); // 4


        // Inheritance : we can reuse the code of the parent class
        var control = new TextBox();
        System.out.println(control.isEnabled());// true
    

        // Method overriding : we can change the behavior of the parent class
        var control2 = new TextBox();
        control2.setText("Method overriding");
        System.out.println(control2.toString());// Method overriding
        System.out.println(control2);// Method overriding


        // Upcasting and Downcasting
        // Upcasting : casting a derived class to a base class
        var control3 = new TextBox();
        show(control3);// TextBox
        // Downcasting : casting a base class to a derived class
        var control4 = new UIControl();
        show(control4);


        // Polymorphism : many forms 
        System.out.println("Polymorphism");
        UIControl[] controls = {new TextBox(), new CheckBox()};
        for (var c : controls) {
            c.render();
        }
    }

    public static void show(UIControl control) {
        if (control instanceof TextBox) {
            var textBox = (TextBox)control;
            textBox.setText("first upcasting happened then downcasting in the above line");
        }
        System.out.println(control);// using the toString method of the TextBox class at runtime
    }
}
