package training.misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.TypedArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.xml.transform.Source;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterTests {

    @ParameterizedTest()
    @ValueSource(longs = {1,2,3})
    void paramTest(long id) {
        System.out.println("testing:"+id);
    }

    @ParameterizedTest(name = "Test:{index}, param {0}")
    @DisplayName("Display name for a container")
    @ValueSource(longs = {100,200,300})
    void paramTestWithName(long id) {
        System.out.println("testing:"+id);
    }

    @BeforeEach
    void beforeEach(TestInfo ti) {
        System.out.println("beforeEach:"+ti);
    }

    @ParameterizedTest(name = "Test idx:{index}, display:{displayName}, args:{arguments}. argNames:{argumentsWithNames} param {0}")
    @DisplayName("Display name for a container")
    @ValueSource(longs = {100,200,300})
    void paramTestWithNameWithExtraFunctionality(long id, TestInfo info, TestReporter reporter) {
        System.out.println("testing:"+id + " info:"+info + " reporter:"+reporter);
        reporter.publishEntry("@@@@@@@@@@@ID:", String.valueOf(id));
    }

    @ParameterizedTest()
    @EmptySource
    void testEmptySource(String empty) {
        assertTrue(empty.isEmpty());
    }

    @ParameterizedTest(name = "{2} = {0} + {1}, arguments:{arguments}")
    @CsvSource(value = {"1,2,3","4,5,9"})
    void testCsvSyntax(Integer a, Integer b, Integer c) {
        assertEquals(c, a+b);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asm"})
    void testStartsWithCharA(
            @ConvertWith(FirstLetterExtractor.class) Character firstChar
    ) {
        assertEquals(firstChar, 'a');
    }

}

class FirstLetterExtractor extends TypedArgumentConverter<String, Character>  {

    protected FirstLetterExtractor() {
        super(String.class, Character.class);
    }

    @Override
    protected Character convert(String source) throws ArgumentConversionException {
        return source.charAt(0);
    }
}
