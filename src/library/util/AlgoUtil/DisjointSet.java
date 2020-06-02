package library.util.AlgoUtil;

public class DisjointSet {
    public static int root(int[] array, int x) {
        return array[x] < 0 ? x : (array[x] = root(array, array[x]));
    }

    public static boolean equal(int[] array, int x, int y) {
        return root(array, x) == root(array, y);
    }

    public static boolean union(int[] array, int x, int y) {
        x = root(array, x);
        y = root(array, y);
        if (x != y) {
            if (array[y] < array[x]) {
                int d = x;
                x = y;
                y = d;
            }
            array[x] += array[y];
            array[y] = x;
        }
        return x == y;
    }
}
