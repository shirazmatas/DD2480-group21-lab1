public class Decide {

    public enum Connector {
        AND,
        OR,
        NOT_USED
    }

    public boolean decide(Point[] points, Parameters parameters, Connector[][] lcm, boolean[] puv) {
        boolean[] cmv = calculateCMV(points, parameters);
        boolean[][] pum = calculatePUM(cmv, lcm);
        boolean[] fuv = calculateFUV(pum, puv);
        return calculateLaunch(fuv);
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

    public static boolean[][] calculatePUM(boolean[] cmv, Connector[][] lcm){
        boolean[][] PUM = new boolean[cmv.length][cmv.length];
        for(int i = 0; i<lcm.length ; i++){
            for(int j = 0; j<lcm.length ; j++){
                switch (lcm[i][j]){
                    case OR -> PUM[i][j] = cmv[i] || cmv[j];
                    case AND -> PUM[i][j] = cmv[i] && cmv[j];
                    case NOT_USED -> PUM[i][j] = true;
                }
            }
        }
        return PUM;
    }

    private boolean[] calculateFUV(boolean[][] pum, boolean[] puv) {
        // Go through all points
        int n = puv.length; // should always be 15
        boolean[] fuv = new boolean[n];
        for (int i = 0; i < n; i++){
            // check first puv[i] = 0
            if (!puv[i]){
                fuv[i] = true;
            } else {
                fuv[i] = isPumRowAllTrue(pum[i], i);
            }
        }
        return fuv;
    }

    private boolean isPumRowAllTrue(boolean[]row, int i){
        for (int j = 0; j < row.length; j++){
            if (!row[j]){
                if (j != i){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean calculateLaunch(boolean[] fuv) {
        for (boolean b : fuv) {
            if (!b) return false;
        }
        return true;
    }

}