package training.misc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NestedTest {

    @Nested @DisplayName("given a = 2")
    class OuterWrapper {

        int a = 2;

        @Nested @DisplayName("when b = 2")
        class InnerWrapperTwo {

            int b = 2;

            @Test @DisplayName("then a * b = 4")
            void multiply() {
                assertEquals(4, a*b);
            }

            @Test @DisplayName("then a + b = 4")
            void add() {
                assertEquals(4, a+b);
            }
        }

        @Nested @DisplayName("when b = 3")
        class InnerWrapperThree {

            int b = 3;

            @Test @DisplayName("then a * b = 6")
            void multiply() {
                assertEquals(6, a*b);
            }

            @Test @DisplayName("then a + b = 5")
            void add() {
                assertEquals(5, a+b);
            }
        }
    }
}
