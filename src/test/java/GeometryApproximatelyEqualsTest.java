import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GeometryApproximatelyEqualsTest {

    @Test
    void approximatelyEquals() {
        assertTrue(Geometry.approximatelyEquals(1.0, 1.0, 0.0));
        assertTrue(Geometry.approximatelyEquals(1.0, 1.001, 0.01));
        assertFalse(Geometry.approximatelyEquals(1.0, 1.1, 0.05));
        assertTrue(Geometry.approximatelyEquals(-2.0, -2.005, 0.01));
        assertFalse(Geometry.approximatelyEquals(-2.0, -1.99, 0.005));
    }
}