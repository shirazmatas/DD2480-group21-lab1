import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LIC4Test {
    private static Parameters makeParameters(int qPoints, int quads) {
        return new Parameters(
                0, 0, 0, 0, 0, 0, 0, 0, quads, qPoints, 3, 1, 1, 1, 1, 1, 1, 1, 1
        );
    }
    @Test
    void testCorrectThreeQuadrants() {
        Point[] points = {new Point(1,1), new Point(-1,1), new Point(-1,-1)};
        Parameters params = makeParameters(3,2);
        assertTrue(LIC.lic4(points, params));
    }

    @Test
    void testSameQuad(){
        // because of boundaries 0,0 and 1,0 and 0,1 are in same quad.
        Point[] points = {new Point(0,0), new Point(1,0), new Point(0,1), new Point(5,5)};
        Parameters params = makeParameters(4,1);
        assertFalse(LIC.lic4(points, params));
    }
}