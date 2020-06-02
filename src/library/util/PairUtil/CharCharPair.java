package library.util.PairUtil;

import java.util.Objects;

public class CharCharPair implements Comparable<CharCharPair> {
    public final char first;
    public final char second;

    public static CharCharPair of(char first, char second) {
        return new CharCharPair(first, second);
    }

    private CharCharPair(char first, char second) {
        this.first = first;
        this.second = second;
    }

    public CharCharPair swap() {
        return CharCharPair.of(second, first);
    }

    public int compareTo(CharCharPair o) {
        int value = Character.compare(first, o.first);
        if (value != 0) {
            return value;
        }
        return Character.compare(second, o.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharCharPair that = (CharCharPair) o;
        return first == that.first &&
                second == that.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

}
