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
        throw new UnsupportedOperationException();
    }

}