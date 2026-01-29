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

    public static boolean[][] calculatePUM(boolean[] cmv, Connector[][] lcm){
        boolean[][] PUM = new boolean[cmv.length][cmv.length];
        for(int i = 0; i<lcm.length ; i++){
            for(int j = 0; j<lcm.length ; j++){
                if(i==j){
                    PUM[i][j] = cmv[i];
                    continue;
                }
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
        throw new UnsupportedOperationException();
    }

}