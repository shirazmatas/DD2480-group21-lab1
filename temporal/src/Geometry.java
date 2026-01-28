public final class Geometry {

    private Geometry() {}

    /** Calculates the distance between two paints and return their distance
     *
     * @param a the first point
     * @param b the second point
     * @return double distance
     */
    public static double distance(Point a, Point b) {
       return Math.sqrt(Math.pow(a.x() - b.x(), 2) + Math.pow(a.y() - b.y(), 2));
    }

    /** Calculate the angle created from the two line a -> b, b->c where b is the midpoint.
     * angle = atan2(vector2.y, vector2.x) - atan2(vector1.y, vector1.x)
     * @param a the first point
     * @param b the middle point
     * @param c the last point.
     * @return double angle
     */
    public static double angle(Point a, Point b, Point c) {
        return Math.atan2(a.y()- b.y(), a.x() - b.x()) - Math.atan2(c.y() - b.y(), c.x() - b.x());
    }

    /**
     * Determines whether three points can be contained within or on a
     * circle of the given radius.
     *
     * @param a the first point
     * @param b the second point
     * @param c the third point
     * @param r the radius of the enclosing circle
     * @return {@code true} if there exists a circle with the radius
     * that contains all points
     */
    public static boolean circleContains(Point a, Point b, Point c, double r) {
        if (midpointCircleContains(a, b, c, r)) return true;
        if (midpointCircleContains(b, a, c, r)) return true;
        if (midpointCircleContains(c, a, b, r)) return true;
        return circumcircleContains(a, b, c, r);
    }

    /**
     * Determines whether the points are contained in a circle with the given radius
     * and a center that is the midpoint of a and b.
     */
    private static boolean midpointCircleContains(Point p, Point a, Point b, double r) {
        Point m = new Point((a.x() + b.x()) / 2.0, (a.y() + b.y()) / 2.0);
        return distance(a, b) <= 2 * r && distance(m, p) <= r;
    }

    /**
     * Determines whether the circumcircle of the points has a radius less than
     * or equal to the given radius.
     */
    private static boolean circumcircleContains(Point a, Point b, Point c, double r) {
        double area = triangleArea(a, b, c);
        if (area == 0.0) return false;
        return distance(a, b) * distance(b, c) * distance(c, a) <= 4.0 * area * r;
    }

    /**
     * Determines whether two values are approximately equal within a given error.
     */
    public static boolean approximatelyEquals(double a, double b, double epsilon) {
        return Math.abs(a - b) <= epsilon;
    }

    public static double triangleArea(Point a, Point b, Point c) {
        double x1 = a.x();
        double y1 = a.y();
        double x2 = b.x();
        double y2 = b.y();
        double x3 = c.x();
        double y3 = c.y();

        double shoelace = Math.abs(x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2));
        return 0.5*shoelace;
    }

    public static double distanceToLine(Point p, Point a, Point b) {
        double numerator = Math.abs( ((b.x() - a.x())*(p.y()-a.y())) - (b.y()-a.y())*(p.x()-a.x()) );
        double denominator = Math.sqrt(((b.x() - a.x())*(b.x() - a.x())) + ((b.y()-a.y())*(b.y()-a.y())));
        return numerator/denominator;
    }

}

