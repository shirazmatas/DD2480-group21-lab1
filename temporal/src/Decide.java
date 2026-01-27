public class Decide {

    public enum Connector {
        AND,
        OR,
        NOT_USED
    }

    public boolean decide(Point[] points, Parameters parameters, Connector[][] lcm, boolean[] puv) {
        throw new UnsupportedOperationException();
    }

    /**
     * The indices of the CMV (Conditions Met Vector) are set to the result of the
     * corresponding LIC for the given points and parameters.
     */
    private boolean[] calculateCMV(Point[] points, Parameters parameters) {
        return new boolean[] {
            LIC.lic0(points, parameters),
            LIC.lic1(points, parameters),
            LIC.lic2(points, parameters),
            LIC.lic3(points, parameters),
            LIC.lic4(points, parameters),
            LIC.lic5(points, parameters),
            LIC.lic6(points, parameters),
            LIC.lic7(points, parameters),
            LIC.lic8(points, parameters),
            LIC.lic9(points, parameters),
            LIC.lic10(points, parameters),
            LIC.lic11(points, parameters),
            LIC.lic12(points, parameters),
            LIC.lic13(points, parameters),
            LIC.lic14(points, parameters)
        };
    }

    private boolean[][] calculatePUM(boolean[] cmv, Connector[][] lcm){
        throw new UnsupportedOperationException();
    }

    private boolean[] calculateFUV(boolean[][] pum, boolean[] puv) {
        throw new UnsupportedOperationException();
    }

}