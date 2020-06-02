package library.util.GeoUtil.Shapes;

import codes.fastio_java.InputReader;
import library.util.GeoUtil.GeometryUtils;

import java.util.Objects;

public class Point {
    public static final Point ORIGIN = new Point(0, 0);
    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(double x, double y) {
        return new Point(x, y);
    }

    public Point(int[] point) {
        this.x = point[0];
        this.y = point[1];
    }

    public Line line(Point other) {
        if (equals(other)) {
            return null;
        }
        double a = other.y - y;
        double b = x - other.x;
        double c = -a * x - b * y;
        return new Line(a, b, c);
    }

    public double distance(Point other) {
        return GeometryUtils.fastHypot(x - other.x, y - other.y);
    }

    public double distance(Line line) {
        return Math.abs(line.a * x + line.b * y + line.c);
    }

    public double value() {
        return GeometryUtils.fastHypot(x, y);
    }

    public double angle() {
        return Math.atan2(y, x);
    }

    public static Point readPoint(InputReader in) {
        double x = in.d();
        double y = in.d();
        return new Point(x, y);
    }

    public Point rotate(double angle, Point center) {
        double dx = x - center.x;
        double dy = y - center.y;
        double nx = dx * Math.cos(angle) - dy * Math.sin(angle);
        double ny = dy * Math.cos(angle) + dx * Math.sin(angle);
        return new Point(center.x + nx, center.y + ny);
    }

    public Point rotate(double angle) {
        double nx = x * Math.cos(angle) - y * Math.sin(angle);
        double ny = y * Math.cos(angle) + x * Math.sin(angle);
        return new Point(nx, ny);
    }

    public Point apply(Vector vector) {
        return apply(vector, 1);
    }

    public Point apply(Vector vector, double ratio) {
        return new Point(x + vector.x * ratio, y + vector.y * ratio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
