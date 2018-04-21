import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("output/case31huge.txt");

        Input.read(4);
        int T = Input.T;
        ArrayList<Car> cars = Input.cars;
        ArrayList<Ad> ads = Input.ads;
        int C = Input.C;
        int S = Input.S;

        for (Car c : cars) {
            ArrayList<Integer> finalTimes = new ArrayList<>();
            for (Ad a : ads) {
                int res = -1;
                for (int t = 0; t < T; t++) {
                    if (a.isNear(c.locations.get(t))) {
                        res = t;
                    }
                }
                finalTimes.add(res);
            }
            c.setFinalTimes(finalTimes);
        }

        long profit = 0;
        for (int t = 0; t < T; t++) {
            //Collections.shuffle(cars);
            StringBuilder res = new StringBuilder();
            for (Car c : cars) {
                Point l = c.locations.get(t);
                long maxScore = Long.MIN_VALUE;
                Ad bestAd = null;
                for (Ad a : ads) {
                    long score = 0;
                    if (a.isNear(l)) {
                        score += Math.min(a.P, a.B - a.curGain);
                    }
                    if (!c.inCache(a)) {
                        score -= C;
                    }
                    if (c.lastDisplayed != a) {
                        score -= S;
                    }
                    if (score > maxScore) {
                        maxScore = score;
                        bestAd = a;
                    }
                }
                profit += maxScore;
                bestAd.curGain += bestAd.P;
                int out = c.addCache(bestAd);
                res.append(bestAd.id).append(" ").append(out).append(" ");
            }
            writer.println(res);
        }
        writer.flush();
        System.out.println(profit);
    }
}
