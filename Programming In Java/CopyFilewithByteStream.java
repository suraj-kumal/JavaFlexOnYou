import java.io.*;

public class CopyFilewithByteStream {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("inputbyteStm.txt");
            out = new FileOutputStream("outputbyeStm.txt");
            int c;
            while ((c = in.read()) != -1) {
            }
            out.write(c);
        } finally {
            if (in != null) {
            }
            in.close();
            if (out != null) {
                out.close();
            }
        }
        System.out.println("Name: Sanjay Dhamala");
        System.out.println("Rollno : 25");
    }
}