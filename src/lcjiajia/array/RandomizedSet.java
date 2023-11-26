package lcjiajia.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomizedSet {
    Set<Integer> set;
    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        List<Integer> list = set.stream().toList();
        return list.get((int) (Math.random()*list.size()));
    }
}
