package library.util.PairUtil;

import java.util.Objects;

public class DoubleIntPair implements Comparable<DoubleIntPair> {
    public final double first;
    public final int second;

    public static DoubleIntPair of(double first, int second) {
        return new DoubleIntPair(first, second);
    }

    private DoubleIntPair(double first, int second) {
        this.first = first;
        this.second = second;
    }

    public IntDoublePair swap() {
        return IntDoublePair.of(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    @SuppressWarnings({"unchecked"})
    public int compareTo(DoubleIntPair o) {
        int value = Double.compare(first, o.first);
        if (value != 0) {
            return value;
        }
        return Integer.compare(second, o.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleIntPair that = (DoubleIntPair) o;
        return Double.compare(that.first, first) == 0 &&
                second == that.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
