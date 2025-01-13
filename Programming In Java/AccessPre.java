public class AccessPre {
    public int publicNum = 10;
    private int privateNum = 20;
    protected int protectedNum = 30;
    int packageNum = 40;

    public void publicMethod() {
        System.out.println("This is a public method.");
    }

    private void privateMethod() {
        System.out.println("This is a private method.");
    }

    protected void protectedMethod() {
        System.out.println("This is a protected method.");
    }

    void packagePrivateMethod() {
        System.out.println("This is a package-private method.");
    }

    public static void main(String[] args) {
        AccessPre Sk = new AccessPre();

        System.out.println("Public variable: " + Sk.publicNum);
        Sk.publicMethod();

        System.out.println("Protected variable: " + Sk.protectedNum);
        Sk.protectedMethod();

        System.out.println("Package-private variable: " + Sk.packageNum);
        Sk.packagePrivateMethod();
        System.out.println("Name: Suraj Kumal");
        System.out.println("Rollno : 32");
    }
}
