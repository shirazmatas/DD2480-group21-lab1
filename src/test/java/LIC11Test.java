import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LIC11Test {
    private static Parameters makeParameters(int gPoints) {
        return new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, gPoints);
    }

    @Test
    void lic11t01(){
        Parameters par = makeParameters(1);
        Point[] points = new Point[3];
        points[0] = new Point(5, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(4, 0);
        assertTrue(LIC.lic11(points, par));
    }

    @Test
    void lic11t02(){
        Parameters par = makeParameters(2);
        Point[] points = new Point[4];
        points[0] = new Point(4, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(0, 0);
        points[3] = new Point(5, 0);
        assertFalse(LIC.lic11(points, par));
    }
}
