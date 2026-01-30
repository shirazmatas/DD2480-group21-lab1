import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeometryDistanceToLineTest {

    // Distance from point to line
    @Test
    void distanceToPoint01(){
        Point p = new Point(5, 5);
        Point a = new Point(0, 0);
        Point b = new Point(0, 10);
        assertEquals(5.0, Geometry.distanceToLine(p, a, b));
    }

    // Distance from point on line is 0
    @Test
    void distanceToPoint02(){
        Point p = new Point(0, 5);
        Point a = new Point(0, 0);
        Point b = new Point(0, 10);
        assertEquals(0.0, Geometry.distanceToLine(p, a, b));
    }

    // Distance from point diagonal to line
    @Test
    void distanceToPoint03(){
        double diag = Math.sqrt(2);
        Point p = new Point(0, 2);
        Point a = new Point(0, 0);
        Point b = new Point(10, 10);
        assertEquals(diag, Geometry.distanceToLine(p, a, b),1e-6);
    }

    // If two line points are coincident, return distance between points
    @Test
    void distanceToPoint04(){
        Point p = new Point(0,0);
        Point a = new Point(3, 4);
        Point b = new Point(3, 4);
        assertEquals(5.0, Geometry.distanceToLine(p, a, b));
    }
}
