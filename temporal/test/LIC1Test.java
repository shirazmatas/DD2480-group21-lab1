import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LIC1Test {
    private static Parameters makeParameters(double radius1) {
        return new Parameters(
                0, 0, radius1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        );
    }
    @Test
    void testDistanceBig() {
        Point[] points = {new Point(0, 0), new Point(10, 0), new Point(-10, -10)};
        Parameters params = makeParameters(1.0);
        assertTrue(LIC.lic1(points,params));
    }
    @Test
    void testVeryInside(){
        Point[] points = {new Point(0, 0), new Point(1, 0), new Point(-1, 0)};
        Parameters params = makeParameters(10.0);
        assertFalse(LIC.lic1(points,params));
    }

    @Test
    void testEdgeCase(){
        // should be false as it says within or on
        Point[] points = {new Point(1, 0), new Point(-1, 0), new Point(0, 1)};
        Parameters params = makeParameters(1);
        assertFalse(LIC.lic1(points, params));
    }

    @Test
    void testTooFewPoints(){
        Point[] points = {new Point(10, 0), new Point(-10, 1)};
        Parameters params = makeParameters(1);
        assertFalse(LIC.lic1(points, params));
    }

    @Test
    void testStraightLine(){
        Point[] points = {new Point(0, 0), new Point(2, 0), new Point(1, 0)};
        assertTrue(LIC.lic1(points,  makeParameters(0.98)));
        assertFalse(LIC.lic1(points,  makeParameters(1.0001)));
    }

    @Test
    void testAcutePoints(){
        Point[] points = {new Point(0, 0), new Point(4, 0), new Point(2, 3)};
        assertTrue(LIC.lic1(points, makeParameters(2.0)));
        assertFalse(LIC.lic1(points, makeParameters(2.1)));
    }
}