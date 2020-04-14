package org.rjae.antipatterns.multipleresponsibility;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class UserTests {
    @Test
    void constructorMustInitializeEmailAddressWhenEmailAddressIsNotNullOrWhitespace() {
        assertEquals("@", new User("Bob", "Smith", "@").getEmailAddress());
    }

    @Test
    void constructorMustInitializeFirstNameWhenFirstNameIsNotNullOrWhitespace() {
        assertEquals("Bob", new User("Bob", "Smith", "@").getFirstName());
    }

    @Test
    void constructorMustInitializeIdWhenIdIsNotNull() {
        UUID uuid = UUID.randomUUID();
        assertEquals(uuid, new User("Bob", "Smith", "@", uuid).getId());
    }

    @Test
    void constructorMustInitializeIdWhenIdIsNull() {
        assertNotNull(new User("Bob", "Smith", "@", null).getId());
    }

    @Test
    void constructorMustInitializeLastNameWhenLastNameIsNotNullOrWhitespace() {
        assertEquals("Smith", new User("Bob", "Smith", "@").getLastName());
    }

    @TestFactory
    Stream<DynamicTest> constructorMustThrowExceptionWhenEmailAddressIsNullOrEmpty() {
        return Stream.of(null, "").map(x -> {
            Executable fact = () -> assertThrows(IllegalArgumentException.class, () -> new User("Bob", "Smith", x));
            return DynamicTest.dynamicTest(String.format("Test: <%s>", x), fact);
        });
    }

    @TestFactory
    Stream<DynamicTest> constructorMustThrowExceptionWhenFirstNameIsNullOrWhitespace() {
        return Stream.of(null, "", "    ", "\t").map(x -> {
            Executable fact = () -> assertThrows(IllegalArgumentException.class, () -> new User(x, "Smith", "@"));
            return DynamicTest.dynamicTest(String.format("Test: <%s>", Objects.equals(x, "\t") ? "tab" : x), fact);
        });
    }

    @TestFactory
    Stream<DynamicTest> constructorMustThrowExceptionWhenLastNameIsNullOrWhitespace() {
        return Stream.of(null, "", "    ", "\t").map(x -> {
            Executable fact = () -> assertThrows(IllegalArgumentException.class, () -> new User("Bob", x, "@"));
            return DynamicTest.dynamicTest(String.format("Test: <%s>", Objects.equals(x, "\t") ? "tab" : x), fact);
        });
    }
}