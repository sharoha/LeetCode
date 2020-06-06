package codes.june_challenge.day6;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

import java.util.*;

public class QueueReconstruction {
    private static Integer apply(int[] e) {
        return e[0];
    }

    private static Integer apply2(int[] e) {
        return e[1];
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.comparing(QueueReconstruction::apply).reversed().thenComparing(QueueReconstruction::apply2));
        List<int[]> answer = new ArrayList<>();
        for (int[] person : people) {
            answer.add(person[1], person);
        }
        return answer.toArray(people);
    }
}
