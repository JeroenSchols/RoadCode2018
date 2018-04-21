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
        lastDisplayed = curAd;
        curAd = a;
    }

    boolean inCache(Ad a) {
        return cache.contains(a);
    }

    int addCache(Ad a) {
        int removedId = -1;
        if (cache.size() == cacheLimit) {
            Ad removed = removeFromCache();
            removedId = removed.id;
        }

        cache.add(a);

        return removedId;
    }

    Ad removeFromCache() {
        if (!cache.isEmpty()) {
            Ad r = cache.iterator().next();
            cache.remove(r);
            return r;
        }

        return null;
    }

    void removeFromCache(Ad a) {}
}
