import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("out/hello.txt");

        Input.read();
        int T = Input.T;
        ArrayList<Car> cars = Input.cars;
        for (int t = 0; t < T; t++) {
            for (Car c : cars) {
                Point l = c.locations.get(t);
                int y = c.locatons
            }
        }
        writer.flush();
    }
}
