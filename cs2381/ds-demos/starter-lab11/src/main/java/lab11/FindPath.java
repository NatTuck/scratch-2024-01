package lab11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class FindPath {
    static List<String> findPath(RoadMap mm,
                                 String src,
                                 String dst) {
        var infos = new TreeMap<String, CityInfo>();
        var queue = new MinHeap<CityInfo>((aa, bb) -> compare(aa, bb));

        var srcInfo = new CityInfo(src, null, 0.0);
        infos.put(src, srcInfo);

        return findPath(mm, infos, queue, src, src, dst);
    }

    static List<String> findPath(RoadMap mm,
                                 TreeMap<String, CityInfo> infos,
                                 MinHeap<CityInfo> queue,
                                 String src,
                                 String cur,
                                 String dst) {
        // Probably not this.
        var ys = new ArrayList<String>();
        for (var name : mm.listCities()) {
            ys.add(name);
        }
        return ys;

        // If we've reached the destination (cur.equals(dst))
        // then use buildPath to get the list of
        // city names to return.

        // For each neighbor of the current city:
        //  - Calculate the distance through the current city to
        //    the neighbor (cur srcDist + dist(cur, neib)).
        //  - If this is better than the best distance we've found so
        //    far (or we haven't gotten here previously).
        //     - Update the distance in infos to the better one.
        //     - Update the prev in infos to the current city.
        //     - Add the neighbor to the queue
        // Mark current city as done.

        // Pull a non-done city out of the queue and recurse
        // with that city as cur.
        //
        // If the queue is empty there's no path - throw an exception.
    }

    static List<String> buildPath(TreeMap<String, CityInfo> infos,
                                  String dst,
                                  String src) {
        var ys = new ArrayList<String>();

        while (!dst.equals(src)) {
            ys.add(dst);
            var di = infos.get(dst);
            dst = di.prev;
        }

        ys.add(src);
        
        Collections.reverse(ys);
        return ys;
    }

    static public int compare(CityInfo aa, CityInfo bb) {
        var ad = Double.valueOf(aa.srcDist);
        var bd = Double.valueOf(bb.srcDist);
        return ad.compareTo(bd);
    }
}

class CityInfo {
    String name;
    String prev;
    double srcDist;
    boolean done;

    CityInfo(String name, String prev, double srcDist) {
        this.name = name;
        this.prev = prev;
        this.srcDist = srcDist;
        this.done = false;
    }
}
