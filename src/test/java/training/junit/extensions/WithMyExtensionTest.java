package training.junit.extensions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyClassLevelExtension.class)
public class WithMyExtensionTest {

    @Test
    void emptyTest1() {
        System.out.println("launching emptyTest");
    }

    @Test
    @ExtendWith(MyMethodLevelExtension.class)
    void emptyTest2() {
        System.out.println("launching emptyTest2");
    }
}
