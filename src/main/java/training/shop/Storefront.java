package training.shop;

import java.time.*;
import java.util.Optional;

public class Storefront extends ShopService {

    private final Clock clock;

    public Storefront(SupplierService supplier, Clock clock) {
        super(supplier);
        this.clock = clock;
    }

    public boolean isStoreOpen() {
        return Optional.of(LocalTime.now(clock).atOffset(ZoneOffset.UTC).getHour()).map(
                localHour -> localHour >= 10 && localHour < 18
        ).get();
    }

}
