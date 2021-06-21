package training.junit.misc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThisLooksLikeBDDTest {

    @DisplayName("Given that a = 1")
    @Nested
    class A1 {
        private int a =1;

        @DisplayName("When b = 2")
        @Nested
        class B2 {
            private int b = 2;

            @DisplayName("Then a+b=3")
            @Test
            void testAddition() {
                assertEquals(3, a + b);
            }
        }
    }

}
