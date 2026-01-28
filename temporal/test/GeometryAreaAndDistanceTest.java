import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeometryAreaAndDistanceTest {
    @Test
    void triangleArea01(){
        Point a = new Point(0,0);
        Point b = new Point(0,1);
        Point c = new Point(1,0);
        assertEquals(0.5,Geometry.triangleArea(a,b,c));
    }

    @Test
    void triangleArea02(){
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);
        Point c = new Point(3, 3);
        assertEquals(0.0, Geometry.triangleArea(a,b,c));
    }

    @Test
    void triangleArea03(){
        Point a = new Point(0,0);
        Point b = new Point(0,-1);
        Point c = new Point(-1,0);
        assertEquals(0.5,Geometry.triangleArea(a,b,c));
    }

    @Test
    void distanceToPoint01(){
        Point p = new Point(5, 5);
        Point a = new Point(0, 0);
        Point b = new Point(0, 10);
        assertEquals(5.0, Geometry.distanceToLine(p, a, b));
    }

    @Test
    void distanceToPoint02(){
        Point p = new Point(0, 5);
        Point a = new Point(0, 0);
        Point b = new Point(0, 10);
        assertEquals(0.0, Geometry.distanceToLine(p, a, b));
    }

    @Test
    void distanceToPoint03(){
        double diag = Math.sqrt(2);
        Point p = new Point(0, 2);
        Point a = new Point(0, 0);
        Point b = new Point(10, 10);
        assertEquals(diag, Geometry.distanceToLine(p, a, b),1e-6);
    }

    @Test
    void distanceToPoint04(){
        Point p = new Point(2,8);
        Point a = new Point(0, 5);
        Point b = new Point(10, 5);
        assertEquals(3.0, Geometry.distanceToLine(p, a, b));
    }

}