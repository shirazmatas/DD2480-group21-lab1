import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LIC6Test {

    private static Parameters makeParameters(int nPoints, double distance) {
        return new Parameters(0, 0, 0, 0, 0, 0, 0, distance, 1, 2, nPoints, 1, 1, 1, 1, 1, 1, 1, 1);
    }


    @Test
    void notEnoughPoints() {
        Point[] points = {
            new Point(0,0),
            new Point(1,1)
        };
        Parameters params = makeParameters(3, 1.0);

        assertFalse(LIC.lic6(points, params));
    }

    @Test
    void allPointsWithinDistance() {
        Point[] points = {
                new Point(0,0),
                new Point(1,0),
                new Point(1, 1),
                new Point(0, 1),
                new Point(2,0)
        };
        Parameters params = makeParameters(3, 1.0);

        assertFalse(LIC.lic6(points, params));
    }

    @Test
    void somePointExceedsDistance() {
        Point[] points = {
                new Point(0,0),
                new Point(1,5),
                new Point(2,0)
        };
        Parameters params = makeParameters(3, 1.0);

        assertTrue(LIC.lic6(points, params));
    }

    @Test
    void coincidentPoints() {
        Point[] points = {
                new Point(0,0),
                new Point(3,4),
                new Point(0,0)
        };
        Parameters params = makeParameters(3, 4.0);

        assertTrue(LIC.lic6(points, params));

        params = makeParameters(3, 5.0);

        assertFalse(LIC.lic6(points, params));
    }

}
