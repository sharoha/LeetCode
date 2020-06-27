package codes.contest.biweekly29;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

import java.util.Arrays;

public class A29 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public double average(int[] salary) {
        Arrays.sort(salary);
        int sum = 0;
        int count = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
            count++;
        }
        return (double) sum / (double) count;
    }
}
