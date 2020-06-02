package library.util.GeoUtil.Shapes;


import library.util.GeoUtil.GeometryUtils;

public class Circle {
    public final Point center;
    public final double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public boolean contains(Point point) {
        return center.distance(point) < radius + GeometryUtils.epsilon;
    }

    public boolean strictContains(Point point) {
        return center.distance(point) < radius - GeometryUtils.epsilon;
    }

    public Point[] findTouchingPoints(Point point) {
        double distance = center.distance(point);
        if (distance < radius - GeometryUtils.epsilon) {
            return new Point[0];
        }
        if (distance < radius + GeometryUtils.epsilon) {
            return new Point[]{point};
        }
        Circle power = new Circle(point, Math.sqrt((distance - radius) * (distance + radius)));
        return intersect(power);
    }

    public Point[] intersect(Circle other) {
        double distance = center.distance(other.center);
        if (distance < GeometryUtils.epsilon) {
            return null;
        }
        Line line = new Line(2 * (other.center.x - center.x), 2 * (other.center.y - center.y), other.radius * other
                .radius - radius * radius + center.x * center.x - other.center.x * other.center.x +
                center.y * center.y - other.center.y * other.center.y);
        return line.intersect(this);
    }

    // finds the center points of the circle which touches p1 and p2
    // and has radius r
    // used : http://mathforum.org/library/drmath/view/53027.html
    // consider the vector from p1 to p2, find the unit normal vector,
    // then stretch it by mirrorDistance(distance from center to the chord (line p1 and p2)
    public static Point[] findCenters(Point p1, Point p2, double r) {
        double diameter = 2.0 * r;
        double distance = p1.distance(p2);
        if (distance > diameter) return new Point[0];
        Point center = new Point((p1.x + p2.x) / 2.0, (p1.y + p2.y) / 2.0);
        if (distance == diameter) return new Point[]{center};
        double mirrorDistance = Math.sqrt(r * r - distance * distance / 4.0);
        double dx = (p2.x - p1.x) * mirrorDistance / distance;
        double dy = (p2.y - p1.y) * mirrorDistance / distance;
        return new Point[] {
                new Point(center.x - dy, center.y + dx),
                new Point(center.x + dy, center.y - dx)
        };
    }

}
