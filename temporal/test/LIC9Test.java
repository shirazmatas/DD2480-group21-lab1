import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LIC9Test {

    private static Parameters makeParameters(int cPoints, int dPoints, double epsilon) {
        return new Parameters(0, 0, 0, 0, 0, 0, epsilon, 0, 1, 2, 3, 0, 1, 1, cPoints, dPoints, 1, 1, 1);
    }

    @Test
    void notEnoughPoints() {
        Point[] points = {
                new Point(0,0),
                new Point(1,0),
                new Point(2,0)
        };
        Parameters params = makeParameters(1, 1, 0.1);
        assertFalse(LIC.lic9(points, params));
    }

    @Test
    void allAnglesApproximatelyPi() {
        Point[] points = {
                new Point(0,0),
                new Point(1,0),
                new Point(2,0),
                new Point(3,0),
                new Point(4,0)
        };
        Parameters params = makeParameters(1, 1, 0.01);
        assertFalse(LIC.lic9(points, params));
    }

    @Test
    void someAngleNotApproximatelyPi() {
        Point[] points = {
                new Point(0,0),
                new Point(1,0),
                new Point(0,1),
                new Point(2,2),
                new Point(3,0),
                new Point(4,0)
        };
        Parameters params = makeParameters(2, 1, 0.01);
        assertTrue(LIC.lic9(points, params));
    }

    @Test
    void undefinedAngle() {
        Point[] points = {
                new Point(0,0),
                new Point(0,1),
                new Point(0,0),
                new Point(2,0),
                new Point(3,0)
        };
        Parameters params = makeParameters(1, 1, 0.01);
        assertFalse(LIC.lic9(points, params));
    }
}
