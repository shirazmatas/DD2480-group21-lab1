import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LIC0Test {
    private static Parameters makeParameters(double length1) {
        return new Parameters(
                length1, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1
        );
    }
    @Test
    void testSuccess() {
        Point[] points = { new Point(0,0), new Point(0,3), new Point(0,4)};
        Parameters params = makeParameters(2);
        assertTrue(LIC.lic0(points, params));
    }

    @Test
    void testSlightlyBigger(){
        Point[] points = { new Point(0,0), new Point(0,1), new Point(0,2)};
        Parameters params = makeParameters(0.999);
        assertTrue(LIC.lic0(points, params));
    }

    @Test
    void testExactlyEqual(){
        // It must be greater than length1
        Point[] points = { new Point(0,0), new Point(0,2)};
        Parameters params = makeParameters(2);
        assertFalse(LIC.lic0(points, params));
    }

     @Test
    void testNotEnoughPoints(){
        Point[] points = {new Point(0,0)};
        Parameters params = makeParameters(2);
        assertFalse(LIC.lic0(points, params));
     }

     @Test
    void testNegativeValues(){
        Point[] points = {new Point(-1, -1), new Point(-3.2, -1), new Point(-4, -1)};
        Parameters params = makeParameters(2);
        assertTrue(LIC.lic0(points, params));
     }
}