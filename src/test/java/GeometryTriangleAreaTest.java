import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeometryTriangleAreaTest {
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
}