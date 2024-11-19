interface Interf {
    public void Akatsuki();
}

class InterfaceAk implements Interf {
    @Override
    public void Akatsuki() {
        System.out.println("This is the Akatsuki!");
    }

    public static void main(String[] args) {
        InterfaceAk obj = new InterfaceAk();
        obj.Akatsuki();
    }
}
