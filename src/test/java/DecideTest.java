import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecideTest {

    @Test
    void falseLaunch() {
        Point[] points = {
                new Point(0, 0),
                new Point(2, 0),
                new Point(4, 0),
                new Point(6, 0)
        };

        Parameters params = new Parameters(
                1.5,  // length1
                10.0, // length2
                2.0,  // radius1
                5.0,  // radius2
                1.0,  // area1
                10.0, // area2
                0.01, // epsilon
                1.0,  // distance
                2,    // quads
                3,    // qPoints
                3,    // nPoints
                1,    // kPoints
                1,    // aPoints
                1,    // bPoints
                1,    // cPoints
                1,    // dPoints
                1,    // ePoints
                1,    // fPoints
                1     // gPoints
        );

        Decide.Connector[][] lcm = new Decide.Connector[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (i == 0 || j == 0)
                    lcm[i][j] = Decide.Connector.OR;
                else if (i == 14 || j == 14)
                    lcm[i][j] = Decide.Connector.NOT_USED;
                else
                    lcm[i][j] = Decide.Connector.AND;
            }
        }

        boolean[] puv = new boolean[15];
        for (int i = 0; i < 15; i++) {
            puv[i] = true;
        }

        Decide decide = new Decide();
        boolean launch = decide.decide(points, params, lcm, puv);
        boolean[] cmv = decide.getCmv();
        boolean[][] pum = decide.getPum();
        boolean[] fuv = decide.getFuv();

        boolean[] trueCmv = new boolean[] {
                true,   // LIC 0: distance p1, p2 > 1.5
                false,  // LIC 1: all triples fit in radius 2 circle
                false,  // LIC 2: all points collinear so angles are pi
                false,  // LIC 3: triangle area is 0
                false,  // LIC 4: all in same quadrant
                false,  // LIC 5: monotonic
                false,  // LIC 6: all points lie on the line
                true,   // LIC 7: distance p1, p3 > 1.5
                false,  // LIC 8: not enough points
                false,  // LIC 9: not enough points
                false,  // LIC 10: not enough points
                false,  // LIC 11: monotonic
                true,   // LIC 12: distance p1, p3 > 1.5 and < 10
                false,  // LIC 13: not enough points
                false   // LIC 14: not enough points
        };

        boolean[][] truePum = new boolean[][] {
                new boolean[] {false, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false, true, false, true},
                new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                new boolean[] {true, false, false, false, false, false, false, true, false, false, false, false, false, false, true},
                new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, false},
        };

        boolean[] trueFuv = new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true};

        assertArrayEquals(cmv, trueCmv);
        assertPumEquals(pum, truePum);
        assertArrayEquals(fuv, trueFuv);
        assertFalse(launch);
    }

    @Test
    void trueLaunch() {
        Point[] points = { 
                new Point(0, 0), 
                new Point(1, 2), 
                new Point(3, 5), 
                new Point(5, 1), 
                new Point(6, 4), 
                new Point(2, 6) 
        };

        Parameters params = new Parameters(
                2.0,  // length1
                5.0, // length2
                1.0,  // radius1
                10.0,  // radius2
                0.5,  // area1
                8.0, // area2
                0.05, // epsilon
                2.0,  // distance
                2,    // quads
                3,    // qPoints
                3,    // nPoints
                1,    // kPoints
                1,    // aPoints
                1,    // bPoints
                1,    // cPoints
                1,    // dPoints
                1,    // ePoints
                1,    // fPoints
                1     // gPoints
        );

        Decide.Connector[][] lcm = new Decide.Connector[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                lcm[i][j] = Decide.Connector.OR;
            }
        }

        boolean[] puv = new boolean[] {true, true, true, false, false, true, true, true, false, false, false, true, true, true, false};

        Decide decide = new Decide();
        boolean launch = decide.decide(points, params, lcm, puv);
        boolean[] cmv = decide.getCmv();
        boolean[][] pum = decide.getPum();
        boolean[] fuv = decide.getFuv();

        boolean[] trueCmv = new boolean[] {
                true,   // LIC 0: distance p1, p2 > 2
                true,   // LIC 1: p1, p2, p3 do not fit in radius 1 circle
                true,   // LIC 2: non-collinear points have angles that are not pi
                true,  // LIC 3: p1, p2, p3 triangle area > 0.5
                false,  // LIC 4: all in same quadrant
                true,   // LIC 5: not monotonic
                true,   // LIC 6: distance p3 to p2-p4 line > 2 
                true,   // LIC 7: distance p1, p3 > 2
                true,  // LIC 8: p1, p3, p5 do not fit in radius 1 circle
                true,  // LIC 9: p1, p3, p5 have angle that is not pi
                true,  // LIC 10: p1, p3, p5 triangle area > 0.5
                true,   // LIC 11: not monotonic with gap 1
                true,   // LIC 12: distance p2, p4 > 2 and < 5
                true,   // LIC 13: p1, p3, p5 do not fit in radius 1 circle but fit in radius 10
                false   // LIC 14: all triangle areas > 8
        };

        boolean[][] truePum = new boolean[][] {
                new boolean[] {false, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                new boolean[] {true, false, true, true, true, true, true, true, true, true, true, true, true, true, true},
                new boolean[] {true, true, false, true, true, true, true, true, true, true, true, true, true, true, true},
                new boolean[] {true, true, true, false, true, true, true, true, true, true, true, true, true, true, true},
                new boolean[] {true, true, true, true, false, true, true, true, true, true, true, true, true, true, false},
                new boolean[] {true, true, true, true, true, false, true, true, true, true, true, true, true, true, true},
                new boolean[] {true, true, true, true, true, true, false, true, true, true, true, true, true, true, true},
                new boolean[] {true, true, true, true, true, true, true, false, true, true, true, true, true, true, true},
                new boolean[] {true, true, true, true, true, true, true, true, false, true, true, true, true, true, true},
                new boolean[] {true, true, true, true, true, true, true, true, true, false, true, true, true, true, true},
                new boolean[] {true, true, true, true, true, true, true, true, true, true, false, true, true, true, true},
                new boolean[] {true, true, true, true, true, true, true, true, true, true, true, false, true, true, true},
                new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, false, true, true},
                new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, false, true},
                new boolean[] {true, true, true, true, false, true, true, true, true, true, true, true, true, true, false}
        };

        boolean[] trueFuv =  new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};

        assertArrayEquals(cmv, trueCmv);
        assertPumEquals(pum, truePum);
        assertArrayEquals(fuv, trueFuv);
        assertTrue(launch);
    }

    void assertPumEquals(boolean[][] pum, boolean[][] otherPum) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (i != j)
                    assertEquals(pum[i][j], otherPum[i][j], "mismatch at index [" + i + "][" + j + "]");
            }
        }
    }
}
