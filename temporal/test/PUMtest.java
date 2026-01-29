import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PUMtest {

    private void fillLCM(Decide.Connector[][] lcm){
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) lcm[i][j] = Decide.Connector.NOT_USED;
        }
    }

    @Test
    void pumTest01() {
        boolean[] cmv = new boolean[15];
        cmv[0] = false;
        cmv[1] = true;
        cmv[2] = true;
        cmv[3] = true;
        cmv[4] = false;

        Decide.Connector[][] lcm = new Decide.Connector[15][15];
        fillLCM(lcm);

        lcm[0][1] = Decide.Connector.AND;
        lcm[0][2] = Decide.Connector.OR;
        lcm[1][2] = Decide.Connector.OR;
        lcm[2][3] = Decide.Connector.AND;
        lcm[0][4] = Decide.Connector.NOT_USED;

        boolean[][] pum = Decide.calculatePUM(cmv, lcm);

        assertFalse(pum[0][1]);
        assertTrue(pum[0][2]);
        assertTrue(pum[1][2]);
        assertTrue(pum[2][3]);
        assertTrue(pum[0][4]);
    }

}