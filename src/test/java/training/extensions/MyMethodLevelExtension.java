package training.extensions;

import org.junit.jupiter.api.extension.*;

public class MyMethodLevelExtension implements
        BeforeAllCallback,
        BeforeEachCallback,
        AfterEachCallback,
        AfterAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        throw new RuntimeException("should not see this on method level");
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        throw new RuntimeException("should not see this on method level");
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("MyMethodLevelExtension - afterEach");
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("MyMethodLevelExtension - beforeEach");
    }
}
