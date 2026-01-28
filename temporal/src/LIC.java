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
            return angle< (Math.PI - parameters.epsilon()) || angle > (Math.PI + parameters.epsilon());
        };
        return anyConsecutiveTriple(points, angleSmallerOrBiggerPiEpsilon);
    }

    public static boolean lic3(Point[] points, Parameters parameters) {
        throw new UnsupportedOperationException();
    }

    public static boolean lic4(Point[] points, Parameters parameters) {
        throw new UnsupportedOperationException();
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

    private static boolean anySeparatedN(Point[] points, int[] gaps, NPredicate predicate) {
        throw new UnsupportedOperationException();
    }

    private static boolean anySeparatedTriple(Point[] points, int gap1, int gap2,  TriplePredicate predicate) {
        throw new UnsupportedOperationException();
    }

    private static boolean anySeparatedPair(Point[] points, int gap, PairPredicate predicate) {
        throw new UnsupportedOperationException();
    }

    private static boolean anyConsecutiveN(Point[] points, NPredicate predicate) {
        throw new UnsupportedOperationException();
    }

    private static boolean anyConsecutiveTriple(Point[] points, TriplePredicate predicate) {
        throw new UnsupportedOperationException();
    }

    private static boolean anyConsecutivePair(Point[] points, PairPredicate predicate) {
        throw new UnsupportedOperationException();
    }

}