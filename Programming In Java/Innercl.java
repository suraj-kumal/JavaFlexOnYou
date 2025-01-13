public class Innercl {
    public class inne {
        void data() {
            System.out.println("ok");
        }
    }

    public static void main(String[] args) {
        Innercl o = new Innercl();
        Innercl.inne ok = o.new inne();
        ok.data();
        System.out.println("Name: Suraj Kumal");
        System.out.println("Rollno : 32");
    }
}