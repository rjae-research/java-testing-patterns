package org.rjae.patterns.singleresponsibility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailAddressTests {
    @Test
    void constructorMustThrowExceptionWhenValueIsNotValidEmailAddress() {
        assertThrows(IllegalArgumentException.class, () -> new EmailAddress("example at example.com"));
    }

    @Test
    void constructorMustSetValueWhenValueIsValidEmailAddress() {
        assertEquals("example@example.com", new EmailAddress("example@example.com").getValue());
    }
}
