//Created by Tgc - Excellent collection usage, well done!

import java.util.TreeSet;

public class FindOdd_Set {
    public static int findIt(int[] A) {
        final TreeSet<Integer> set = new TreeSet<>();
        for (int x : A) {
            if (set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }
        return set.first();
    }
}
