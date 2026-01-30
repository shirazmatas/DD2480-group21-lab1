import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LIC12Test {
    private static Parameters makeParameters(double len1, double len2, int kPoints) {
        return new Parameters(len1, len2, 0, 0, 0, 0, 0, 0, 1, 2, 3, kPoints, 1, 1, 1, 1, 1, 1, 1);
    }

    @Test
    void lic12t01(){
        Parameters par = makeParameters(5.0,2.0,1);
        Point[] points = new Point[4];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(10, 0);
        points[3] = new Point(1, 0);
        assertTrue(LIC.lic12(points, par));
    }

    @Test
    void lic12t02(){
        Parameters par = makeParameters(5.0,2.0,1);
        Point[] points = new Point[4];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        points[2] = new Point(10, 0);
        points[3] = new Point(10.5, 0);
        assertFalse(LIC.lic12(points, par));
    }
}
