package library.util.PairUtil;

import java.util.Objects;

public class DoubleCharPair implements Comparable<DoubleCharPair> {
    public final double first;
    public final char second;

    public static DoubleCharPair of(double first, char second) {
        return new DoubleCharPair(first, second);
    }

    private DoubleCharPair(double first, char second) {
        this.first = first;
        this.second = second;
    }

    public CharDoublePair swap() {
        return CharDoublePair.of(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    @SuppressWarnings({"unchecked"})
    public int compareTo(DoubleCharPair o) {
        int value = Double.compare(first, o.first);
        if (value != 0) {
            return value;
        }
        return Character.compare(second, o.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleCharPair that = (DoubleCharPair) o;
        return Double.compare(that.first, first) == 0 &&
                second == that.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
