package library.util.MathUtil;

public class Factorial {
    private final ModUtil mod;
    private final long[] natural;
    private final long[] reverse;

    public Factorial(ModUtil mod, int max) {
        this.mod = mod;
        this.natural = new long[max];
        this.reverse = new long[max];
        natural[0] = 1;
        for (int i = 1; i < max; i++) {
            natural[i] = mod.mod(natural[i - 1] * i);
        }
        reverse[max - 1] = mod.inv(natural[max - 1]);
        for (int i = max - 1; i > 0; i--) {
            reverse[i - 1] = mod.mod(reverse[i] * i);
        }
    }

    public long fact(int x) {
        return natural[x];
    }

    public long ncr(int n, int r) {
        return mod.mod(natural[n] * mod.mod(reverse[r] * reverse[n - r]));
    }
}
