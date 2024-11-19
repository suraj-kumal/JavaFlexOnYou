import Inheritance.parent;

public class child extends parent {
    child() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        new child();
    }

}