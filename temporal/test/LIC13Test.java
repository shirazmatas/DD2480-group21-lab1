import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LIC13Test {
    private static Parameters makeParameters(double rad1, double rad2, int aPoints, int bPoints) {
        return new Parameters(0, 0, rad1, rad2, 0, 0, 0, 0, 0, 0, 0, 1, aPoints, bPoints, 0, 0, 0,0, 0);
    }

    @Test
    void lic13t01(){
        Parameters par = makeParameters(1.0, 15.0, 1, 1);
        Point[] points = new Point[5];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(10, 0);
        points[3] = new Point(0, 0);
        points[4] = new Point(0, 10);
        assertTrue(LIC.lic13(points, par));
    }

    @Test
    void lic13t02(){
        Parameters par = makeParameters(1.0, 5.0, 1, 1);
        Point[] points = new Point[5];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(10, 0);
        points[3] = new Point(0, 0);
        points[4] = new Point(0, 10);
        assertFalse(LIC.lic13(points, par));
    }
}
