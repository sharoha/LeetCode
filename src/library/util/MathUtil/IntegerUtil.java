package library.util.MathUtil;

import java.math.BigInteger;
import java.util.ArrayList;

public class IntegerUtil {
    public static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    /*
     * @param b : We need to calculate the number of prime factors
     * @param prime is the array for storing prime: Use 1e6 for the size of the prime array
     */
    public static long numberOfFactors(long b, int[] prime) {
        long ans = 1;
        for (int p : prime) {
            long count = 0;
            if (b % p == 0) {
                while (b % p == 0) {
                    b /= p;
                    count++;
                }
            }
            ans *= (count + 1);
        }
        if (BigInteger.valueOf(b).isProbablePrime(1)) ans *= 2;
        return ans;
    }

    public static int digitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static int digitSum(long number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static long fib(long n, long mod) {
        if (n == 0) return 0;
        long a = 0, b = 1, c = 1, d = 1, e = n - 2;
        long a1, b1, c1, d1, a2 = 0, b2 = 1, c2 = 1, d2 = 1;

        while (e > 0) {
            if (e % 2 == 1) {
                a1 = (a * a2 + b * c2) % mod;
                c1 = (c * a2 + d * c2) % mod;
                b1 = (a * b2 + b * d2) % mod;
                d1 = (b2 * c + d * d2) % mod;
                a = a1;
                b = b1;
                c = c1;
                d = d1;
            }
            a1 = (a2 * a2 + b2 * c2) % mod;
            c1 = (c2 * a2 + d2 * c2) % mod;
            b1 = (a2 * b2 + b2 * d2) % mod;
            d1 = (b2 * c2 + d2 * d2) % mod;
            a2 = a1;
            b2 = b1;
            c2 = c1;
            d2 = d1;
            e /= 2;
        }
        return d;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static long gcdExtended(long a, long b, long[] x) {
        if (a == 0) {
            x[0] = 0;
            x[1] = 1;
            return b;
        }
        long[] y = new long[2];
        long gcd = gcdExtended(b % a, a, y);
        x[0] = y[1] - (b / a) * y[0];
        x[1] = y[0];
        return gcd;
    }

    public static boolean findSum(int[] set, int n, int sum) {
        boolean[][] par = new boolean[sum + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            par[0][i] = true;
        }
        for (int i = 1; i <= sum; i++) {
            par[i][0] = false;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                par[i][j] = par[i][j - 1];
                if (i >= set[j - 1]) {
                    par[i][j] = par[i][j - 1] || par[i - set[j - 1]][j - 1];
                }
            }
        }
        return par[sum][n];
    }



    //chinese remainder theorem
    public static long CRT(ArrayList<Long> nums, ArrayList<Long> arr) {
        long prodall = 1;
        for (long j : nums)
            prodall *= j;

        long ret = 0;
        for (int i = 0; i < nums.size(); i++) {
            long ni = nums.get(i), ai = arr.get(i);
            ret = (ret + ai * prodall / ni % prodall * inv(prodall / ni % ni, ni)) % prodall;
        }
        return ret;
    }

    public static long inv(long N, long M) {
        long x = 0, lastx = 1, y = 1, lasty = 0, q, t, a = N, b = M;
        while (b != 0) {
            q = a / b;
            t = a % b;
            a = b;
            b = t;
            t = x;
            x = lastx - q * x;
            lastx = t;
            t = y;
            y = lasty - q * y;
            lasty = t;
        }
        return (lastx + M) % M;
    }
    // Div and num in array form : Chinese remainder theorem

    public static long crt(long[] divs, long[] mods) {
        long div = divs[0];
        long mod = mods[0];
        for (int i = 1; i < divs.length; i++) {
            long[] apr = exGCD(div, divs[i]);
            if ((mods[i] - mod) % apr[0] != 0)
                return -1;
            long ndiv = div * divs[i] / apr[0];
            long nmod = (apr[1] * (mods[i] - mod) / apr[0] * div + mod) % ndiv;
            if (nmod < 0)
                nmod += ndiv;
            div = ndiv;
            mod = nmod;
        }
        return mod;
    }

    public static long[] exGCD(long a, long b) {
        if (a == 0 || b == 0)
            return null;
        int as = Long.signum(a);
        int bs = Long.signum(b);
        a = Math.abs(a);
        b = Math.abs(b);
        long p = 1, q = 0, r = 0, s = 1;
        while (b > 0) {
            long c = a / b;
            long d;
            d = a;
            a = b;
            b = d % b;
            d = p;
            p = q;
            q = d - c * q;
            d = r;
            r = s;
            s = d - c * s;
        }
        return new long[]{a, p * as, r * bs};
    }

    public static long[][] getNcr(int max) {
        long[][] ncr = new long[max + 1][max + 1];
        for (int i = 1; i <= max; i++) {
            for (int j = 0; j <= max; j++) {
                if (j == 0 || j == i) ncr[i][j] = 1;
                else ncr[i][j] = ncr[i - 1][j - 1] + ncr[i - 1][j];
            }
        }
        return ncr;
    }

    public static boolean isPrime(long val) {
        return BigInteger.valueOf(val).isProbablePrime(1);
    }
}
