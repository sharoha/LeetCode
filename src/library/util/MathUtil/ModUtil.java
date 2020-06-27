package library.util.MathUtil;

public class ModUtil {
    private static final int DEFAULT_MOD = 1_000_000_007;
    private final long mod;

    private ModUtil(long mod, boolean unsafe) {
        if (!unsafe && !IntegerUtil.isPrime(mod)) {
            throw new RuntimeException("This class is designed for primes!");
        }
        this.mod = mod;
    }

    public ModUtil(long mod) {
        this(mod, false);
    }

    public ModUtil() {
        this(DEFAULT_MOD, true);
    }

    public long mod(long x) {
        x %= mod;
        return x < 0 ? x + mod : x;
    }

    public long inv(long x) {
        return modPow(x, mod - 2);
        //return mod(LongEuclidSolver.solve(x, mod).x);
    }

    public long modPow(long base, long exp) {
        long res = 1L;
        while (exp > 0) {
            if (exp % 2 == 1)
                res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    public long mul(long a, long b) {
        a = mod(a);
        b = mod(b);
        return mod(a * b);
    }

    public long add(long a, long b) {
        a = mod(a);
        b = mod(b);
        return mod(a + b);
    }

    public long sub(long a, long b) {
        a = mod(a);
        b = mod(b);
        return mod(a - b);
    }

    /*
   calculates (x^s) % mod
    */
    public long stringExpo(long base, String exp) {
        base %= mod;
        long res = 1 % mod;
        long now = base;
        for (int i = exp.length() - 1; i >= 0; i--) {
            res = (int) ((res * modPow(now, exp.charAt(i) - '0')) % mod);
            now = (int) modPow(now, 10);
        }
        return res;
    }

    public Factorial getFactorial(int n) {
        return new Factorial(this, n);
    }

}
