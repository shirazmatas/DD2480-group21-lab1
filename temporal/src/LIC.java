import java.util.Arrays;

public final class LIC {

    private LIC() {}

    /*
    Predicates
     */

    @FunctionalInterface
    private interface PairPredicate {
        boolean test(Point a, Point b);
    }

    @FunctionalInterface
    private interface TriplePredicate {
        boolean test(Point a, Point b, Point c);
    }

    @FunctionalInterface
    private interface NPredicate {
        boolean test(Point[] points);
    }

    /*
    LICs
     */

    public static boolean lic0(Point[] points, Parameters parameters) {
        PairPredicate distanceIsGreaterThanLength1 = (a, b) -> {
            // Calculate distance using distance formula
            double distance = Math.sqrt(Math.pow(a.x() - b.x(), 2) +Math.pow(a.y()-b.y(), 2));
            // should use
            // Check if bigger than length1
            return distance > parameters.length1();
        };
        return anyConsecutivePair(points, distanceIsGreaterThanLength1);
    }

    public static boolean lic1(Point[] points, Parameters parameters) {
        TriplePredicate consectiveThreeNotInCircle = (a,b,c ) -> {
            Point[] abc = new Point[]{a, b, c};
            return ! Geometry.containedInCircle(abc, parameters.radius1());
        };
        return anyConsecutiveTriple(points,consectiveThreeNotInCircle);
    }

    public static boolean lic2(Point[] points, Parameters parameters) {
        TriplePredicate angleSmallerOrBiggerPiEpsilon = (a, b, c) -> {
            double angle = Geometry.angle(a,b,c);
            return angle < (Math.PI - parameters.epsilon()) || angle > (Math.PI + parameters.epsilon());
        };
        // Note The second of the three consecutive points is always the vertex of the angle. If either the first
        //point or the last point (or both) coincides with the vertex, the angle is undefined and the LIC
        //is not satisfied by those three points.
        return anyConsecutiveTriple(points, angleSmallerOrBiggerPiEpsilon);
    }

    public static boolean lic3(Point[] points, Parameters parameters) {
        TriplePredicate triangleAreaGreaterThanArea1 = (a, b, c) -> Geometry.triangleArea(a,b,c) > parameters.area1();
        return anyConsecutiveTriple(points, triangleAreaGreaterThanArea1);
    }

    public static boolean lic4(Point[] points, Parameters parameters) {
        NPredicate oneSetOfQPointsInMoreThanQuadsQuadrants = (points1) ->{

        }
        return anyConsecutiveN(points, )
    }

    public static boolean lic5(Point[] points, Parameters parameters) {
        throw new UnsupportedOperationException();
    }

    public static boolean lic6(Point[] points, Parameters parameters) {
        throw new UnsupportedOperationException();
    }

    public static boolean lic7(Point[] points, Parameters parameters) {
        throw new UnsupportedOperationException();
    }

    public static boolean lic8(Point[] points, Parameters parameters) {
        throw new UnsupportedOperationException();
    }

    public static boolean lic9(Point[] points, Parameters parameters) {
        throw new UnsupportedOperationException();
    }

    public static boolean lic10(Point[] points, Parameters parameters) {
        throw new UnsupportedOperationException();
    }

    public static boolean lic11(Point[] points, Parameters parameters) {
        throw new UnsupportedOperationException();
    }

    public static boolean lic12(Point[] points, Parameters parameters) {
        throw new UnsupportedOperationException();
    }

    public static boolean lic13(Point[] points, Parameters parameters) {
        throw new UnsupportedOperationException();
    }

    public static boolean lic14(Point[] points, Parameters parameters) {
        throw new UnsupportedOperationException();
    }

    /*
    Iteration helpers
     */


    /**
     * Tests whether there exists at least one sequence of points with the given pattern
     * of intervening points for which the supplied predicate evaluates to true. For example,
     * a gaps array of {A, B} selects triples of points with exactly A points between the first
     * and second, and B points between the second and third.
     */
    private static boolean anySeparatedN(Point[] points, int[] gaps, NPredicate predicate) {
        int n = gaps.length + 1;
        int width = n + Arrays.stream(gaps).sum();

        for (int start = 0; start <= points.length - width; start++) {
            Point[] group = new Point[n];

            int index = start;
            group[0] = points[index];

            for (int i = 1; i < n; i++) {
                index += 1 + gaps[i - 1];
                group[i] = points[index];
            }

            if (predicate.test(group))
                return true;
        }

        return false;
    }

    /**
     * Tests whether there exists at least one triple of points separated by the given gaps
     * for which the supplied predicate evaluates to true.
     */
    private static boolean anySeparatedTriple(Point[] points, int gap1, int gap2,  TriplePredicate predicate) {
        return anySeparatedN(points, new int[] {gap1, gap2}, p -> predicate.test(p[0], p[1], p[2]));
    }

    /**
     * Tests whether there exists at least one pair of points separated by the given gap
     * for which the supplied predicate evaluates to true.
     */
    private static boolean anySeparatedPair(Point[] points, int gap, PairPredicate predicate) {
        return anySeparatedN(points, new int[] {gap}, p -> predicate.test(p[0], p[1]));
    }

    /**
     * Tests whether there exists at least one sequence of n consecutive points
     * for which the supplied predicate evaluates to true.
     */
    private static boolean anyConsecutiveN(Point[] points, int n, NPredicate predicate) {
        return anySeparatedN(points, new int[n - 1], predicate);
    }

    /**
     * Tests whether there exists at least one triple of consecutive points
     * for which the supplied predicate evaluates to true.
     */
    private static boolean anyConsecutiveTriple(Point[] points, TriplePredicate predicate) {
        return anyConsecutiveN(points, 3, p -> predicate.test(p[0], p[1], p[2]));
    }

    /**
     * Tests whether there exists at least one pair of consecutive points
     * for which the supplied predicate evaluates to true.
     */
    private static boolean anyConsecutivePair(Point[] points, PairPredicate predicate) {
        return anyConsecutiveN(points, 2, p -> predicate.test(p[0], p[1]));
    }

}