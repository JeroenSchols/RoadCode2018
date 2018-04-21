import java.util.*;
import java.io.*;
public class Test {
    public static void main(String[] args) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("test/hello.txt");
        for (int i = 0; i < 1000000; i++) {
            writer.print("hello");
        }
        writer.flush();
    }
}
