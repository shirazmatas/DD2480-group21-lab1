import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LIC7Test {

    private static Parameters makeParameters(int kPoints, double length1) {
        return new Parameters(
                length1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, kPoints, 0, 0, 0, 0, 0, 0, 0
        );
    }

    @Test
    void notEnoughPoints() {
        Point[] points = {
                new Point(0,0),
                new Point(1,1)
        };
        Parameters params = makeParameters(1, 1.0);
        assertFalse(LIC.lic7(points, params));
    }

    @Test
    void allWithinDistance() {
        Point[] points = {
                new Point(0,0),
                new Point(1,1),
                new Point(2,2),
                new Point(3,3)
        };
        Parameters params = makeParameters(1, 5.0);
        assertFalse(LIC.lic7(points, params));
    }

    @Test
    void someExceedDistance() {
        Point[] points = {
                new Point(0,0),
                new Point(1,0),
                new Point(2,0),
                new Point(8,0)
        };
        Parameters params = makeParameters(2, 5.0);
        assertTrue(LIC.lic7(points, params));
    }
}
