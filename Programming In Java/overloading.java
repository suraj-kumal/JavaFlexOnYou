public class overloading {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        overloading ADD = new overloading();

        System.out.println("sum of 2 integers :" + ADD.add(8, 7));
        System.out.println("sum of 3 integers :" + ADD.add(8, 7, 7));
        System.out.println("sum of 2 doubles :" + ADD.add(8.7, 7.3));
        System.out.println("Name: Suraj Kumal");
        System.out.println("Rollno : 32");

    }
}
