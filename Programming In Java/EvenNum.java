public class EvenNum extends Thread {
    static final Object lock = new Object();
    private boolean isSynchronized;

    public EvenNum(boolean isSynchronized) {
        this.isSynchronized = isSynchronized;
    }

    @Override
    public void run() {
        if (isSynchronized) {
            printEvenNumbersWithSynchronization();
        } else {
            printEvenNumbersWithoutSynchronization();
        }
    }

    private void printEvenNumbersWithoutSynchronization() {
        for (int i = 2; i <= 50; i += 2) {
            System.out.println("Even (No Sync): " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    private void printEvenNumbersWithSynchronization() {
        synchronized (lock) {
            for (int i = 2; i <= 50; i += 2) {
                System.out.println("Even (With Sync): " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        EvenNum thread1 = new EvenNum(false);
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        EvenNum thread2 = new EvenNum(true);
        thread2.start();
        System.out.println("Name: Suraj Kumal");
        System.out.println("Rollno : 32");
    }
}
