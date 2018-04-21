import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileReader;

public class Input {
    public static int N;
    public static int V;
    public static int T;
    public static int M;
    public static int C;
    public static int S;

    public static ArrayList<Ad> ads;
    public static ArrayList<Car> cars;

    public static void read(int f) throws FileNotFoundException {
        String[] filenames = {"sample-tiny.1.in", "sample-small.1.in", "sample-medium.1.in", "sample-large.1.in", "sample-huge.1.in"};

        f = f % filenames.length;

        Scanner sc = new Scanner(new FileReader("input\\" + filenames[f]));

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {

        }
    }
}
