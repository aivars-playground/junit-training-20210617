package training.junit.misc;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestNames {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class A_string_is_valid_replace_underscores {

        @Test
        void if_it_is_not_blank() {
        }

        @DisplayName("DisplayName - if it has only numbers or alphabets")
        @ParameterizedTest(name = "{displayName} -> {0} is a valid string")
        @ValueSource(strings = {"a", "1", "a1"})
        void if_it_has_only_number_or_alphabets(String value) {
        }

    }
}
