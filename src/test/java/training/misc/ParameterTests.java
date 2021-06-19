package training.misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.LongStream;

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

}
