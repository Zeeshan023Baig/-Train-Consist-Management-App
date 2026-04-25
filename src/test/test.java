import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainTest {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String msg) { super(msg); }
    }

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type) { this.type = type; }

        void assignCargo(String cargo) {
            try {
                if (type.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe");
                }
                this.cargo = cargo;
            } catch (CargoSafetyException e) {
                // handled
            } finally {
                // always executes
            }
        }
    }

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie b = new GoodsBogie("Cylindrical");
        b.assignCargo("Petroleum");
        assertEquals("Petroleum", b.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");
        assertNull(b.cargo); // should not be assigned
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");
        assertNull(b.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Petroleum"); // fails
        b.assignCargo("Coal");      // should work
        assertEquals("Coal", b.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        // No direct assert for finally, but method should not crash
        assertDoesNotThrow(() -> b.assignCargo("Petroleum"));
    }
}