import Inheritance.parent;

public class child extends parent {
    child() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        new child();
        System.out.println("Name: Suraj Kumal");
        System.out.println("Rollno : 32");
    }

}