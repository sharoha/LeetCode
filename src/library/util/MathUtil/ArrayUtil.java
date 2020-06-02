package library.util.MathUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ArrayUtil {
    public static int[] rotate(int[] a, int time) {
        int[] n = Arrays.copyOf(a, a.length);
        int ind = 0;
        for (int i = 0; i < a.length; i++) {
            n[ind++] = a[(i + time) % a.length];
        }
        return n;
    }

    public static long[] rotate(long[] a, int time) {
        long[] n = Arrays.copyOf(a, a.length);
        int ind = 0;
        for (int i = 0; i < a.length; i++) {
            n[ind++] = a[(i + time) % a.length];
        }
        return n;
    }

    public static void shuffleFisherYates(int[] a) {
        int n = a.length;
        Random r = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            ArrayUtil.swap(a, i, j);
        }
    }

    public static void reverse(int[] a) {
        reverse(a, 0, a.length - 1);
    }

    public static void reverse(int[] a, int l, int r) {
        while (l < r) {
            int temp = a[l];
            a[l++] = a[r];
            a[r--] = temp;
        }
    }

    public static void reverse(long[] a) {
        reverse(a, 0, a.length - 1);
    }

    public static void reverse(long[] a, int l, int r) {
        while (l < r) {
            long temp = a[l];
            a[l++] = a[r];
            a[r--] = temp;
        }
    }

    public static void swap(long[] a, int i, int j) {
        long temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void shuffleFisherYates(long[] a) {
        int n = a.length;
        Random r = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            ArrayUtil.swap(a, i, j);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static HashMap<Integer, Integer> countFrequencyOfEveryElement(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int t : a) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        return map;
    }

    public static HashMap<Long, Integer> countFrequencyOfEveryElement(long[] a) {
        HashMap<Long, Integer> map = new HashMap<>();
        for (long t : a) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        return map;
    }

    public static int lowerBound(int[] a, int key) {
        int l = 0;
        int h = a.length;
        while (l < h) {
            int mid = (l + h) >> 1;
            if (key <= a[mid]) h = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static int upperBound(int[] a, int key) {
        int l = 0;
        int h = a.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (a[mid] > key) h = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    public static int lowerBound(long[] a, long key) {
        int l = 0;
        int h = a.length;
        while (l < h) {
            int mid = (l + h) >> 1;
            if (key <= a[mid]) h = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static int upperBound(long[] a, long key) {
        int l = 0;
        int h = a.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (a[mid] > key) h = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    public static <T extends Comparable<T>> int lowerBound(List<T> a, T key) {
        int l = 0;
        int h = a.size();
        while (l < h) {
            int mid = (l + h) >> 1;
            if (key.compareTo(a.get(mid)) <= 0) h = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static <T extends Comparable<T>> int upperBound(List<T> a, T key) {
        int l = 0;
        int h = a.size();
        while (l < h) {
            int mid = (l + h) >> 1;
            if (key.compareTo(a.get(mid)) >= 0) l = mid + 1;
            else h = mid;
        }
        return l;
    }

    public static int[] compressArray(int[] array) {
        int[] temp = array.clone();
        Arrays.sort(temp);
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(temp[i])) map.put(temp[i],count++);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = map.get(array[i]);
        }
        return array;
    }

    public static long[] compressArray(long[] array) {
        long[] temp = array.clone();
        Arrays.sort(temp);
        HashMap<Long, Long> map = new HashMap<>();
        long count = 0;
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(temp[i])) map.put(temp[i],count++);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = map.get(array[i]);
        }
        return array;
    }

    public static int min(int[] a) {
        return IntStream.of(a).min().orElse(-Cons.inf);
    }

    public static long min(long[] a) {
        return LongStream.of(a).min().orElse(-Cons.INF);
    }

    public static int max(int[] a) {
        return IntStream.of(a).max().orElse(Cons.inf);
    }

    public static long max(long[] a) {
        return LongStream.of(a).max().orElse(Cons.INF);
    }

    public static int sum(int[] a) {
        return Arrays.stream(a).sum();
    }

    public static long sum(long[] a) {
        return Arrays.stream(a).sum();
    }
}
