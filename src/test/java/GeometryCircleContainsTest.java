import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GeometryCircleContainsTest {

    // Vertices of acute triangle can be contained in circle with given radius
    @Test
    void acuteTriangleInsideCircle() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(0, 1);

        // circumradius = sqrt(2)/2 = 0.707
        assertTrue(Geometry.circleContains(a, b, c, 0.8));
    }

    // Vertices of acute triangle cannot be contained in circle with given radius
    @Test
    void acuteTriangleOutsideCircle() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(0, 1);

        // radius = sqrt(2)/2 = 0.707
        assertFalse(Geometry.circleContains(a, b, c, 0.6));
    }

    // Vertices of right triangle can be contained in circle with given radius
    @Test
    void rightTriangleInsideCircle() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 1);

        // radius = 1
        assertTrue(Geometry.circleContains(a, b, c, 1.0));
    }

    // Vertices of obtuse triangle can be contained in circle with given radius
    @Test
    void obtuseTriangleInsideCircle() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(1, 1);

        // radius = 2
        assertTrue(Geometry.circleContains(a, b, c, 2.0));
    }

    // Collinear points that cannot be contained in circle with given radius
    @Test
    void collinearPointsOutsideCircle() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(4, 0);

        // radius = 2
        assertFalse(Geometry.circleContains(a, b, c, 1.5));
    }

    // Collinear points that can be contained in circle with given radius
    @Test
    void collinearPointsInsideCircle() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 0);

        // radius = 1
        assertTrue(Geometry.circleContains(a, b, c, 1.0));
    }

    // Coincident points can be contained in any circle
    @Test
    void coincidentPointsInsideCircle() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 1);
        Point c = new Point(1, 1);

        // always contained
        assertTrue(Geometry.circleContains(a, b, c, 0.0));
    }
}
