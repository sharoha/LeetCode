package library.util.PairUtil;

import java.util.Objects;

public class CharIntPair implements Comparable<CharIntPair> {
    public final char first;
    public final int second;

    public static CharIntPair of(char first, int second) {
        return new CharIntPair(first, second);
    }

    private CharIntPair(char first, int second) {
        this.first = first;
        this.second = second;
    }

    public IntCharPair swap() {
        return IntCharPair.of(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    @SuppressWarnings({"unchecked"})
    public int compareTo(CharIntPair o) {
        int value = Character.compare(first, o.first);
        if (value != 0) {
            return value;
        }
        return Integer.compare(second, o.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharIntPair that = (CharIntPair) o;
        return first == that.first &&
                second == that.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
