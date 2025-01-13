import Inheritance.sound;

public class overriding extends sound {
    @Override
    public void makesound() {
        System.out.println("matsuke");
    }

    public static void main(String[] args) {
        overriding sound = new overriding();
        sound.makesound();
        System.out.println("Name: Suraj Kumal");
        System.out.println("Rollno : 32");
    }
}