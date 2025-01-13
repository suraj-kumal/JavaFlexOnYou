public class finalandstatic {
    static int counter = 0;
    final int MAX_COUNT = 10;

    finalandstatic() {
        counter++;
    }

    static void displayCounter() {
        System.out.println("Counter value: " + counter);
    }

    final void showMaxCount() {
        System.out.println("Max count is: " + MAX_COUNT);
    }

    public static void main(String[] args) {
        finalandstatic obj1 = new finalandstatic();
        finalandstatic obj2 = new finalandstatic();
        finalandstatic obj3 = new finalandstatic();

        finalandstatic.displayCounter();

        obj1.showMaxCount();

        obj2.counter = 100;

        obj1.displayCounter();
        System.out.println("Name: Suraj Kumal");
        System.out.println("Rollno : 32");
    }
}
