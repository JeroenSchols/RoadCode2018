import java.util.*;
public class Car {
    int id;
    ArrayList<Point> locations = new ArrayList<>();
    HashSet<Ad> cache = new HashSet<>();
    int cacheLimit = Input.M;
    Ad lastDisplayed = null;
    Ad curAd = null;

    Car(int id) {
        this.id = id;
    }

    void setAdd(Ad a) {
        if (!inCache(a)) {
            addCache(a);
        }
        curAd = a;
    }

    boolean inCache(Ad a) {
        return cache.contains(a);
    }

    void addCache(Ad a) {
        if (cache.size() == cacheLimit) {
            removeFromCache();
        }
        cache.add(a);
    }

    void removeFromCache() {
        if (!cache.isEmpty()) {
            cache.remove(cache.iterator().next());
        }
    }

    void removeFromCache(Ad a) {}
}
