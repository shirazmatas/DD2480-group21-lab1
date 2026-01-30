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

    /**
     * LIC 0:
     * There exists at least one pair of consecutive points whose distance
     * is greater than LENGTH1.
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

    /**
     * LIC 1:
     * There exists at least one set of three consecutive points that
     * cannot be contained within or on a circle of radius RADIUS1.
     */
    public static boolean lic1(Point[] points, Parameters parameters) {
        TriplePredicate consectiveThreeNotInCircle = (a,b,c ) -> ! Geometry.circleContains(a,b,c, parameters.radius1());
        return anyConsecutiveTriple(points,consectiveThreeNotInCircle);
    }

    /**
     * LIC 2:
     * There exists at least one set of three consecutive points forming
     * an angle that is either less than (PI - EPSILON) or greater than
     * (PI + EPSILON), with the second point as vertex.
     */
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

    /**
     * LIC 3:
     * There exists at least one set of three consecutive points that
     * form a triangle with area greater than AREA1.
     */
    public static boolean lic3(Point[] points, Parameters parameters) {
        TriplePredicate triangleAreaGreaterThanArea1 = (a, b, c) -> Geometry.triangleArea(a,b,c) > parameters.area1();
        return anyConsecutiveTriple(points, triangleAreaGreaterThanArea1);
    }

    /**
     * LIC 4:
     * There exists at least one set of Q_POINTS consecutive points that
     * lie in more than QUADS distinct quadrants.
     */
    public static boolean lic4(Point[] points, Parameters parameters) {
        NPredicate oneSetOfQPointsInMoreThanQuadsQuadrants = (subsetPoints) ->{
            boolean[] quadrantUsed = new boolean[4];
            int count = 0;
            for (Point p: subsetPoints){
                int quadrantInt = getQuadrant(p);
                quadrantUsed[quadrantInt] = true;
            }

            for (boolean used: quadrantUsed){
                if (used) count++;
            }
            return count > parameters.quads();
        };
        return anyConsecutiveN(points, parameters.qPoints(), oneSetOfQPointsInMoreThanQuadsQuadrants);
    }

    /**
     * LIC 5:
     * There exists at least one pair of consecutive points such that
     * X[j] - X[i] < 0.
     */
    public static boolean lic5(Point[] points, Parameters parameters) {
        return anyConsecutivePair(points, (a, b) ->
            b.x() < a.x()
        );
    }

    /**
     * LIC 6:
     * There exists at least one set of N_POINTS consecutive points such
     * that at least one point lies a distance greater than DIST from the
     * line joining the first and last points.
     */
    public static boolean lic6(Point[] points, Parameters parameters) {
        return anyConsecutiveN(points, parameters.nPoints(), group ->
            Arrays.stream(group).anyMatch( p ->
                Geometry.distanceToLine(p, group[0], group[group.length - 1]) > parameters.distance()
            )
        );
    }

    /**
     * LIC 7:
     * There exists at least one pair of points separated by exactly
     * K_POINTS intervening points whose distance is greater than LENGTH1.
     */
    public static boolean lic7(Point[] points, Parameters parameters) {
        return anySeparatedPair(points, parameters.kPoints(), (a, b) ->
            Geometry.distance(a, b) > parameters.length1()
        );
    }

    /**
     * LIC 8:
     * There exists at least one triple of points separated by exactly
     * A_POINTS and B_POINTS intervening points that cannot be contained
     * within or on a circle of radius RADIUS1.
     */
    public static boolean lic8(Point[] points, Parameters parameters) {
        return anySeparatedTriple(points, parameters.aPoints(), parameters.bPoints(), (a, b, c) ->
            !Geometry.circleContains(a, b, c, parameters.radius1())
        );
    }

    /**
     * LIC 9:
     * There exists at least one triple of points separated by exactly
     * C_POINTS and D_POINTS intervening points forming an angle that is
     * not approximately equal to PI.
     */
    public static boolean lic9(Point[] points, Parameters parameters) {
        return anySeparatedTriple(points, parameters.cPoints(), parameters.dPoints(), (a, b, c) -> {
            double angle = Geometry.angle(a, b, c);
            return !Double.isNaN(angle) && !Geometry.approximatelyEquals(angle, Math.PI, parameters.epsilon());
        });
    }

    /**
     * LIC 10:
     * There exists at least one triple of points separated by exactly
     * E_POINTS and F_POINTS intervening points forming a triangle with
     * area greater than AREA1.
     */
    public static boolean lic10(Point[] points, Parameters parameters) {
        return anySeparatedTriple(points, parameters.ePoints(), parameters.fPoints(), (a,b,c) -> {
            return Geometry.triangleArea(a, b, c) > parameters.area1();
        });
    }

    /**
     * LIC 11:
     * There exists at least one pair of points separated by exactly
     * G_POINTS intervening points such that X[j] - X[i] < 0.
     */
    public static boolean lic11(Point[] points, Parameters parameters) {
        return anySeparatedPair(points, parameters.gPoints(), (a, b) ->
                b.x() < a.x() //
        );
    }

    /**
     * LIC 12:
     * There exists at least one separated pair with distance greater than
     * LENGTH1 and at least one (possibly different) separated pair with
     * distance less than LENGTH2.
     */
    public static boolean lic12(Point[] points, Parameters parameters) {
        boolean condition1 = anySeparatedPair(points, parameters.kPoints(), (a, b) ->
                Geometry.distance(a, b) > parameters.length1());

        boolean condition2 = anySeparatedPair(points, parameters.kPoints(), (a, b) ->
                Geometry.distance(a, b) < parameters.length2());

        return condition1 && condition2;
    }

    /**
     * LIC 13:
     * There exists at least one separated triple not contained in a circle
     * of radius RADIUS1 and at least one (possibly different) separated
     * triple contained in a circle of radius RADIUS2.
     */
    public static boolean lic13(Point[] points, Parameters parameters) {
        boolean condition1 = anySeparatedTriple(points, parameters.aPoints(), parameters.bPoints(), (a, b, c) ->
                !Geometry.circleContains(a,b, c, parameters.radius1()));

        boolean condition2 = anySeparatedTriple(points, parameters.aPoints(), parameters.bPoints(), (a, b, c) ->
                Geometry.circleContains(a, b, c , parameters.radius2()));

        return condition1 && condition2;
    }

    /**
     * LIC 14:
     * There exists at least one separated triple with area greater than
     * AREA1 and at least one (possibly different) separated triple with
     * area less than AREA2.
     */
    public static boolean lic14(Point[] points, Parameters parameters) {
        boolean condition1 = anySeparatedTriple(points, parameters.ePoints(), parameters.fPoints(), (a, b, c) ->
                Geometry.triangleArea(a, b, c) > parameters.area1());

        boolean condition2 = anySeparatedTriple(points, parameters.ePoints(), parameters.fPoints(), (a, b, c) ->
                Geometry.triangleArea(a, b, c) < parameters.area2());

        return condition1 && condition2;
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

    /**
     * Determines quadrant of a point.
     */
    private static int getQuadrant(Point p){
        if (p.x() >=0 && p.y() >= 0) return 1;
        if (p.x() < 0 && p.y()>= 0) return 2;
        if (p.x() <= 0 && p.y() < 0) return 3;
        return 4;
    }

}