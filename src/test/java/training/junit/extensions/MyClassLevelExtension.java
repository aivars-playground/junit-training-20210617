package training.junit.extensions;

import org.junit.jupiter.api.extension.*;

public class MyClassLevelExtension implements
        BeforeAllCallback,
        BeforeEachCallback,
        AfterEachCallback,
        AfterAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        System.out.println("MyClassLevelExtension - beforeAll");
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        System.out.println("MyClassLevelExtension - afterAll");
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("MyClassLevelExtension - afterEach");
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("MyClassLevelExtension - beforeEach");
    }
}
