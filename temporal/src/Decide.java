public class Decide {

    public enum Connector {
        AND,
        OR,
        NOT_USED
    }

    public boolean decide(Point[] points, Parameters parameters, Connector[][] lcm, boolean[] puv) {
        throw new UnsupportedOperationException();
    }

    private boolean[] calculateCMV(Point[] points, Parameters parameters) {
        throw new UnsupportedOperationException();
    }

    private boolean[][] calculatePUM(boolean[] cmv, Connector[][] lcm){
        throw new UnsupportedOperationException();
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

}