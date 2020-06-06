package codes.june_challenge.day6;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

import java.util.*;

public class QueueReconstruction {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.comparing((int[] e) -> e[0]).reversed().thenComparing((int[] e) -> e[1]));
        List<int[]> answer = new ArrayList<>();
        for (int[] person : people) {
            answer.add(person[1], person);
        }
        return answer.toArray(people);
    }
}
