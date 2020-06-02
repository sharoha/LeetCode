package library.util.PairUtil;

import java.util.Objects;

public class DoubleLongPair implements Comparable<DoubleLongPair> {
    public final double first;
    public final long second;

    public static DoubleLongPair of(double first, long second) {
        return new DoubleLongPair(first, second);
    }

    private DoubleLongPair(double first, long second) {
        this.first = first;
        this.second = second;
    }

    public LongDoublePair swap() {
        return LongDoublePair.of(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    @SuppressWarnings({"unchecked"})
    public int compareTo(DoubleLongPair o) {
        int value = Double.compare(first, o.first);
        if (value != 0) {
            return value;
        }
        return Long.compare(second, o.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleLongPair that = (DoubleLongPair) o;
        return Double.compare(that.first, first) == 0 &&
                second == that.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
