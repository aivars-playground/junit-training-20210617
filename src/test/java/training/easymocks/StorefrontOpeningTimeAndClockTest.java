package training.easymocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.shop.ShopService;
import training.shop.Storefront;
import training.shop.SupplierService;

import java.time.*;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class StorefrontOpeningTimeAndClockTest {

    private SupplierService supplierService = niceMock(SupplierService.class);   //stage1 - create, strict mock (called methods must be recorded before replay

    Instant fixedTime = LocalDateTime.of(2022,1,1,10,1,1,1).atOffset(ZoneOffset.UTC).toInstant();
    Clock fixedClock = Clock.fixed(fixedTime,ZoneOffset.UTC);

    private Storefront storefront = new Storefront(supplierService,fixedClock);

    @Test
    void isStoreOpen() {
        replay(supplierService);
        assertTrue(storefront.isStoreOpen());
        verify(supplierService);
    }
}