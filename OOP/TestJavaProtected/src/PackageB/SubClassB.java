package PackageB;

import packageA.SuperClassA;

public class SubClassB extends SuperClassA {
    public void accessProtectedMembers() {
        System.out.println("Accessing protected members from SubclassB:");
        System.out.println("protectedField: " + protectedField);
        protectedMethod();
    }
}

