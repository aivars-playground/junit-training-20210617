package training.junit.extensions;

public class WithMetaAnnotationTest {

    @MyMetaAnnotation
    void customMetaAnnotationTest() {
        System.out.println("works");
    }

}
