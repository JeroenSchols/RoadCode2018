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

    public static ArrayList<Ad> ads = new ArrayList<>();
    public static ArrayList<Car> cars = new ArrayList<>();

    public static void read(int f) throws FileNotFoundException {
        String[] filenames = {"sample-tiny.1.in", "sample-small.1.in", "sample-medium.1.in", "sample-large.1.in", "sample-huge.1.in"};

        f = f % filenames.length;

        Scanner sc = new Scanner(new FileReader("input\\" + filenames[f]));

        N = sc.nextInt();
        V = sc.nextInt();
        T = sc.nextInt();
        M = sc.nextInt();
        C = sc.nextInt();
        S = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int P = sc.nextInt();
            int B = sc.nextInt();
            int R = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point point = new Point(x, y);
            ads.add(new Ad(i, P, B, R, x, y));
        }


        for (int i = 0; i < V; i++) {
            cars.add(new Car(i));
        }

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < V; j++) {
                Point point = new Point(sc.nextInt(), sc.nextInt());
                cars.get(j).locations.add(point);
            }
        }
    }
}
