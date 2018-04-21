import java.util.*;
public class Car {
    int id;
    ArrayList<Point> locations = new ArrayList<>();
    HashSet<Ad> cache = new HashSet<>();
    Ad lastDisplayed = null;
    Car(int id) {
        this.id = id;
    }

    boolean inCache(Ad a) {
        return cache.contains(a);
    }

    int addCache(Ad a) {
        if (cache.contains(a)) {

        }
    }
}
