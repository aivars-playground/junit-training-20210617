package training.junit.misc;

import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTestTest {

    @TestFactory
    List<DynamicTest> dynaTest() {
        return List.of(
                dynamicTest(
                        "first",
                        () -> assertEquals(1,1)
                ),
                dynamicTest(
                        "second",
                        () -> assertEquals(1,1)
                )
        );
    }

    LongStream longStream = new Random().longs();

    @TestFactory
    Stream<DynamicTest> longIsLong() {
        return longStream
                .limit(5)
                .mapToObj(
                        randomNumber ->
                             dynamicTest(
                                "testing:" + randomNumber,
                                     () -> {
                                        assertEquals(randomNumber, Long.valueOf(randomNumber).longValue());
                                     }
                             )
                );
    };

    @TestFactory
    Stream<DynamicTest> anotherTestWithStreams() {
        Iterator<Long> inputGenerator = longStream.limit(5).iterator();
        Function<Long, String> displayNameGenerator =
                id -> "Test for id:" + id;
        ThrowingConsumer<Long> testExecutor =
                id -> assertEquals(id, id);

        return DynamicTest.stream(
                inputGenerator,
                displayNameGenerator,
                testExecutor
        );
    }

    @TestFactory
    Stream<DynamicContainer> dynamicTestWithContainers() {
        return LongStream.range(1,6)
                .mapToObj(id -> dynamicContainer(
                            "container id" + id,
                            Stream.of(
                                    dynamicTest("Valid ID",() -> assertTrue(id>0)),
                                    dynamicContainer(
                                            "nested container",
                                            Stream.of(
                                                    dynamicTest(
                                                            "nested test",
                                                            () -> assertTrue(true)
                                                    )
                                            )
                                    )
                            )
                        )
                );
    }


}
