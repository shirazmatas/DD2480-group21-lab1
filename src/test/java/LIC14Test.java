import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LIC14Test {
    private static Parameters makeParameters(double area1, double area2, int ePoints, int fPoints) {
        return new Parameters(0, 0, 0, 0, area1, area2, 0, 0, 1, 2, 3, 1, 1, 1, 1, 1, ePoints, fPoints, 1);
    }

    @Test
    void lic14t01(){
        Parameters par = makeParameters(1.0, 15.0, 1, 1);
        Point[] points = new Point[5];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(2, 0);
        points[3] = new Point(0, 0);
        points[4] = new Point(0, 2);
        assertTrue(LIC.lic14(points, par));
    }

    @Test
    void lic14t02(){
        Parameters par = makeParameters(1.0, 1.0, 1, 1);
        Point[] points = new Point[5];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(2, 0);
        points[3] = new Point(0, 0);
        points[4] = new Point(0, 2);
        assertFalse(LIC.lic14(points, par));
    }
}
