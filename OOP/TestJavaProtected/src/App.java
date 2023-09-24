// Main class in any package
import PackageB.SubClassB;

public class App {
    public static void main(String[] args) {
        SubClassB obj = new SubClassB();
        obj.accessProtectedMembers();
        System.out.println(obj.toString());
    }
}