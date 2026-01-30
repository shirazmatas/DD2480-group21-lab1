import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LIC3Test {

    private static Parameters makeParameters(double area1) {
        return new Parameters(
                0, 0, 0, 0, area1, 0, 0, 0, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1
        );
    }
    @Test
    void testCorrectBigger() {
        Point[] points = {new Point(0,0), new Point(2,0),new Point(0,2),new Point(10,10)};
        Parameters params = makeParameters(1.0);
        assertTrue(LIC.lic3(points, params));
    }

    @Test
    void testAreaExactly(){
        Point[] points = {new Point(0,0), new Point(2,0),new Point(0,2)};
        Parameters params = makeParameters(2.0);
        assertFalse(LIC.lic3(points, params));
    }

    @Test
    void testTooFewPoints(){
        Point[] points = {new Point(0,0), new Point(5,5)};
        Parameters params = makeParameters(1.0);
        assertFalse(LIC.lic3(points, params));
    }
}