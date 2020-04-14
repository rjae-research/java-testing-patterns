package org.rjae.patterns.singleresponsibility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTests {
    @Test
    void constructorMustSetIdWhenIdIsNull() {
        assertNotNull(new User(new NonEmptyString("Bob"), new NonEmptyString("Smith"), new EmailAddress("@")).getId());
        assertNotNull(new User(new NonEmptyString("Bob"), new NonEmptyString("Smith"), new EmailAddress("@"), null).getId());
    }

    @Test
    void constructorMustSetFirstNameWhenFirstNameIsNotNull() {
        assertEquals("Bob", new User(new NonEmptyString("Bob"), new NonEmptyString("Smith"), new EmailAddress("@")).getFirstName().getValue());
    }

    @Test
    void constructorMustSetLastNameWhenLastNameIsNotNull() {
        assertEquals("Smith", new User(new NonEmptyString("Bob"), new NonEmptyString("Smith"), new EmailAddress("@")).getLastName().getValue());
    }

    @Test
    void constructorMustSetEmailAddressWhenEmailAddressIsNotNull() {
        assertEquals("@", new User(new NonEmptyString("Bob"), new NonEmptyString("Smith"), new EmailAddress("@")).getEmailAddress().getValue());
    }
}