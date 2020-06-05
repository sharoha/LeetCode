package codes.june_challenge.day5;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

import java.util.Random;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class RandomPickWithWeight {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    /**
     * Asks to pick a index based on the weight of the index
     * For example if
     * w[] = {1, 3, 2, 5}
     * then the 4th element has the highest change of getting picked
     * and then 2nd element has the second highest chance and so on
     * one solution would be to flatten out the index w[i] times, So the given example will become
     * arr[] = { 0 1 1 1 2 2 3 3 3 3 3 }
     * Now select a index at random from 0(inclusive) to arr.length(exclusive) and return the value.
     * But we wont be able to allocate the memory for arr if the input is huge.
     *
     * So, Consider a TreeMap, with its key to cumulative sum, and value as the index.
     * Then select a random number from 0 to arr.length,(say this value is R)
     * Now in the TreeMap we find the minimum key which is higher than R. and return the index.
     * (Todo : think about why we need to take higherKey(>) and not ceilingKey(>=)
     */
    static class Solution {
        private final TreeMap<Integer, Integer> tSet;
        private int sum;
        private final Random r;
        public Solution(int[] w) {
            tSet = new TreeMap<>();
            sum = 0;
            IntStream.range(0, w.length).forEach(e -> {
                sum += w[e];
                tSet.put(sum, e);
            });
            r = new Random(10000);
        }

        public int pickIndex() {
            return tSet.get(tSet.higherKey(r.nextInt(sum)));
        }
    }
}
