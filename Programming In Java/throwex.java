public class throwex {
    public static void main(String[] args) {
        int age = 22;
        if (age < 18) {
            throw new ArithmeticException("age should be higher");
        } else {
            System.out.println("you are in");
        }

    }

}