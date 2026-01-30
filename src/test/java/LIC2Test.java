import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LIC2Test {

    private static Parameters makeParameters(double epsilon) {
        return new Parameters(
                0, 0, 0, 0, 0, 0, epsilon, 0, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1
        );
    }
    @Test
    void testAcuteAngle() {
        Point[] points = {new Point(0,0), new Point(1,1), new Point(2,0)};
        Parameters params = makeParameters(0.1);
        assertTrue(LIC.lic2(points, params));
    }

    @Test
    void testStraightLineFalse(){
        Point[] points = {new Point(0,0), new Point(1,0), new Point(2,0)};
        Parameters params = makeParameters(0.01);
        assertFalse(LIC.lic2(points,params));
    }
}