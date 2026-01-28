import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LIC5Test {

    private static final Parameters EMPTY_PARAMETERS =
            new Parameters(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

    @Test
    void decreasingX() {
        Point[] points = {
                new Point(5, 0),
                new Point(3, 1),
                new Point(4, 4)
        };

        assertTrue(LIC.lic5(points, EMPTY_PARAMETERS));
    }

    @Test
    void nonDecreasingX() {
        Point[] points = {
                new Point(1, 0),
                new Point(3, 1),
                new Point(3, -2)
        };

        assertFalse(LIC.lic5(points, EMPTY_PARAMETERS));
    }

    @Test
    void singlePoint() {
        Point[] points = {
                new Point(1, 0)
        };

        assertFalse(LIC.lic5(points, EMPTY_PARAMETERS));
    }
}
