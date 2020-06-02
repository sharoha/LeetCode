package library.util.GeoUtil.Shapes;

public class Rectangle {
    private final Point bottom;
    private final Point top;

    public static Rectangle of(int x, int y, int m, int n) {
        Point l = Point.of(x, y);
        Point r = Point.of(m, n);
        return Rectangle.of(l, r);
    }
    public static Rectangle of(Point bottom, Point top) {
        return new Rectangle(bottom, top);
    }

    private Rectangle(Point bottom, Point top) {
        this.bottom = bottom;
        this.top = top;
    }

    public static long area(Rectangle rec) {
        if (rec == null) return 0;
        return (long) Math.abs(rec.top.x - rec.bottom.x) * (long) Math.abs(rec.top.y - rec.bottom.y);
    }

    public static Rectangle intersection(Rectangle f, Rectangle s) {
        if (f == null || s == null) return null;
        if (!ifOverlap(f, s)) return null;
        Point l = Point.of(Math.max(f.bottom.x, s.bottom.x), Math.max(f.bottom.y, s.bottom.y));
        Point r = Point.of(Math.min(f.top.x, s.top.x), Math.min(f.top.y, s.top.y));
        return Rectangle.of(l, r);
    }

    public static boolean ifOverlap(Rectangle f, Rectangle s) {
        if (f.bottom.x > s.top.x || s.bottom.x > f.top.x) return false;
        return f.bottom.y <= s.top.y && s.bottom.y <= f.top.y;
    }
}
