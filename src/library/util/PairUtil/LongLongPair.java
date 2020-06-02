package library.util.PairUtil;

public class LongLongPair implements Comparable<LongLongPair> {
    public final long first;
    public final long second;

    public static LongLongPair of(long first, long second) {
        return new LongLongPair(first, second);
    }

    public LongLongPair(long first, long second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LongLongPair pair = (LongLongPair) o;

        return first == pair.first && second == pair.second;
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(first);
        result = 31 * result + Long.hashCode(second);
        return result;
    }

    public LongLongPair swap() {
        return LongLongPair.of(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    @SuppressWarnings({"unchecked"})
    public int compareTo(LongLongPair o) {
        int value = Long.compare(first, o.first);
        if (value != 0) {
            return value;
        }
        return Long.compare(second, o.second);
    }
}
