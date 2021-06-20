package training.extensions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WithParamExtensionTest {

    @Test
    @ExtendWith(ParamResolverExtensionForLocalDate.class)
    void testWithProvideDate(LocalDate date) {
        System.out.println("date:"+date);
    }

    @RegisterExtension
    ParamResolverExtensionForLocalDateTime otherApproach = new ParamResolverExtensionForLocalDateTime();

    @Test
    void testWithProvideDateTime(LocalDateTime dateTime) {
        System.out.println("date:"+dateTime);
    }
}
