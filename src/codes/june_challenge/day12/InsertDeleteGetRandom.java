package codes.june_challenge.day12;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

import java.util.*;

public class InsertDeleteGetRandom {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    static class RandomizedSet {
        private final Map<Integer, Integer> map;
        private final List<Integer> list;
        private final Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random(10000);
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) { // already exist
                return false;
            }
            int s = list.size();
            list.add(val);
            map.put(val, s);
            return true;
        }

        public boolean remove(int val) {
            if (map.get(val) == null) {
                return false;
            }
            int index = map.get(val);
            int lastElement = list.get(list.size() - 1);
            Collections.swap(list, index, list.size() - 1);
            map.put(lastElement, index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            int rand = random.nextInt(list.size());
            return list.get(rand);
        }
    }
}
