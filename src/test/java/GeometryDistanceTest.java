import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeometryDistanceTest {
    private static final double EPSILON = 0.001;

    // Same point gives distance of 0
    @Test
    void testZeroDistance() {
        Point a = new Point(1,1);
        Point b = new Point(1,1);
        assertEquals(0.0, Geometry.distance(a,b),EPSILON);
    }

    // Distance between two regular points
    @Test
    void testNormalLine(){
        Point a = new Point(0,0 );
        Point b = new Point(2, 5);
        assertEquals(Math.sqrt(29), Geometry.distance(a,b), EPSILON);
    }

    // Distance between two negative points
    @Test
    void testNegativeValues(){
        Point a = new Point(-1, -1);
        Point b = new Point(-4, -5);
        assertEquals(5.0, Geometry.distance(a,b), EPSILON);
    }

    // Distance along vertical line
    @Test
    void testVerticalLine(){
        Point a = new Point (0,1);
        Point b = new Point(0,3);
        assertEquals(2.0, Geometry.distance(a,b), EPSILON);
    }
}