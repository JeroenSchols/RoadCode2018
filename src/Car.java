import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;

import java.util.*;
public class Car {
    int id;
    ArrayList<Point> locations = new ArrayList<>();
    TreeSet<CacheEntry> cache = new TreeSet<>();
    CacheEntry[] ads = new CacheEntry[Input.N];
    int cacheLimit = Input.M;
    Ad lastDisplayed = null;
    int time = 0;

    Car(int id) {
        this.id = id;
        this.time = 0;
        for (int i = 0; i < ads.length; i++) {
            ads[i] = new CacheEntry(Input.ads.get(i));
        }
    }

    boolean inCache(Ad a) {
        return ads[a.id].inCache;
    }

    void setFinalTimes(ArrayList<Integer> finalTimes) {
        for (int i = 0; i < Input.N; i++) {
            ads[i].finalTime = finalTimes.get(i);
        }
    }
    
    int addCache(Ad a) {
        lastDisplayed = a;
        int removedId = -1;
        if (cache.size() == cacheLimit && !inCache(a)) {
            Ad removed = removeFromCache();
            removedId = removed.id;
        }

        cache.add(ads[a.id]);
        ads[a.id].inCache = true;

        cache.remove(ads[a.id]);
        
        if (time >= ads[a.id].finalTime) {
            ads[a.id].lastUsed = -1;
        } else {
            ads[a.id].lastUsed = this.time;
        }    
        cache.add(ads[a.id]);

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
        if (!cache.isEmpty()) {
            CacheEntry toBeRemoved = cache.first();
            toBeRemoved.inCache = false;
            cache.remove(toBeRemoved);
            return toBeRemoved.ad;
        }

        return null;
    }

    private class CacheEntry implements Comparable<CacheEntry> {
        Ad ad;
        int lastUsed;
        int finalTime;
        boolean inCache = false;

        CacheEntry(Ad a) {
            this.ad = a;
        }

        @Override
        public int compareTo(CacheEntry cacheEntry) {
            return Integer.compare(this.lastUsed, cacheEntry.lastUsed);
        }
    }
}
