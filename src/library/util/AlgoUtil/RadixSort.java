package library.util.AlgoUtil;
// credit to @uwi
public class RadixSort {
    public static long[] radixSort(long[] f) {
        return radixSort(f, f.length);
    }

    public static long[] radixSort(long[] f, int n) {
        long[] to = new long[n];
        {
            int[] b = new int[65537];
            for (int i = 0; i < n; i++) b[1 + (int) (f[i] & 0xffff)]++;
            for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
            for (int i = 0; i < n; i++) to[b[(int) (f[i] & 0xffff)]++] = f[i];
            long[] d = f;
            f = to;
            to = d;
        }
        {
            int[] b = new int[65537];
            for (int i = 0; i < n; i++) b[1 + (int) (f[i] >>> 16 & 0xffff)]++;
            for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
            for (int i = 0; i < n; i++) to[b[(int) (f[i] >>> 16 & 0xffff)]++] = f[i];
            long[] d = f;
            f = to;
            to = d;
        }
        {
            int[] b = new int[65537];
            for (int i = 0; i < n; i++) b[1 + (int) (f[i] >>> 32 & 0xffff)]++;
            for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
            for (int i = 0; i < n; i++) to[b[(int) (f[i] >>> 32 & 0xffff)]++] = f[i];
            long[] d = f;
            f = to;
            to = d;
        }
        {
            int[] b = new int[65537];
            for (int i = 0; i < n; i++) b[1 + (int) (f[i] >>> 48 & 0xffff)]++;
            for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
            for (int i = 0; i < n; i++) to[b[(int) (f[i] >>> 48 & 0xffff)]++] = f[i];
            long[] d = f;
            f = to;
            to = d;
        }
        return f;
    }

    public static int[] radixSort(int[] f) {
        return radixSort(f, f.length);
    }

    public static int[] radixSort(int[] f, int n) {
        // credits uwi
        int[] to = new int[n];
        {
            int[] b = new int[65537];
            for (int i = 0; i < n; i++) b[1 + (int) (f[i] & 0xffff)]++;
            for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
            for (int i = 0; i < n; i++) to[b[(int) (f[i] & 0xffff)]++] = f[i];
            int[] d = f;
            f = to;
            to = d;
        }
        {
            int[] b = new int[65537];
            for (int i = 0; i < n; i++) b[1 + (int) (f[i] >>> 16 & 0xffff)]++;
            for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
            for (int i = 0; i < n; i++) to[b[(int) (f[i] >>> 16 & 0xffff)]++] = f[i];
            int[] d = f;
            f = to;
            to = d;
        }
        return f;
    }
}
