package org.rjae.patterns.singleresponsibility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringBaseTests {
    @Test
    void constructorMustSetValueToNullWhenValueIsNull() {
        assertNull(new StringBase(null, false, false).getValue());
    }

    @Test
    void constructorMustNotSetValueToTrimmedWhenTrimmedIsFalse() {
        assertEquals("    42    ", new StringBase("    42    ", false, false).getValue());
    }

    @Test
    void constructorMustSetValueToTrimmedWhenTrimmedIsTrue() {
        assertEquals("42", new StringBase("    42    ", true, false).getValue());
    }

    @Test
    void equalsMustReturnFalseWhenOtherIsNotStringBase() {
        Object other = "42";
        assertNotEquals(new StringBase("42", false, false), other);
    }

    @Test
    void equalsMustReturnFalseWhenOtherIsNull() {
        assertFalse(new StringBase("42", false, false).equals(null));
    }

    @Test
    void equalsMustReturnTrueWhenValueIsNullAndOtherValueIsNull() {
        assertTrue(new StringBase(null, false, false).equals(new StringBase(null, false, false)));
    }

    @Test
    void equalsMustReturnFalseWhenValueIsNullAndOtherValueIsNotNull() {
        assertFalse(new StringBase(null, false, false).equals(new StringBase("42", false, false)));
    }

    @Test
    void equalsMustReturnFalseWhenCasedIsTrueOrOtherCasedIsTrueAndValueIsNotCaseSensitiveEqualToOtherValue() {
        assertFalse(new StringBase("Bob", false, true).equals(new StringBase("bob", false, false)));
        assertFalse(new StringBase("Bob", false, false).equals(new StringBase("bob", false, true)));
        assertFalse(new StringBase("Bob", false, true).equals(new StringBase("bob", false, true)));
    }

    @Test
    void equalsMustReturnTrueWhenCasedIsTrueOrOtherCasedIsTrueAndValueIsCaseSensitiveEqualToOtherValue() {
        assertTrue(new StringBase("Bob", false, true).equals(new StringBase("Bob", false, false)));
        assertTrue(new StringBase("Bob", false, false).equals(new StringBase("Bob", false, true)));
        assertTrue(new StringBase("Bob", false, true).equals(new StringBase("Bob", false, true)));
    }

    @Test
    void equalsMustReturnFalseWhenCasedIsFalseAndOtherCasedIsFalseAndValueIsNotCaseInsensitiveEqualToOtherValue() {
        assertFalse(new StringBase("Bob", false, false).equals(new StringBase("Alice", false, false)));
    }

    @Test
    void equalsMustReturnTrueWhenCasedIsFalseAndOtherCasedIsFalseAndValueIsCaseInsensitiveEqualToOtherValue() {
        assertTrue(new StringBase("Bob", false, false).equals(new StringBase("bob", false, false)));
    }

    @Test
    void hashCodeMustEqualOtherHashCodeWhenOtherIsEqual() {
        assertEquals(new StringBase("42", false, false), new StringBase("42", false, false));
        assertEquals(new StringBase("42", false, false).hashCode(), new StringBase("42", false, false).hashCode());
    }

    @Test
    void hashCodeMustNotEqualOtherHashCodeWhenOtherIsNotEqual() {
        assertNotEquals(new StringBase("Bob", false, false), new StringBase("Alice", false, false));
        assertNotEquals(new StringBase("Bob", false, false).hashCode(), new StringBase("Alice", false, false).hashCode());
    }
}
