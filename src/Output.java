import java.io.*;
import java.util.Scanner;

public class Output {
  
    Output() {
        Scanner sc;
        try {
            sc = new Scanner(new File("test/hello.txt"));
        } catch (Exception e) {
            System.out.println(e.getClass().toString());
            return;
        }
        
        for (Car car : cars) {
            car.cache = new ArrayList<>();
        }
        
        for (int time = 0; time < T; time++) {
            for (int carNumber = 0; carNumber < V; carNumber++) {
                int nextAd = sc.nextInt();
                int replaceAd = sc.nextInt();
                
                if (car.get)
                
                
            }
            
        }
    }
}
