import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainTest {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }
    }

    @Test
    void testException_ValidCapacityCreation() throws Exception {
        PassengerBogie b = new PassengerBogie("Sleeper", 70);
        assertEquals(70, b.capacity);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("AC", -10);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("AC", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Sleeper", 0);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        PassengerBogie b = new PassengerBogie("First Class", 40);
        assertEquals("First Class", b.type);
        assertEquals(40, b.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws Exception {
        PassengerBogie b1 = new PassengerBogie("Sleeper", 60);
        PassengerBogie b2 = new PassengerBogie("AC", 80);

        assertEquals(60, b1.capacity);
        assertEquals(80, b2.capacity);
    }
}