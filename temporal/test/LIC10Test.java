import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LIC10Test {
    private static Parameters makeParameters(int nPoints, double area, int ePoints, int fPoints) {
        return new Parameters(0, 0, 0, 0, area, 0, 0, 0, 1, 2, nPoints, 3, 1, 1, 1, 1, ePoints, fPoints, 1);
    }

    @Test
    void lic10t01(){
        Parameters par = makeParameters(5, 0.1, 1, 1);
        Point[] points = new Point[5];
        points[0] = new Point(0, 0);
        points[1] = new Point(20, 20);
        points[2] = new Point(1, 0);
        points[3] = new Point(21, 21);
        points[4] = new Point(0, 1);
        assertTrue(LIC.lic10(points, par));
    }

    @Test
    void lic10t02(){
        Parameters par = makeParameters(5, 0.9, 1 ,1);
        Point[] points = new Point[5];
        points[0] = new Point(0, 0);
        points[1] = new Point(20, 20);
        points[2] = new Point(1, 0);
        points[3] = new Point(21, 21);
        points[4] = new Point(0, 1);
        assertFalse(LIC.lic10(points, par));
    }
}
