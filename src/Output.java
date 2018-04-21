/**import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Output {
  
    long output() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("test/hello.txt"));
        
        ArrayList<Car> cars = Input.cars;
        ArrayList<Ad> ads = Input.ads;
        int S = Input.S;
        int C = Input.C;
        
        long profit = 0;
        
        for (int time = 0; time < Input.T; time++) {
            for (Car car : cars) {
                int nextAd = sc.nextInt();
                int replaceAd = sc.nextInt();
                
                if (car.lastDisplayed == null) {
                    profit -= S;
                    car.lastDisplayed = nextAd;
                }
                
                if (nextAd != car.lastDisplayed) {
                    profit -= S;
                }
                HashSet<Integer> h = new HashSet<>();
                
                if (replaceAd == -1) {
                    if (car.cache.contains(nextAd)) {
                        
                    } else {
                        profit -= C;
                        car.cache.add(nextAd);
                        if (car.cache.size() > Input.M) {
                            throw new IllegalArgumentException("Too many elements in cache");
                        }
                    }
                } else {
                    if (car.cache.contains(replaceAd)) {
                        car.cache.remove(replaceAd);
                        car.cache.add(nextAd);
                        profit -= C;
                    } else {
                        throw new IllegalArgumentException("Tried to remove ad from cache that was not in the cache");
                    }
                }
                
                Ad ad = ads.get(nextAd);
                if (car.locations.get(time).dist2(ad.c) <= ad.R) {
                    
                    profit += Math.min(ad.P, ad.B_Remaining);
                    ad.B_Remaining -= Math.min(ad.P, ad.B_Remaining);
                }
            
            }
          
        }
        return profit;
    }
}
**/