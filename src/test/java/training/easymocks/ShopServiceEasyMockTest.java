package training.easymocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.shop.ShopService;
import training.shop.SupplierService;
import training.shop.product.Product;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShopServiceEasyMockTest {

    /**
     * for some reason this test works with `mvn test`, fails in Intellij 2021.1.2
     * does intellij need an updated plugin???
     *
     *
     * easymock has 3 stages
     *  1) creation - this one
     *  2) recording - tell what to do
     *  3) replay - check if mock acted correctly
     *
     *  https://www.baeldung.com/easymock
     *
     *  easymock seems to be creating mock as defined by Martin Fowler...
     *  mocks are "pre-programmed with expectations" - calling replay without
     *  recording - causes
     *   Unexpected method call SupplierService.sells(Product[id=1, name=shoe, price=100.0]):
     *
     *   Mockito does not care by default....
     *   https://stackoverflow.com/questions/46817155/how-do-i-get-mockito-mocks-to-cause-a-failure-when-unexpected-calls-are-made/65710368
     */
    private SupplierService supplierService = mock(SupplierService.class);   //stage1 - create, strict mock (called methods must be recorded before replay

    private ShopService shopService;

    @BeforeEach
    void beforeEach() {
        shopService = new ShopService(supplierService);
    }

    @Test
    void canBuyProduct_failsInIntelliJ() {

        //stage 2 - recording
        expect(supplierService.sells(eq(new Product(1L, "shoe",100.)))) //eq is default, could be omitted
                .andReturn(true);

        replay(supplierService);   //stage 3 - replay   (comment out stage 2 to see an error).
        var productToTest = new Product(1L, "shoe",100.);
        assertTrue(shopService.canBuyProduct(productToTest));
    }
}