package library.util.PairUtil;

import java.util.Objects;

public class CharDoublePair implements Comparable<CharDoublePair> {
    public final char first;
    public final double second;

    public static CharDoublePair of(char first, double second) {
        return new CharDoublePair(first, second);
    }

    private CharDoublePair(char first, double second) {
        this.first = first;
        this.second = second;
    }


    public DoubleCharPair swap() {
        return DoubleCharPair.of(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    public int compareTo(CharDoublePair o) {
        int value = Character.compare(first, o.first);
        if (value != 0) {
            return value;
        }
        return Double.compare(second, o.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharDoublePair that = (CharDoublePair) o;
        return first == that.first &&
                Double.compare(that.second, second) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
