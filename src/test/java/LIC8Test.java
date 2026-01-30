import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LIC8Test {

    private static Parameters makeParameters(int aPoints, int bPoints, double radius1) {
        return new Parameters(0, 0, radius1, 0, 0, 0, 0, 0, 1, 2, 3, 1, aPoints, bPoints, 1, 1, 1, 1, 1);
    }

    @Test
    void notEnoughPoints() {
        Point[] points = {
                new Point(0,0),
                new Point(1,0),
                new Point(2,0),
                new Point(3,0)
        };
        Parameters params = makeParameters(1, 1, 1.0);
        assertFalse(LIC.lic8(points, params));
    }

    @Test
    void allPointsInsideCircle() {
        Point[] points = {
                new Point(0,0),
                new Point(1,0),
                new Point(2,0),
                new Point(3,0),
                new Point(4,0)
        };
        Parameters params = makeParameters(1, 1, 10.0);
        assertFalse(LIC.lic8(points, params));
    }

    @Test
    void somePointsOutsideCircle() {
        Point[] points = {
                new Point(0,0),
                new Point(5,0),
                new Point(0,5),
                new Point(2,2),
                new Point(3,3),
                new Point(15,0)
        };
        Parameters params = makeParameters(1, 2, 5.0);
        assertTrue(LIC.lic8(points, params));
    }
}
