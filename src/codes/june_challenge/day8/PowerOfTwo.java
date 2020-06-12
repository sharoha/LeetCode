package codes.june_challenge.day8;
import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

public class PowerOfTwo {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
