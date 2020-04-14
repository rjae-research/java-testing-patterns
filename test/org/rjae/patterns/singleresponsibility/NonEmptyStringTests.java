package org.rjae.patterns.singleresponsibility;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NonEmptyStringTests {
    @TestFactory
    Stream<DynamicTest> constructorMustThrowExceptionWhenValueIsNullOrWhitespace() {
        return Stream.of(null, "", "    ", "\t").map(x -> {
            Executable fact = () -> assertThrows(IllegalArgumentException.class, () -> new NonEmptyString(x));
            return DynamicTest.dynamicTest(String.format("Test: <%s>", Objects.equals(x, "\t") ? "tab" : x), fact);
        });
    }

    @Test
    void constructorMustSetValueToValueWhenValueIsNotNullOrWhitespace() {
        assertEquals("42", new NonEmptyString("42").getValue());
        assertEquals("42", new NonEmptyString(" 42 ", true).getValue());
    }
}
