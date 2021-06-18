package training.it;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lifecycle2IT {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll2");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach2");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach2");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll2");
    }

    @Test
    void testA() {
        //assertEquals(1,2);
        System.out.println("test2A");
    }

    @Test
    void testB() {
        //assertEquals(1,2);
        System.out.println("test2B");
    }
}