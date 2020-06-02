package library.util.PairUtil;

import java.util.Objects;

public class CharLongPair implements Comparable<CharLongPair> {
    public final char first;
    public final long second;

    public static CharLongPair of(char first, long second) {
        return new CharLongPair(first, second);
    }

    private CharLongPair(char first, long second) {
        this.first = first;
        this.second = second;
    }

    public LongCharPair swap() {
        return LongCharPair.of(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    @SuppressWarnings({"unchecked"})
    public int compareTo(CharLongPair o) {
        int value = Character.compare(first, o.first);
        if (value != 0) {
            return value;
        }
        return Long.compare(second, o.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharLongPair that = (CharLongPair) o;
        return first == that.first &&
                second == that.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
