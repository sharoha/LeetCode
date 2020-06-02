package library.util.PairUtil;

import java.util.Objects;

public class Pair<T1, T2> {

    public static <T1, T2> Pair<T1, T2> create(T1 v1, T2 v2) {
        return new Pair<T1, T2>(v1, v2);
    }

    public T1 v1;
    public T2 v2;

    public Pair(T1 v1, T2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public T1 getV1() {
        return v1;
    }

    public T2 getV2() {
        return v2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(v1, pair.v1) &&
            Objects.equals(v2, pair.v2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2);
    }

    @Override
    public String toString() {
        return "(" + v1 + "," + v2 + ")";
    }
}