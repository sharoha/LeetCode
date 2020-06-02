package library.util.AlgoUtil;

public class Kadane {
    public static long kadane(int[] aux, int n) {
        long max_current = aux[0];
        long max_global = max_current;
        for (int i = 1; i < aux.length; i++) {
            max_current = Math.max(aux[i], max_current + aux[i]);
            if (max_current > max_global)
                max_global = max_current;
        }
        return max_global;
    }
}
