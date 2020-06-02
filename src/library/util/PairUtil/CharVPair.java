package library.util.PairUtil;

import java.util.Objects;

public class CharVPair<V> implements Comparable<CharVPair<V>> {
    public final char first;
    public final V second;

    public static <V> CharVPair<V> of(char first, V second) {
        return new CharVPair<V>(first, second);
    }

    private CharVPair(char first, V second) {
        this.first = first;
        this.second = second;
    }

    public KCharPair<V> swap() {
        return KCharPair.of(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    @SuppressWarnings({"unchecked"})
    public int compareTo(CharVPair<V> o) {
        int value = Character.compare(first, o.first);
        if (value != 0) {
            return value;
        }
        return ((Comparable<V>) second).compareTo(o.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharVPair<?> charVPair = (CharVPair<?>) o;
        return first == charVPair.first &&
                Objects.equals(second, charVPair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
