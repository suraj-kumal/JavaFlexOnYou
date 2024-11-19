//class
public class classandobject {
    private String data;
    private int number;

    // constructor
    classandobject(String d, int n) {
        this.data = d;
        this.number = n;
        System.out.println(this.data);
        System.out.println(this.number);

    }

    public static void main(String[] args) {
        // object
        new classandobject("abc", 32);
    }

}