package library.util.PairUtil;

import java.util.Objects;

public class DoubleDoublePair implements Comparable<DoubleDoublePair> {
    public final double first;
    public final double second;

    public static DoubleDoublePair of(double first, double second) {
        return new DoubleDoublePair(first, second);
    }

    private DoubleDoublePair(double first, double second) {
        this.first = first;
        this.second = second;
    }

    public DoubleDoublePair swap() {
        return DoubleDoublePair.of(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    @SuppressWarnings({"unchecked"})
    public int compareTo(DoubleDoublePair o) {
        int value = Double.compare(first, o.first);
        if (value != 0) {
            return value;
        }
        return Double.compare(second, o.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleDoublePair that = (DoubleDoublePair) o;
        return Double.compare(that.first, first) == 0 &&
                Double.compare(that.second, second) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
