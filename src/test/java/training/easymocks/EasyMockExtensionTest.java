package training.easymocks;

import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import training.shop.ShopService;
import training.shop.SupplierService;
import training.shop.product.Product;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
public class EasyMockExtensionTest {

    @Mock
    private SupplierService supplierService;

    //@TestSubject // see below
    private ShopService shopService;

    @BeforeEach
    void beforeEach() {
        //[ERROR]   EasyMockExtensionTest.canBuyProduct TestSubject is null and has no default constructor. You need to instantiate 'shopService' manually
        // easymock cannot do constructor based injection...
        //change code or do this in beforeEach
        shopService = new ShopService(supplierService);
    }

    @Test
    void canBuyProduct() {
        expect(supplierService.sells(new Product(1L, "shoe",100.)))
                .andReturn(true);

        replay(supplierService);
        var productToTest = new Product(1L, "shoe",100.);
        assertTrue(shopService.canBuyProduct(productToTest));
    }

// does not work at deeper level
//    @Test
//    void canBuyProduct_withCustomMatcerInRecorder() {
//        expect(supplierService.sells(new Product(eq(2L), eq("shoes"),eq(200.))))
//                .andReturn(true);
//
//        replay(supplierService);
//        var productToTest = new Product(1L, "shoe",100.);
//        assertTrue(shopService.canBuyProduct(productToTest));
//
//    }

    @Test
    void canBuyProduct_WithError() {
        expect(supplierService.sells(new Product(1L, "both shoes",100.)))
                .andThrow(new RuntimeException("nope"));

        replay(supplierService);

        var bothShoes = new Product(1L, "both shoes",100.);

        assertThrows(RuntimeException.class,
            () -> shopService.canBuyProduct(bothShoes)
        );
    }

}
