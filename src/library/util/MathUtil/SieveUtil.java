package library.util.MathUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class SieveUtil {
    private static final ArrayList<Integer> primes = new ArrayList<>();

    // stores the smallest prime that divides number i
    public static int[][] linearSieveStoresFirstPrime(int N) {
        int[] store = new int[N];
        int[] prime = new int[N];
        int k = 0;
        Arrays.fill(store, 0);
        store[1] = 1;
        for (int i = 2; i < N; i++) {
            if (store[i] == 0) {
                prime[k++] = i;
                store[i] = i;
            }
            for (int j = 0; j < k && i * prime[j] < N && prime[j] <= store[i]; j++) {
                store[i * prime[j]] = prime[j];
                if (i % prime[j] == 0) break;
            }
        }
        prime = Arrays.copyOf(prime, k);
        return new int[][]{prime, store};
    }

    public static int[][] mobius(int N) {
        boolean[] composite = new boolean[N];
        int[] prime = new int[N];
        int[] mobius = new int[N];
        mobius[1] = 1;
        int k = 0;
        Arrays.fill(composite, false);
        for (int i = 2; i < N; i++) {
            if (!composite[i]) {
                prime[k++] = i;
                primes.add(i);
                mobius[i] = 1;
            }
            for (int j = 0; j < k && i * prime[j] < N; j++) {
                composite[i * prime[j]] = true;
                if (i % prime[j] == 0) {
                    mobius[i * prime[j]] = 0;
                    break;
                } else {
                    mobius[i * prime[j]] = mobius[i] * mobius[prime[j]];
                }
            }
        }
        return new int[][]{prime, mobius};
    }

    /**
     *
     * @param N Upper bound of array
     * @return int[] array which contains primes <= N
     */
    public static int[] linearSieve(int N) {
        boolean[] composite = new boolean[N];
        Arrays.fill(composite, false);
        composite[0] = composite[1] = true;
        for (int i = 2; i < N; i++) {
            if (!composite[i]) primes.add(i);
            for (int j = 0; j < primes.size() && i * primes.get(j) < N; j++) {
                composite[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) break;
            }
        }
        int[] prime = new int[N];
        int j = 0;
        for (int i = 0; i < N; i++) {
            if (!composite[i]) prime[j++] = i;
        }
        prime = Arrays.copyOf(prime, j);
        return prime;
    }

    public static int[] totientFunction(int N) {
        boolean[] composite = new boolean[N];
        int[] totient = new int[N];
        Arrays.fill(composite, false);
        for (int i = 2; i < N; i++) {
            if (!composite[i]) {
                primes.add(i);
                totient[i] = i - 1;
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < N; j++) {
                composite[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) {
                    totient[i * primes.get(j)] = totient[i] * primes.get(j);
                    break;
                } else {
                    totient[i * primes.get(j)] = totient[i] * totient[primes.get(j)];
                }
            }
        }
        return totient;
    }
}
