import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GeometryCircleContainsTest {

    @Test
    void acuteTriangleInsideCircle() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(0, 1);

        // circumradius = sqrt(2)/2 = 0.707
        assertTrue(Geometry.circleContains(a, b, c, 0.8));
    }

    @Test
    void acuteTriangleOutsideCircle() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(0, 1);

        // radius = sqrt(2)/2 = 0.707
        assertFalse(Geometry.circleContains(a, b, c, 0.6));
    }

    @Test
    void rightTriangleInsideCircle() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 1);

        // radius = 1
        assertTrue(Geometry.circleContains(a, b, c, 1.0));
    }

    @Test
    void obtuseTriangleInsideCircle() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(1, 1);

        // radius = 2
        assertTrue(Geometry.circleContains(a, b, c, 2.0));
    }

    @Test
    void collinearPointsOutsideCircle() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(4, 0);

        // radius = 2
        assertFalse(Geometry.circleContains(a, b, c, 1.5));
    }

    @Test
    void collinearPointsInsideCircle() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 0);

        // radius = 1
        assertTrue(Geometry.circleContains(a, b, c, 1.0));
    }

    @Test
    void coincidentPointsInsideCircle() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 1);
        Point c = new Point(1, 1);

        // always contained
        assertTrue(Geometry.circleContains(a, b, c, 0.0));
    }
}
