package library.util.PairUtil;

import java.util.Objects;

public class Triplet<A, B, C> {
    public A st;
    public B nd;
    public C rd;

    public static <A, B, C> Triplet<A, B, C> of(A st, B nd, C rd) {
        return new Triplet<>(st, nd, rd);
    }
    private Triplet(A st, B nd, C rd) {
        this.st = st;
        this.nd = nd;
        this.rd = rd;
    }

    public A getSt() {
        return st;
    }

    public B getNd() {
        return nd;
    }

    public C getRd() {
        return rd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triplet<?, ?, ?> triplet = (Triplet<?, ?, ?>) o;
        return Objects.equals(st, triplet.st) &&
                Objects.equals(nd, triplet.nd) &&
                Objects.equals(rd, triplet.rd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(st, nd, rd);
    }

    @Override
    public String toString() {
        return "(" +
                "st=" + st +
                ", nd=" + nd +
                ", rd=" + rd +
                ')';
    }
}
