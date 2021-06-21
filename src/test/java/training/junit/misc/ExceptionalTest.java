package training.junit.misc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("ExceptionalTest: friendly name")
class ExceptionalTest {

    @Test
    @DisplayName("doThrowException() friendly name")
    void doThrowException() {
        var exceptional = new Exceptional();
        var error = assertThrows(RuntimeException.class, exceptional::doThrowException);
        assertEquals("catch me", error.getMessage());
    }
}