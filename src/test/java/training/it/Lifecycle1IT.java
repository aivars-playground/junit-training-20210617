package training.it;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class Lifecycle1IT {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll1");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach1");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach1");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll1");
    }

    @Test
    void testA() {
        //assertEquals(1,2);
        System.out.println("test1A");
    }

    @Test
    void testB() {
        //assertEquals(1,2);
        System.out.println("test1B");
    }
}