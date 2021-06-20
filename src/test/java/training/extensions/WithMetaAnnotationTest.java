package training.extensions;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class WithMetaAnnotationTest {

    @MyMetaAnnotation
    void customMetaAnnotationTest() {
        System.out.println("works");
    }

}
