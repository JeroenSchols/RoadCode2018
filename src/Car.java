import java.util.*;
public class Car {
    int id;
    ArrayList<Point> locations = new ArrayList<>();
    TreeSet<Ad> cache = new TreeSet<>();
    CacheEntry[] ads = new CacheEntry[Input.N];
    int cacheLimit = Input.M;
    Ad lastDisplayed = null;
    int time = 0;

    Car(int id) {
        this.id = id;
        this.time = 0;
    }

    boolean inCache(Ad a) {
        return cache.contains(a);
    }

    int addCache(Ad a) {
        lastDisplayed = a;
        int removedId = -1;
        if (cache.size() == cacheLimit && !cache.contains(a)) {
            Ad removed = removeFromCache();
            removedId = removed.id;
        }

        cache.add(a);

        // check if there is already a CacheEntry for the ad a
        if (ads[a.id] != null) {
            ads[a.id].lastUsed = this.time;
        } else {
            ads[a.id] = new CacheEntry(a);
            ads[a.id].lastUsed = this.time;
        }

        // increase relative time
        this.time++;

        return removedId;
    }

    Ad removeFromCache() {
        /*if (!cache.isEmpty()) {
            Ad r = cache.iterator().next();
            cache.remove(r);
            return r;
        }*/
        int lowestTime = Input.T;
        CacheEntry c = null;
        int index = 0;
        for (int i = 0; i < ads.length; i++) {
            if (ads[i] != null && ads[i].lastUsed < lowestTime) {
                lowestTime = ads[i].lastUsed;
                c = ads[i];
                index = i;
            }
        }

        if (c != null) {
            ads[index] = null;
            cache.remove(c);
            return c.ad;
        }

        return null;
    }

    private class CacheEntry {
        Ad ad;
        int lastUsed;

        CacheEntry(Ad a) {
            this.ad = a;
        }
    }
}
