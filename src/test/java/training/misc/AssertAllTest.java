package training.misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertAllTest {

    @Test
    void testAll() {

        var a = 2;

        assertAll(
                () -> assertEquals(3, a + 1, () -> "3 = " + a + " + 1"),
                () -> assertEquals(4, a + 2, () -> "4 = " + a + " + 2")
        );
    }

}
