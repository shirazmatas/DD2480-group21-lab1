import org.junit.jupiter.api.Test;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

class GeometryAngleTest {
    private static final double EPSILON = 0.001;

    // Test if right angle computed correctly
    @Test
    void testRightAngle() {
        Point a = new Point(0, 1);
        Point b = new Point(0, 0);
        Point c = new Point(1, 0);
        // we know this is 90* i.e pi
        assertEquals(Math.PI/2.0, Geometry.angle(a,b,c), EPSILON);
    }

    // Test if angle computed correctly for collinear points
    @Test
    void testFlatLine() {
        Point a = new Point(-1, 0);
        Point b = new Point(0, 0);
        Point c = new Point(1, 0);
        // should give us 180 or 1 pi
        assertEquals(Math.PI, Geometry.angle(a, b, c), EPSILON);
    }

    // Test if angle computed correctly for all identical points
    @Test
    void testSamePoints() {
        Point p = new Point(1,1);
        // According to specs it should give us NaN
        assertEquals(NaN, Geometry.angle(p, p, p), EPSILON);
    }

    // Test if angle computed correctly with negative points
    @Test
    void testNegativePoints(){
        Point a = new Point(-2,-1);
        Point b = new Point( -1, -1);
        Point c = new Point(-1, -2);
        assertEquals(3 * Math.PI/2.0, Geometry.angle(a,b,c), EPSILON);
    }

    // Test that angle is 0 if A and C are identical
    @Test
    void testACSame(){
        // when other points same should return 0.
        Point a = new Point(1,1);
        Point b = new Point(0,0);
        assertEquals(0.0, Geometry.angle(a, b, a), EPSILON);
    }
}